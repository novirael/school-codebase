#include "Node.h"


Node::Node() {}

Node::Node(string nam, double qua) {
    name = nam;
    quantity = qua;
}

Node::~Node() {
    for (auto child : childrens) {
        delete child;
    }
    childrens.clear();
}

void Node::add_children(Node* children) {
    childrens.push_back(children);
}

void Node::print() {
    cout << name << " " << quantity << '\n';
}

vector <Node*> Node::get_children() {
    return childrens;
}
