#ifndef _NODE_H_
#define _NODE_H_

#include <iostream>
#include <vector>


using namespace std;


class Node {
private:
    vector <Node*> childrens;
    string name;
    double quantity;
public:
    Node();
    Node(string nam, double qua);
    ~Node();
};

#endif