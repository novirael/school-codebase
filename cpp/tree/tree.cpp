#include "Tree.h"

#include <iostream>
#include <string>
#include <vector>


using namespace std;


Tree::Tree() {
    root = nullptr;
}
Tree::Tree(Node* node) {
    root = node;
}
Tree::Tree(string word) {
    if (is_valid(word)) {
        parse(word);
    } else {
        cout << "cannot parse\n";
        root = nullptr;
    }
}
Tree::~Tree() {
    delete root;
}

int Tree::count(Node* node, string name) {
    int q = 0;
    if (node->name == name) { q++; }
    vector <Node*> children = node->get_children();
    for(int i=0; i <children.size(); i++) {
        q += count(children[i], name);
    }
    return q;
}


Node* Tree::find(string name) {
    if (count(root, name) == 1) {
        return find(root, name);
    }
    else {
        return nullptr;
    }
}

Node* Tree::find(Node* node, string name) {
    if (node->name == name) {
        return node;
    }
    else {
        vector <Node*> children = node->get_children();
        for(int i=0; i <children.size(); i++) {
            return find(children[i], name);
        }
    }
    return nullptr;
}


void Tree::insert(Node* node) {
    if (root == nullptr) {
        root = node;
    }
    else {
        cout << "root exists\n";
    }
}

void Tree::insert(Node* node, Node* parent) {
    if (!parent) {
        root = node;
    }
    else {
        parent->add_children(node);
    }
}

void Tree::insert(Node* node, string name) {
    Node* parent = find(name);
    if (parent == nullptr) {
        cout << "not found " << name << "\n";
    } else {
        insert(node, parent);
    }
}


bool Tree::is_valid(string sentence) {
    vector <string> items;
    string objects;
    unsigned long pos;

    bool result = true;
    string word = split(sentence, " \n\t");
    unsigned long first = 0;
    unsigned long last = get_bracket_end(word, "[]");

    if (word[0] != '[' || last == 0) {
        return false;
    }

    while (first < word.length() && word[first] == '[' && last != 0) {
        items.push_back(word.substr(first, last + 1));
        first = last + 2; // miss comma
        last = get_bracket_end(word, "[]", first);

    }
    for(int i=0; i < items.size(); i++) {
        word = items[i];                               // focus on particular word parts
        last = get_bracket_end(word, "[]");            // get last pos of brackets

        if (word[0] != '[' || last == 0) {             // check brackets
            return false;
        }

        word = word.substr(1, last - 1);               // miss brackets
        pos = word.find(',');                          // get comma pos

        if (word[0] != '"' || word[pos - 1] != '"') {  // check quotes
            return false;
        }

        word = word.substr(pos + 1);                   // miss name and comma
        pos = word.find(',');                          // get comma pos
        word = word.substr(pos + 1);                   // miss comma
        last = get_bracket_end(word, "()");            // get last pos of brackets

        if (word[0] != '(' || last == 0) {             // check round brackets
            return false;
        }

        objects = word.substr(1, last - 1);            // miss brackets

        if (objects != "") {
            result &= is_valid(objects);
        }
    }
    return result;
}


void Tree::parse(string sentence) {
    parse(sentence, nullptr);
}

void Tree::parse(string sentence, Node* parent) {
    Node* node;
    vector <string> items;
    string name, objects;
    double quantity;
    unsigned long pos;

    string word = split(sentence, " \n\t");
    unsigned long first = 0;
    unsigned long last = get_bracket_end(word, "[]");

    while (first < word.length() && word[first] == '[' && last != 0) {
        items.push_back(word.substr(first, last + 1));
        first = last + 2; // miss comma
        last = get_bracket_end(word, "[]", first);
    }

    for(int i=0; i < items.size(); i++) {
        word = items[i];                       // focus on particular word parts
        last = get_bracket_end(word, "[]");    // get last pos of brackets
        word = word.substr(1, last - 1);       // miss brackets
        pos = word.find(',');                  // get comma pos
        name = word.substr(1, pos - 2);        // get name without quotes
        word = word.substr(pos + 1);           // miss name and comma
        pos = word.find(',');                  // get comma pos
        quantity = strtod(word.substr(0, pos).c_str(), NULL); // get quantity
        word = word.substr(pos + 1);           // miss comma
        last = get_bracket_end(word, "()");    // get last pos of brackets
        objects = word.substr(1, last - 1);    // miss brackets

        // Create new node
        node = new Node(name, quantity);
        // Insert new node
        insert(node, parent);

        // Parse remaining objects
        if (objects != "") {
            parse(objects, node);
        }
    }
}

void Tree::print_sumarize() {
    map <string, double> m_items;
    m_items = count_items(m_items, root);
    for (auto it=m_items.begin(); it!=m_items.end(); ++it) {
        cout << it->first << " : " << it->second << '\n';
    }

}

map<string, double> Tree::count_items(map<string, double> items, Node* node) {
    if (items.count(node->name) > 0) {
        items[node->name] += node->quantity;
    }
    else {
        items[node->name] = node->quantity;
    };

    vector <Node*> children = node->get_children();
    for(int i=0; i <children.size(); i++) {
        items = count_items(items, children[i]);
    }
    return items;
}


void Tree::print_tree() {
    print_object(root, 0);
}

void Tree::print_object(Node* node, int offset) {
    offset++;
    string indent = "";

    for (int j=0; j < offset; j++) {
        indent += " ";
    }

    cout << indent << node->name << " " << node->quantity;

    vector <Node*> children = node->get_children();
    for(int i=0; i <children.size(); i++) {
        print_object(children[i], offset);
    }
}


string Tree::split(string word, string by_letters) {
    string splitted_word = "";
    bool under_quote = false;

    for (int i=0; i<word.length(); i++) {
        if (word[i] == '"') {
            under_quote = !under_quote;
        }
        // miss under quote letters
        if (under_quote || by_letters.find(word[i]) == string::npos) {
            splitted_word += word[i];
        }
    }
    return splitted_word;
}

unsigned long Tree::get_bracket_end(string word, string brackets, unsigned long first=0) {
    int counter = 0;
    for (unsigned long it=first; it < word.length(); it++) {
        if (word[it] == brackets[0]) counter++;
        else if (word[it] == brackets[1]) counter--;
        if (word[it] == brackets[1] && counter == 0)
            return it;
    }
    return 0;
}

unsigned long Tree::get_bracket_end(string word, string brackets) {
    int counter = 0;
    for (unsigned long it=0; it < word.length(); it++) {
        if (word[it] == brackets[0]) counter++;
        else if (word[it] == brackets[1]) counter--;
        if (word[it] == brackets[1] && counter == 0)
            return it;
    }
    return 0;
}
