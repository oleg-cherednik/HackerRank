#include <stdio.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
#define max(x, y) ((x) >= (y)) ? (x) : (y)

void calculate_the_maximum(int n, int k) {
    int maxAnd = 0;
    int maxOr = 0;
    int maxXor = 0;

    for (int a = 1; a < n; a++) {
        for (int b = a + 1; b <= n; b++) {
            if ((a & b) < k)
                maxAnd = max(maxAnd, a & b);
            if ((a | b) < k)
                maxOr = max(maxOr, a | b);
            if ((a ^ b) < k)
                maxXor = max(maxXor, a ^ b);
        }
    }

    printf("%d\n%d\n%d", maxAnd, maxOr, maxXor);
}

int main() {
    int n, k;

    scanf("%d %d", &n, &k);
    calculate_the_maximum(n, k);

    return 0;;
}

