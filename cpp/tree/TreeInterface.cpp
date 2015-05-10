#include "TreeInterface.h"
#include "Tree.h"
#include "Node.h"
#include <iostream>


using namespace std;


TreeInterface::TreeInterface() {
    execute();
}

void TreeInterface::execute() {
    char key;
    string input;
    Node* node;
    bool repeat = true;
    Tree* tree = new Tree();

    show_options();

    while (repeat) {
        getline(cin, input);
        key = input[0];
        switch(key) {
            case '0'  :
                show_options();
                break;
            case '1'  :
                cout << "Tree:" << '\n';
                tree->print_tree();
                break;
            case '2':
                cout << "Creating new tree" << '\n';
                cout << "Write word with proper synatax" << '\n';
                getline(cin, input);
                delete tree;
                tree = new Tree((string)input);
                break;
            case '3':
                cout << "Adding new node" << '\n';
                node = new Node();
                cout << "Write item name" << '\n';
                getline(cin, input);
                node->name = input;
                cout << "Write item quantity" << '\n';
                getline(cin, input);
                node->quantity = strtod(input.c_str(), 0);
                cout << "Write parent (or miss empty for root)" << '\n';
                getline(cin, input);
                tree->insert(node, input);
                break;
            case '4':
                cout << "Get item quantity" << '\n';
                cout << "Write item name" << '\n';
                getline(cin, input);
                cout << input;
                tree->print_item_quantity(input.substr(0, input.length() - 1));
                break;
            case '5':
                cout << "Summarize:" << '\n';
                tree->print_sumarize();
                break;
            case '6':
                cout << "Leafs:" << '\n';
                tree->print_leafs();
                break;
            case '7':
                delete tree;
                tree = new Tree();
                cout << "Tree is clean\n";
                break;
            case '8':
                repeat = false;
                break;
            default:
                cout << "Invalid key\n";
                show_options();
                break;
        }
    }
}

void TreeInterface::show_options() {
    string text =
            "\n0: Show available options"
            "\n1: Show tree"
            "\n2: Create new tree"
            "\n3: Add new node"
            "\n4: Find node"
            "\n5: Show summarize"
            "\n6: Show leafs"
            "\n7: Clear"
            "\n8: Quit";
    cout << text << '\n';
}
