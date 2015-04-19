#include "LiczbaHex.h"
#include "Binary.h"

#include <iostream>


using namespace std;


int main()
{
    cout << "Hexadecimal!\n";
    Binary l1;
    LiczbaHex l2;
    l2 = LiczbaHex("fffffffffffffffffffffffff");
    l2.print();
    l2.add("1");
    l2.print();
    return 0;
}
