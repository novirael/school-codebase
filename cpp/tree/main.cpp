#include "Tree.h"
#include "Node.h"

#include <iostream>


using namespace std;


int main()
{
    cout << "Drzewo pakowania!\n";

    Tree tree = Tree("   [\"Paleta\", 1, ([\"karton A\", 10, ([\"detal A\", 20, ()], [\"detal B\", 10, ()])], [\"karton B\", 4, ([\"karton D\", 5, ([\"Detal D\", 6, ()],[\"Detal D\", 4, ()])])])],");

    tree.print_tree();
//    tree.print_sumarize();
    Tree* tree2 = new Tree;

    Node* root = new Node();
    root->name = "Ass";
    root->quantity = 0;
    tree2->insert(root);

    Node* node = new Node();
    node->name = "Dupa";
    node->quantity = 1;

    tree2->insert(node, "Ass");
    cout << '\n';
    tree2->print_tree();


//    cout << root->name << '\n';
//    cout << root->childrens[0]->name << '\n';

    return 0;
}