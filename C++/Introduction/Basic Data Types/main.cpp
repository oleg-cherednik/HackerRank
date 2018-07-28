#include <iostream>
#include <iomanip>

using namespace std;

int main() {
    int a = 0;
    long int b = 0;
    char c = '\0';
    float d = 0;
    double e = 0;

    scanf("%d %ld %c %f %lf", &a, &b, &c, &d, &e);

    cout << a << endl;
    cout << b << endl;
    cout << c << endl;
    cout << setprecision(3) << fixed << d << endl;
    cout << setprecision(3) << fixed << e << endl;

    return 0;
}