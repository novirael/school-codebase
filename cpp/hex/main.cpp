#include "LiczbaHex.h"
#include "Binary.h"

#include <iostream>


using namespace std;


int main()
{
    cout << "Hexadecimal!\n";
    LiczbaHex l1, l2, l3, l4;

    l1 = LiczbaHex("fffffffffffffffffffffffff");
    l2 = LiczbaHex("1");

    l3 = l1 + l2;
    l3.print();

    l4 = LiczbaHex("ffff") + LiczbaHex("1");
    l4.print();

    return 0;
}
