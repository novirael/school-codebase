#!/usr/bin/python3

import sys
import os
import string
import argparse
import logging

from math import ceil
from getpass import getpass

from PyQt5.QtWidgets import (
    QWidget,
    QToolTip,
    QPushButton,
    QApplication,
    QLineEdit, QFileDialog, QMessageBox, QLabel)

log = logging.getLogger(__name__)


logging.basicConfig(
    format='%(levelname)s: %(name)s:%(lineno)s: %(message)s',
    stream=sys.stdout,
    level=logging.ERROR,
)


class Encryption(object):
    alphabet = "".join(chr(x) for x in range(128))
    data = None
    key = ''
    extra_chars = ''

    def __init__(self, file_path, password):
        self.file_path = file_path
        self.password = password

    def read(self):
        log.info("Reading file: %r", self.file_path)
        with open(self.file_path, 'r') as file:
            self.data = file.read()
        log.debug("Data: %s", self.data)

    def save(self, postfix=""):
        log.info("Saving file: %r", self.file_path + postfix)
        with open(self.file_path + postfix, 'w+') as file:
            file.seek(0)
            file.write(self.data)
        log.debug("Data: %s", self.data)

    def get_blocks(self, blocks_amount, block_size):
        log.info("Preparing blocks.")
        log.debug(
            "Splitting data to %d blocks with size of %d characters",
            blocks_amount, block_size
        )

        blocks = []
        for i in range(blocks_amount):
            chunk = self.data[i*block_size:(i+1)*block_size]

            # Last block will be filled in with  first letters
            if len(chunk) < block_size:
                missing_chars = '.' * (block_size - len(chunk))
                log.debug(
                    "Filling in last block with characters: %s",
                    missing_chars
                )
                chunk += missing_chars

            blocks.append(chunk)

        log.debug("Blocks: \n%s", '\n'.join(blocks))
        return blocks

    def make_permutation(self):
        log.info("Making permutation.")

        data_length, blocks_amount = len(self.data), len(self.password)
        block_size = int(ceil(data_length / blocks_amount))
        blocks = self.get_blocks(blocks_amount, block_size)
        new_data = ''

        for idx in range(block_size):
            for block in blocks:
                new_data += block[idx]

        self.data = new_data
        log.debug("New data: %s", self.data)

    def revert_permutation(self):
        log.info("Reverting permutation.")

        block_size = len(self.password)
        blocks_amount = int(ceil(len(self.data) / block_size))
        blocks = self.get_blocks(blocks_amount, block_size)
        new_data = ''

        for idx in range(block_size):
            for block in blocks:
                if block[idx] != '.':
                    new_data += block[idx]

        self.data = new_data
        log.debug("New data: %s", self.data)

    def generate_key(self):
        log.info("Generating key.")

        data_length = len(self.data)
        repeat_times = int(ceil(data_length / len(self.password)))

        log.debug("Data length: %s", data_length)

        for idx in range(0, repeat_times + 1):
            for letter in self.password:
                new_letter_idx = self.alphabet.index(letter) + idx**2
                new_letter_idx %= len(self.alphabet)
                self.key += self.alphabet[new_letter_idx]

        self.key = self.key[:data_length]
        log.debug("Key length: %r", len(self.key))
        log.debug("Using key: %r", self.key)

    def make_polymorphism(self):
        log.info("Polymorphism.")

        data_indexes = [
            self.alphabet.index(letter)
            for letter in self.data
        ]
        log.debug("Data indexes: %s", data_indexes)

        key_indexes = [
            self.alphabet.index(letter)
            for letter in self.key
        ]
        log.debug("Key indexes: %s", key_indexes)

        sum_indexes = [
            data_indexes[i] + key_indexes[i]
            for i in range(len(self.data))
        ]
        log.debug("New data indexes: %s", sum_indexes)

        alphabet_length = len(self.alphabet)
        self.data = ''.join(
            self.alphabet[idx % alphabet_length]
            for idx in sum_indexes
        )
        log.debug("New data: %s", self.data)

    def revert_polymorphism(self):
        log.info("Polymorphism. Data: %r", self.data)

        data_indexes = [
            self.alphabet.index(letter)
            for letter in self.data
        ]
        log.debug("Data indexes: %s", data_indexes)

        key_indexes = [
            self.alphabet.index(letter)
            for letter in self.key
        ]
        log.debug("Key indexes: %s", key_indexes)

        sum_indexes = [
            data_indexes[i] - key_indexes[i]
            for i in range(len(self.data))
        ]
        log.debug("New data indexes: %s", sum_indexes)

        alphabet_length = len(self.alphabet)
        self.data = ''.join(
            self.alphabet[idx if idx < alphabet_length else alphabet_length - idx]
            for idx in sum_indexes
        )

        log.debug("New data: %s", self.data)

    def encode(self):
        self.read()
        self.make_permutation()
        self.generate_key()
        self.make_polymorphism()
        os.remove(self.file_path)
        self.save()

    def decode(self):
        self.read()
        self.generate_key()
        self.revert_polymorphism()
        self.revert_permutation()
        self.save(postfix='-decrypted')


class Example(QWidget):
    
    def __init__(self):
        super(Example, self).__init__()

        self.initUI()

    def initUI(self):

        input_label = QLabel("Select file path", self)
        input_label.move(50, 25)

        self.input_filepath = QLineEdit(self)
        self.input_filepath.move(50, 50)
        self.input_filepath.setReadOnly(True)
        self.input_filepath.resize(225, 20)

        btn_upload = QPushButton('Select', self)
        btn_upload.move(285, 45)
        btn_upload.clicked.connect(self.handle_upload)

        input_label = QLabel("Insert your password", self)
        input_label.move(50, 80)

        self.input_pwd = QLineEdit(self)
        self.input_pwd.setEchoMode(QLineEdit.Password)
        self.input_pwd.move(50, 105)
        self.input_pwd.resize(225, 20)

        btn = QPushButton('Encryption', self)
        btn.move(175, 150)
        btn.clicked.connect(self.handle_encode)

        btn = QPushButton('Decryption', self)
        btn.clicked.connect(self.handle_decode)
        btn.move(50, 150)

        btn = QPushButton('Info', self)
        btn.clicked.connect(self.handle_info)
        btn.move(300, 150)

        self.setGeometry(500, 500, 400, 220)
        self.setWindowTitle('Code')
        self.show()

    def validate_inputs(self):
        if not self.input_filepath.text() or not self.input_pwd.text():
            msg = QMessageBox(self)
            msg.setIcon(QMessageBox.Warning)
            msg.setText("You should provide file path and password.")
            msg.setWindowTitle("Validation")
            msg.exec_()
            return False
        return True

    def handle_encode(self):
        if self.validate_inputs():
            enc = Encryption(
                self.input_filepath.text(),
                self.input_pwd.text()
            )
            enc.encode()

            self.input_pwd.setText("")
            self.input_filepath.setText("")

            msg = QMessageBox(self)
            msg.setIcon(QMessageBox.Information)
            msg.setText("File encrypted")
            msg.setWindowTitle("Encryption")
            msg.exec_()

    def handle_decode(self):
        if self.validate_inputs():
            enc = Encryption(
                self.input_filepath.text(),
                self.input_pwd.text()
            )
            enc.decode()

            self.input_pwd.setText("")
            self.input_filepath.setText("")

            msg = QMessageBox(self)
            msg.setIcon(QMessageBox.Information)
            msg.setText("File decrypted")
            msg.setWindowTitle("Decryption")
            msg.exec_()

    def handle_info(self):
        msg = QMessageBox(self)
        msg.setIcon(QMessageBox.Information)
        msg.setText(
            "1. Decoded or Encoded file is saved in the same directory as you select file.\n"
            "2. Newly created file has '-decoded' or '-encoded' prefix.\n"
            "3. Key should be non empty ascii value.\n"
        )
        msg.setWindowTitle("Info")
        msg.exec_()

    def handle_upload(self):
        filename = QFileDialog.getOpenFileName(
            self, "File", "."
        )
        if filename[0]:
            self.input_filepath.setText(filename[0])
            log.debug('Path file :', filename)
        self.show()


if __name__ == '__main__':
    app = QApplication(sys.argv)
    ex = Example()
    app.exec_()
