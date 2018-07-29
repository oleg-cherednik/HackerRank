#include <iostream>
#include <sstream>
#include <string>
#include <exception>

using namespace std;

struct BadLengthException : public exception {
private:
    int length;

public:
    explicit BadLengthException(int n) {
        this->length = n;
    }

    const char *what() noexcept {
        return to_string(length).c_str();
    }
};

bool checkUsername(string username) {
    bool isValid = true;
    int n = username.length();

    if (n < 5)
        throw BadLengthException(n);

    for (int i = 0; i < n - 1; i++)
        if (username[i] == 'w' && username[i + 1] == 'w')
            isValid = false;

    return isValid;
}

int main() {
    int T;
    cin >> T;

    while (T--) {
        string username;
        cin >> username;

        try {
            bool isValid = checkUsername(username);

            if (isValid)
                cout << "Valid" << endl;
            else
                cout << "Invalid" << endl;
        } catch (BadLengthException e) {
            cout << "Too short: " << e.what() << endl;
        }
    }

    return 0;
}