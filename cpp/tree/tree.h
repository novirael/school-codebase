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
    Tree(string word);

    bool is_valid(string word);
    void parse(string word);
    
    static string split(string word, string by_letters);
    static unsigned long get_bracket_end(string word, string brackets);
    static unsigned long get_bracket_end(string word, string brackets, unsigned long first);
};

#endif
