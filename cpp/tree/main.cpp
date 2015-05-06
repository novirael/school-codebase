#include "Tree.h"
#include "Node.h"

#include <iostream>


using namespace std;


int main()
{
    cout << "Drzewo pakowania!\n";

    Tree("   [\"Paleta\", 1, ([\"karton A\", 10, ([\"detal A\", 20, ()], [\"detal B\", 10, ()])], [\"karton B\", 4, ([\"karton D\", 5, ([\"Detal D\", 6, ()])])])]");

    return 0;
}