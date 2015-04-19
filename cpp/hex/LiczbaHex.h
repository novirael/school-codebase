#ifndef _LICZBAHEX_H_
#define _LICZBAHEX_H_

#include "Binary.h"
#include <iostream>

using namespace std;

class LiczbaHex {
public:
    LiczbaHex();
    LiczbaHex(string n);
    static string binary_to_hex(string bin);
    void print();
    string add(string value);
    string sub(string value);
    string multi(string value);
private:
    string allowed_signs;
    string tab1, tab2;
    Binary binary;
    string number;
};

#endif
