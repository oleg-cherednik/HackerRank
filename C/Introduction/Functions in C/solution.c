#include <stdio.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
int main() {
    int a, b, c, d;
    scanf("%d %d %d %d", &a, &b, &c, &d);
    int ans = max_of_four(a, b, c, d);
    printf("%d", ans);

    return 0;
}

#define max(x, y) ((x) >= (y)) ? (x) : (y)

int max_of_four(int a, int b, int c, int d) {
    return max(a, max(b, max(c, d)));
}