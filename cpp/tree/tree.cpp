#include "Tree.h"

#include <iostream>
#include <string>
#include <vector>


using namespace std;


Tree::Tree() {
    root = NULL;
}
Tree::Tree(Node* node) {
    root = node;
}
Tree::Tree(string word) {
    if (is_valid(word)) {
        parse(word);
    } else {
        cout << "Cannot parse\n";
        root = NULL;
    }
}


void Tree::parse(string word) {
    root = NULL;
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

unsigned long Tree::get_bracket_end(string word, string brackets, unsigned long first) {
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

bool Tree::is_valid(string sentence) {
    string name, quantity, objects;
    vector <string> items;
    unsigned long pos;

    string word = split(sentence, " \n\t");
    bool result = true;
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
        word = items[i];
        last = get_bracket_end(word, "[]");

        // check brackets
        if (word[0] != '[' || last == 0) {
            return false;
        }

        // miss brackets
        word = word.substr(1, last - 1);

        // get comma pos
        pos = word.find(',');

        // check quotes
        if (word[0] != '"' || word[pos - 1] != '"') {
            return false;
        }

        // get name without quotes
        name = word.substr(1, pos - 2);

        // miss name and comma 
        word = word.substr(pos + 1);

        // get comma pos
        pos = word.find(',');

        // get quantity
        quantity = word.substr(0, pos);

        // miss comma
        word = word.substr(pos + 1);

        last = get_bracket_end(word, "()");
        // check round brackets
        if (word[0] != '(' || last == 0) {
            return false;
        }

        // miss brackets
        objects = word.substr(1, last - 1);

        if (objects != "") {
            result &= is_valid(objects);
        }
    }

    return result;
}
