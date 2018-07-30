#include <iostream>
#include <sstream>
#include <string>
#include <exception>
#include <vector>
#include <cmath>

using namespace std;

class Person {
protected:
    string name;
    int age;
public:
    virtual void getdata() = 0;

    virtual void putdata() = 0;
};

class Professor : public Person {
private:
    int publications;
    int cur_id;

    static int id;
public:
    Professor() {
        cur_id = ++id;
    }

    void getdata() override {
        cin >> name >> age >> publications;
    };

    void putdata() override {
        cout << name << " " << age << " " << publications << " " << cur_id << endl;
    };
};

class Student : public Person {
private:
    int marks[6] = {};
    int cur_id;

    static int id;
public:
    Student() {
        cur_id = ++id;
    }

    void getdata() override {
        cin >> name >> age >> marks[0] >> marks[1] >> marks[2] >> marks[3] >> marks[4] >> marks[5];
    };

    void putdata() override {
        int sum = 0;

        for (int mark : marks)
            sum += mark;

        cout << name << " " << age << " " << sum << " " << cur_id << endl;
    };
};

int Professor::id = 0;
int Student::id = 0;

int main() {
    int n, val;
    cin >> n;

    Person *per[n];

    for (int i = 0; i < n; i++) {
        cin >> val;

        if (val == 1)
            per[i] = new Professor;
        else
            per[i] = new Student;

        per[i]->getdata();
    }

    for (int i = 0; i < n; i++)
        per[i]->putdata();


    return 0;
}