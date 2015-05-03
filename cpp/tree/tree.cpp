#include "Tree.h"

#include <iostream>
#include <string>


using namespace std;


Tree::Tree() {
    root = NULL;
}
Tree::Tree(Node* node) {
    root = node;
}


string Tree::split(string word, string by_letters) {
    string splitted_word = "";
    bool under_quote = false;

    for (int i=0; i<word.length(); i++) {
        if (word[i] == '"') {
            under_quote = !under_quote;
        }
        // miss under quote letters
        if (under_quote == true || by_letters.find(word[i]) == string::npos) {
            splitted_word += word[i];
        }
    }
    return splitted_word;
}

int Tree::get_bracket_end(string word, string brackets) {
    int counter = 0;
    for (int it=0; it < word.length(); it++) {
        if (word[it] == brackets[0]) counter++;
        else if (word[it] == brackets[1]) counter--;
        if (word[it] == brackets[1] && counter == 0)
            return it;
    }
    return -1;
}
int Tree::get_bracket_begin(string word, string brackets) {
    if (word.find('[') == string::npos)
        return -1;
    return word.find('[');
}

int Tree::validate(string word) {
    string splitted_word = split(word, " \n\t");
    int len = splitted_word.length(), pos;
    string name, quantity, objects;

    // check brackets 
    if (splitted_word[0] != '[' || get_bracket_end(splitted_word, "[]") == -1) {
        return -1;
    }

    // miss brackets
    splitted_word = splitted_word.substr(1, get_bracket_end(splitted_word, "[]") - 1);

    // get comma pos
    pos = splitted_word.find(',');

    // check quotes
    if (splitted_word[0] != '"' || splitted_word[pos - 1] != '"') {
        return -1;
    }

    // get name without quotes
    name = splitted_word.substr(1, pos - 2);
    cout << name << ' ';

    // miss name and comma 
    splitted_word = splitted_word.substr(pos + 1);

    // get comma pos
    pos = splitted_word.find(',');

    // get quantity
    quantity = splitted_word.substr(0, pos);
    cout << quantity << ' ';

    // miss comma
    splitted_word = splitted_word.substr(pos + 1);

    // check roundbrackets 
    if (splitted_word[0] != '(' || get_bracket_end(splitted_word, "()") == -1) {
        return -1;
    }

    // miss brackets
    objects = splitted_word.substr(1, get_bracket_end(splitted_word, "()") - 1);
    cout << objects << '\n';

    validate(objects);
    
    return 0;    
}
