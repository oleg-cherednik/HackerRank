#include <stdio.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
int main() {
    int n;
    scanf("%d", &n);

    int sum = 0;

    while (n != 0) {
        sum += n % 10;
        n /= 10;
    }

    printf("%d", sum);

    return 0;

}

