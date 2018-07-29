#include <iostream>

using namespace std;

int main() {
    string a = "";
    string b = "";

    cin >> a >> b;

    cout << a.length() << " " << b.length() << endl;
    cout << a << b << endl;
    cout << b.at(0) << a.substr(1) << " " << a.at(0) << b.substr(1) << endl;

    return 0;
}