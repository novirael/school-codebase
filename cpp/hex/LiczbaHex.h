#ifndef _LICZBAHEX_H_
#define _LICZBAHEX_H_

#include "Binary.h"
#include <iostream>

using namespace std;


class LiczbaHex {

public:
    Binary binary;

    LiczbaHex();
    LiczbaHex(string n);
    LiczbaHex(Binary bin);

    static string binary_to_hex(string bin);
    void print();
    string get_value();

    LiczbaHex operator + (LiczbaHex n);
    LiczbaHex add(LiczbaHex value);

    LiczbaHex operator - (LiczbaHex n);
    LiczbaHex sub(LiczbaHex value);

    LiczbaHex operator * (LiczbaHex n);
    LiczbaHex multi(LiczbaHex value);

private:
    string allowed_signs;
};

#endif
