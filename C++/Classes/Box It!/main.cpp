#include <iostream>
#include <sstream>

using namespace std;

class Box {
private:
    int length;
    int breadth;
    int height;
public:
    Box() : Box(0, 0, 0) {}

    Box(Box &box) : Box(box.length, box.breadth, box.height) {}

    Box(int length, int breadth, int height) {
        this->length = length;
        this->breadth = breadth;
        this->height = height;
    }

    int getLength() {
        return length;
    }

    int getBreadth() {
        return breadth;
    }

    int getHeight() {
        return height;
    }

    long long CalculateVolume() {
        return (long long) length * breadth * height;
    }

    friend bool operator<(Box &A, Box &B) {
        return (A.length < B.length) || ((A.breadth < B.breadth) && (A.length == B.length)) ||
               ((A.height < B.height) && (A.length == B.length) && (A.breadth == B.breadth));
    };

    friend ostream &operator<<(ostream &output, const Box &b) {
        output << b.length << " " << b.breadth << " " << b.height;
        return output;
    }
};

void check2() {
    int n;
    cin >> n;
    Box temp;

    for (int i = 0; i < n; i++) {
        int type;
        cin >> type;

        if (type == 1)
            cout << temp << endl;
        else if (type == 2) {
            int l, b, h;
            cin >> l >> b >> h;
            Box NewBox(l, b, h);
            temp = NewBox;
            cout << temp << endl;
        } else if (type == 3) {
            int l, b, h;
            cin >> l >> b >> h;
            Box NewBox(l, b, h);

            if (NewBox < temp)
                cout << "Lesser" << endl;
            else
                cout << "Greater" << endl;
        } else if (type == 4)
            cout << temp.CalculateVolume() << endl;
        else if (type == 5) {
            Box NewBox(temp);
            cout << NewBox << endl;
        }
    }
}

int main() {
    check2();
    return 0;
}