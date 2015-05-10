#ifndef _TREE_H_
#define _TREE_H_

#include "Node.h"
#include <iostream>
#include <map>


using namespace std;


class Tree {

private:
    Node* root;

    bool is_valid(string word);
    void parse(string sentence, Node* parent);
    int count(Node* node, string name);

    void print_object(Node* node, int offset);

    map<string, double> count_items(map <string, double> items, Node* node);

public:
    Tree();
    Tree(Node* node);
    Tree(string word);
    ~Tree();

    void insert(Node* node);
    void insert(Node* node, Node* parent);
    void insert(Node* node, string name);

    Node* find(string name);
    Node* find(Node* node, string name);

    void parse(string sentence);

    void print_sumarize();
    void print_tree();

    static string split(string word, string by_letters);
    static unsigned long get_bracket_end(string word, string brackets);
    static unsigned long get_bracket_end(string word, string brackets, unsigned long first);
};

#endif
