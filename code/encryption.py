#!/usr/bin/python

import sys
import string
import argparse
import logging

from math import ceil
from getpass import getpass

log = logging.getLogger(__name__)


logging.basicConfig(
    format='%(levelname)s: %(name)s:%(lineno)s: %(message)s',
    stream=sys.stdout,
    level=logging.DEBUG,
)


class Encryption(object):
    alphabet = string.ascii_letters
    data = None
    key = ''

    def __init__(self, file_path, password):
        self.file_path = file_path
        self.password = password

    def read(self):
        log.info("Reading file: %r", self.file_path)
        with open(self.file_path, 'r') as file:
            self.data = file.read()
        log.debug("Data: %s", self.data)

    def save(self):
        log.info("Saving file: %r", self.file_path)
        with open(self.file_path, 'r+') as file:
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
                missing_chars = self.data[:block_size - len(chunk)]
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

        block_size = len(password)
        blocks_amount = int(ceil(len(self.data) / block_size))
        blocks = self.get_blocks(blocks_amount, block_size)
        new_data = ''

        for idx in range(block_size):
            for block in blocks:
                new_data += block[idx]

        self.data = new_data
        log.debug("New data: %s", self.data)

    def generate_key(self):
        log.info("Generating key.")

        data_length = len(self.data)
        repeat_times = int(ceil(data_length / len(password)))

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
        self.save()

    def decode(self):
        self.read()
        self.generate_key()
        self.revert_polymorphism()
        self.revert_permutation()
        self.save()


if __name__ == "__main__":
    parser = argparse.ArgumentParser(description='File encryption')
    parser.add_argument('file_path', help='File location')
    parser.add_argument('--encode', help='Encode', action='store_false')
    parser.add_argument('--decode', help='Decode', action='store_false')
    args = parser.parse_args()

    password = getpass()
    enc = Encryption(args.file_path, password)

    if args.decode:
        enc.decode()
    elif args.encode:
        enc.encode()
