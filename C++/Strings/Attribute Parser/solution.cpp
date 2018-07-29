#include <string>
#include <map>
#include <vector>
#include <iostream>

using namespace std;

string tagName(string str) {
    str = str.substr(str.at(1) == '/' ? 2 : 1);
    int pos = str.find(' ');
    return str.substr(0, pos > 0 ? pos : str.length() - 1);
}

vector<string> attributeNames(const string &str) {
    vector<string> attributes;
    unsigned int pos = 0;
    unsigned int offs;

    while ((offs = str.find('=', pos)) < str.length()) {
        unsigned int i = str.substr(0, offs - 1).rfind(' ');
        attributes.push_back(str.substr(i + 1, offs - i - 2));
        pos += offs + 1;
    }

    return attributes;
}

string attributeValue(const string &str, const string &name) {
    unsigned int offs = str.find(name + " = ") + name.length() + 4;
    return str.substr(offs, str.find('"', offs) - offs);
}

int main() {
    int N = 0;
    int Q = 0;
    cin >> N >> Q;

    map<string, string> map;
    vector<string> tags;
    string str;

    for (int i = 0; i < N; i++) {
        cin >> ws;
        getline(cin, str);

        if ("</" != str.substr(0, 2)) {
            string tag = (tags.empty() ? "" : (tags.back() + ".")) + tagName(str);
            tags.push_back(tag);

            for (auto const &attribute: attributeNames(str))
                map[tag + "~" + attribute] = attributeValue(str, attribute);
        } else
            tags.pop_back();
    }

    for (int i = 0; i < Q; i++) {
        string key;
        cin >> key;
        cout << (map.count(key) > 0 ? map.find(key)->second : "Not Found!") << endl;
    }

    return 0;
}