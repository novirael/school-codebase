#include "Hexadecimal.h"
#include "Binary.h"

#include "IncorrectValueException.h"

#include <iostream>
#include <string>

using namespace std;


Hexadecimal::Hexadecimal() {
    binary = Binary();
    number = 'f';
}
Hexadecimal::Hexadecimal(Binary bin) {
    binary = bin;
    number = 'f';
}
Hexadecimal::Hexadecimal(string num) {
    allowed_signs = "0123456789abcdef"; 
    try {
        for (int it=0; it < num.length(); it++) {
            if (allowed_signs.find(num[it]) == string::npos) {
                throw IncorrectValueException();
            }
        }
    }
    catch(IncorrectValueException& caught){
        cout << caught.what() << endl;
        return;
    }

    binary = Binary(Binary::hex_to_binary(num));
    number = num;
}

string Hexadecimal::binary_to_hex(string bin) {
    string hex_rep = "";
    string allowed_hex = "0123456789abcdef";
    string tab[16] = {
        "0000", "0001", "0010", "0011",
        "0100", "0101", "0110", "0111",
        "1000", "1001", "1010", "1011",
        "1100", "1101", "1110", "1111",
    };
    // Assume bin.length() mod 4 == 0
    for (int it=0; it < bin.length(); it+=4) {
        for (int index=0; index < 16; index++) {
            if (bin.substr(it, 4) == tab[index]) {
                hex_rep += allowed_hex[index];
            }
        }
    }
    return hex_rep;
}

void Hexadecimal::print() {
    cout << "0x" << binary_to_hex(binary.get_value()) << '\n';
}
string Hexadecimal::get_value() {
    return binary_to_hex(
        binary.get_value()
    );
}

Hexadecimal Hexadecimal::operator+ (Hexadecimal value) {
    return add(value);
}
Hexadecimal Hexadecimal::add(Hexadecimal value) {
    return Hexadecimal(binary + value.binary);
}

Hexadecimal Hexadecimal::operator- (Hexadecimal value) {
    return sub(value);
}
Hexadecimal Hexadecimal::sub(Hexadecimal value) {
    return Hexadecimal(binary - value.binary);
}

Hexadecimal Hexadecimal::operator* (Hexadecimal value) {
    return multi(value);
}
Hexadecimal Hexadecimal::multi(Hexadecimal value) {
    return Hexadecimal(binary * value.binary);
}


void Hexadecimal::shuffle(Hexadecimal *n) {
    string result = "";
    int limit = n -> number.length() > number.length() ? n -> number.length() : number.length();
    for (int it=0; it < limit; it++) {
        if (number.length() > it) {
            result += number[it];
        }
        if (n -> number.length() > it) {
            result += n -> number[it];
        }
    }
    cout << result << '\n';
}
