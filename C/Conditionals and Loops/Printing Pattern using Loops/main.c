#include <stdio.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */

#define max(x, y) ((x) >= (y)) ? (x) : (y)

int main() {
    int n;
    scanf("%d", &n);

    int len = n * 2 - 1;

    for (int row = 0; row < len; row++) {
        int v = row < n ? n - row : row - n + 2;

        for (int col = 0; col < len; col++) {
            int h = col < n ? n - col : col - n + 2;
            printf("%d ", max(v, h));
        }

        printf("\n");
    }

    return 0;

}

