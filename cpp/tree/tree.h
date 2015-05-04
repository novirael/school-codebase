#ifndef _TREE_H_
#define _TREE_H_

#include "Node.h"
#include <iostream>


using namespace std;


class Tree {
private:
    Node* root;
public:
    Tree();
    Tree(Node* node);

    int validate(string word);
    void parse();
    
    static string split(string word, string by_letters);
    static int get_bracket_end(string word, string brackets);
    static int get_bracket_end(string word, string brackets, int first);
    static int get_bracket_begin(string word, string brackets);
};

#endif
