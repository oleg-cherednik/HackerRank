#include <iostream>
#include <sstream>

using namespace std;

class Student {
private:
    int age;
    string first_name;
    string last_name;
    int standard;

public:
    Student() {
        age = 0;
        standard = 0;
        first_name.clear();
        last_name.clear();
    }

    void set_age(int age) {
        this->age = age;
    }

    void set_standard(int standard) {
        this->standard = standard;
    }

    void set_first_name(string &first_name) {
        this->first_name = first_name;
    }

    void set_last_name(string &last_name) {
        this->last_name = last_name;
    }

    int get_age() const {
        return age;
    }

    const string get_first_name() const {
        return first_name;
    }

    const string get_last_name() const {
        return last_name;
    }

    int get_standard() const {
        return standard;
    }

    const string to_string() const {
        stringstream ss;
        ss << age << ',' << first_name << ',' << last_name << ',' << standard;
        return ss.str();
    }

};


int main() {
    int age, standard;
    string first_name, last_name;

    cin >> age >> first_name >> last_name >> standard;

    Student st;
    st.set_age(age);
    st.set_standard(standard);
    st.set_first_name(first_name);
    st.set_last_name(last_name);

    cout << st.get_age() << "\n";
    cout << st.get_last_name() << ", " << st.get_first_name() << "\n";
    cout << st.get_standard() << "\n";
    cout << "\n";
    cout << st.to_string();

    return 0;
}