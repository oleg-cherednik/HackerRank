#include <cstdlib>
#include <cstdio>

using namespace std;

void update(int *a, int *b) {
    int tmp = *a;
    *a = tmp + *b;
    *b = abs(tmp - *b);
}

int main() {
    int a, b;
    int *pa = &a, *pb = &b;

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}