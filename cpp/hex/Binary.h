#ifndef _BINARY_H_
#define _BINARY_H_

#include <iostream>

using namespace std;

class Binary {
public:
    Binary();
    Binary(string n);
    static string hex_to_binary(string hex);
    static string align_with_zeros(string value, int pos_qua);
    void print();
    string get_value();
    string add(string value);
    string sub(string value);
    string multi(string value);
private:
    string number;
};

#endif
