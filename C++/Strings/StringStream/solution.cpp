#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

vector<int> parseInts(string str) {
    vector<int> res;
    stringstream ss(str);

    for (int i = 0; ss >> i; ss.ignore())
        res.push_back(i);

    return res;
}

int main() {
    string str;
    cin >> str;
    vector<int> integers = parseInts(str);

    for (int i = 0; i < integers.size(); i++) {
        cout << integers[i] << "\n";
    }

    return 0;
}