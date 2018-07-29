#include <stdio.h>
#include <stdlib.h>

/**
 * @author Oleg Cherednik
 * @since 22.07.2018
 */
int main() {
    int *arr = (int *) malloc(10 * sizeof(int));

    for (int i = 0; i < 10; i++)
        arr[i] = 0;

    char s[1000];
    scanf("%s", &s);

    int i = 0;

    while (s[i] != '\0') {
        if (s[i] >= '0' && s[i] <= '9') {
            int v = s[i] - '0';
            arr[v]++;
        }

        i++;
    }

    for (int i = 0; i < 10; i++) {
        printf("%d ", arr[i]);
    }

    return 0;
}

