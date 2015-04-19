#include "Hexadecimal.h"
#include "Binary.h"

#include <iostream>


using namespace std;


int main()
{
    cout << "Hexadecimal!\n";
    Hexadecimal l1, l2, l3, l4, l5, l6, l7, l8;

    // 10000
    l1 = Hexadecimal("ffff") + Hexadecimal("1");
    l1.print();

    // fffe
    l2 = Hexadecimal("ffff") - Hexadecimal("1");
    l2.print();

    // 13
    l3 = Hexadecimal("e") + Hexadecimal("5");
    l4.print();
    
    // 9
    l4 = Hexadecimal("e") - Hexadecimal("5");
    l4.print();

    l5 = Hexadecimal("1234");
    l6 = Hexadecimal("abcd");
    l7 = Hexadecimal("12");
    l8 = Hexadecimal("ab");

    // 1a2b3c4d
    l5.shuffle(&l6);
    // a1b2cd
    l6.shuffle(&l7);
    // 1a2bcd
    l7.shuffle(&l6);

    return 0;
}
