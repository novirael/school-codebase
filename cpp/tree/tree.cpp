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

int Tree::get_bracket_end(string word, string brackets, int first) {
    int counter = 0;
    for (int it=first; it < word.length(); it++) {
        if (word[it] == brackets[0]) counter++;
        else if (word[it] == brackets[1]) counter--;
        if (word[it] == brackets[1] && counter == 0)
            return it;
    }
    return -1;
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

bool Tree::validate(string word) {
    string splitted_word = split(word, " \n\t");
    
    int len = splitted_word.length(), pos, first, last;
    string name, quantity, objects;
    vector <string> items;
    bool result = true;
    first = 0;
    last = get_bracket_end(splitted_word, "[]");

    if (splitted_word[0] != '[' || last == -1) {
        return false;
    }

    while (first < splitted_word.length() && splitted_word[first] == '[' && last != -1) {
        items.push_back(splitted_word.substr(first, last + 1));
        first = last + 2; // except 
        last = get_bracket_end(splitted_word, "[]", first);

    }
    for(int i=0; i < items.size(); i++) {
        splitted_word = items[i];

        // check brackets
        if (splitted_word[0] != '[' || get_bracket_end(splitted_word, "[]") == -1) {
            return false;
        }

        // miss brackets
        splitted_word = splitted_word.substr(1, get_bracket_end(splitted_word, "[]") - 1);

        // get comma pos
        pos = splitted_word.find(',');

        // check quotes
        if (splitted_word[0] != '"' || splitted_word[pos - 1] != '"') {
            return false;
        }

        // get name without quotes
        name = splitted_word.substr(1, pos - 2);

        // miss name and comma 
        splitted_word = splitted_word.substr(pos + 1);

        // get comma pos
        pos = splitted_word.find(',');

        // get quantity
        quantity = splitted_word.substr(0, pos);

        // miss comma
        splitted_word = splitted_word.substr(pos + 1);

        // check roundbrackets 
        if (splitted_word[0] != '(' || get_bracket_end(splitted_word, "()") == -1) {
            return false;
        }

        // miss brackets
        objects = splitted_word.substr(1, get_bracket_end(splitted_word, "()") - 1);

        if (objects != "") {
            result &= validate(objects);
        }
    }

    return result;
}
