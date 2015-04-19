#ifndef _HEXADECIMAL_H_
#define _HEXADECIMAL_H_

#include "Binary.h"
#include <iostream>

using namespace std;


class Hexadecimal {

public:
    Binary binary;

    Hexadecimal();
    Hexadecimal(string n);
    Hexadecimal(Binary bin);

    static string binary_to_hex(string bin);
    void print();
    string get_value();

    Hexadecimal operator + (Hexadecimal n);
    Hexadecimal add(Hexadecimal value);

    Hexadecimal operator - (Hexadecimal n);
    Hexadecimal sub(Hexadecimal value);

    Hexadecimal operator * (Hexadecimal n);
    Hexadecimal multi(Hexadecimal value);
    
    void shuffle(Hexadecimal *n);

private:
    string allowed_signs, number;
};

#endif
