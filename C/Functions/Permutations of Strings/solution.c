#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * @author Oleg Cherednik
 * @since 23.07.2018
 */
void swap(char **s, int i, int j) {
    char *temp = s[i];
    s[i] = s[j];
    s[j] = temp;
}

void reverse(char **s, int i, int size) {
    while (i < size - 1) {
        swap(s, i, size - 1);
        i++;
        size--;
    }
}

int next_permutation(int n, char **s) {
    int k = -1;
    int m = -1;

    for (int i = 0; i < n - 1; i++)
        if (strcmp(s[i], s[i + 1]) < 0)
            k = i;

    if (k == -1)
        return 0;

    for (int i = k; i < n; i++)
        if (strcmp(s[k], s[i]) < 0)
            m = i;

    swap(s, k, m);
    reverse(s, k + 1, n);

    return 1;
}

int main() {
    char **s;
    int n;
    scanf("%d", &n);
    s = calloc(n, sizeof(char *));

    for (int i = 0; i < n; i++) {
        s[i] = calloc(11, sizeof(char));
        scanf("%s", s[i]);
    }

    do {
        for (int i = 0; i < n; i++)
            printf("%s%c", s[i], i == n - 1 ? '\n' : ' ');
    } while (next_permutation(n, s));

    for (int i = 0; i < n; i++)
        free(s[i]);

    free(s);

    return 0;
}

