#ifndef _NODE_H_
#define _NODE_H_

#include <iostream>
#include <vector>


using namespace std;


class Node {
private:
    vector <Node*> childrens;

public:
    string name;
    double quantity;

    Node();
    Node(string nam, double qua);
    ~Node();

    vector <Node*> get_children();
    void add_children(Node* children);
    void print();
};

#endif