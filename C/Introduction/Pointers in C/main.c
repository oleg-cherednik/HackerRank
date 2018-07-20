#include <stdio.h>
#include <stdlib.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
int main() {
    int a, b;
    int *pa = &a, *pb = &b;

    scanf("%d %d", &a, &b);
    update(pa, pb);
    printf("%d\n%d", a, b);

    return 0;
}

void update(int *a,int *b) {
    int tmp = *a;
    *a = *a + *b;
    *b = abs(tmp - *b);
}