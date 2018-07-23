#include <stdio.h>
#include <stdlib.h>
#include <string.h>

/**
 * @author Oleg Cherednik
 * @since 23.07.2018
 */
int lexicographic_sort(const char *a, const char *b) {
    return strcmp(a, b);
}

int lexicographic_sort_reverse(const char *a, const char *b) {
    return strcmp(b, a);
}

int distinct_chars(const char *a) {
    int dist = 0;

    while (*a != '\0') {
        if (!strchr(a + 1, *a))
            dist++;
        a++;
    }

    return dist;
}

int sort_by_number_of_distinct_characters(const char *a, const char *b) {
    int res = distinct_chars(a) - distinct_chars(b);
    return res ? res : lexicographic_sort(a, b);
}

int sort_by_length(const char *a, const char *b) {
    int res = strlen(a) - strlen(b);
    return res ? res : lexicographic_sort(a, b);
}

void swap(char **s, int i, int j) {
    char *temp = s[i];
    s[i] = s[j];
    s[j] = temp;
}

void string_sort(char **arr, const int len, int (*cmp_func)(const char *a, const char *b)) {
    int sorted = 0;

    while (!sorted) {
        sorted = 1;

        for (int i = 0; i < len - 1; i++) {
            if (cmp_func(arr[i], arr[i + 1]) > 0) {
                swap(arr, i, i + 1);
                sorted = 0;
            }
        }
    }
}

int main() {
    int n;
    scanf("%d", &n);

    char **arr;
    arr = (char **) malloc(n * sizeof(char *));

    for (int i = 0; i < n; i++) {
        *(arr + i) = malloc(1024 * sizeof(char));
        scanf("%s", *(arr + i));
        *(arr + i) = realloc(*(arr + i), strlen(*(arr + i)) + 1);
    }

    string_sort(arr, n, lexicographic_sort);
    for (int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, lexicographic_sort_reverse);
    for (int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, sort_by_length);
    for (int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    string_sort(arr, n, sort_by_number_of_distinct_characters);
    for (int i = 0; i < n; i++)
        printf("%s\n", arr[i]);
    printf("\n");

    return 0;
}

