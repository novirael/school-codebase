#include "Binary.h"

#include <iostream>

using namespace std;


Binary::Binary() {
    number = "0000";
}
Binary::Binary(string n) {
     number = n;
}

string Binary::hex_to_binary(string hex) {
    string binary_rep = "";
    string allowed_hex = "0123456789abcdef";
    string tab[16] = {
        "0000", "0001", "0010", "0011",
        "0100", "0101", "0110", "0111",
        "1000", "1001", "1010", "1011",
        "1100", "1101", "1110", "1111",
    };
    for (int it=0; it < hex.length(); it++) {
        int index = allowed_hex.find(hex[it]);
        binary_rep.append(tab[index]);
    }
    return binary_rep;
}

string Binary::align_with_zeros(string value, int pos_qua) {
    string zeros = "";
    for (int i=0; i < pos_qua; i++) {
        zeros.append("0");
    }
    return value.insert(0, zeros);
}

void Binary::print() {
   cout << number << "\n";
}
string Binary::get_value() {
   return number;
}
string Binary::add(string value) {
    string result = "";
    int excess = 0;
    if (value.length() < number.length()){
        value = align_with_zeros(value, number.length() - value.length());
    }
    else {
        number = align_with_zeros(number, value.length() - number.length());
    }

    for (int it=number.length(); it >= 0; it--) {
        if (number[it] == '0' && value[it] == '0') {
            result.insert(0, "0");
        } 
        else {
            if (number[it] == '1' && value[it] == '1') {
                excess += 1;
            }
            if (excess % 2 == 0) {
                result.insert(0, "0");
            }
            else {
                result.insert(0, "1");
            }
            excess -= 2;
        }
    }

    if (result.length() % 4 != 0) {
        result = align_with_zeros(result, 4 - (result.length() % 4));
    }
    
    number = result;
    return result;
}
string Binary::sub(string value) {
    return value;
}
string Binary::multi(string value) {
    return value;
}
