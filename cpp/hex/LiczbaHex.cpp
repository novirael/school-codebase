#include "LiczbaHex.h"
#include "Binary.h"

#include "IncorrectValueException.h"

#include <iostream>
#include <string>

using namespace std;


LiczbaHex::LiczbaHex() {
    binary = Binary();
}
LiczbaHex::LiczbaHex(string num) {
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
}

string LiczbaHex::binary_to_hex(string bin) {
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

void LiczbaHex::print() {
    cout << "0x" << binary_to_hex(binary.get_value()) << '\n';
}
string LiczbaHex::add(string value) {
    return binary_to_hex(binary.add(value));
}
string LiczbaHex::sub(string value) {
    return binary_to_hex(binary.sub(value));
}
string LiczbaHex::multi(string value) {
    return binary.multi(value);
}
