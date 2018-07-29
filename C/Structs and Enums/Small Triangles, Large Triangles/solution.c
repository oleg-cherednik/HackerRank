#include <stdio.h>
#include <stdlib.h>
#include <math.h>

/**
 * @author Oleg Cherednik
 * @since 23.07.2018
 */
struct triangle {
    int a;
    int b;
    int c;
};

typedef struct triangle triangle;

int heron(triangle *t) {
    int sum = t->a + t->b + t->c;
    return sum * (sum - 2 * t->a) * (sum - 2 * t->b) * (sum - 2 * t->c);
}

int heron_comp(const void *a, const void *b) {
    return heron((triangle *) a) - heron((triangle *) b);
}

void sort_by_area(triangle *tr, int n) {
    qsort(tr, n, sizeof(*tr), heron_comp);
}

int main() {
    int n;
    scanf("%d", &n);
    triangle *tr = malloc(n * sizeof(triangle));

    for (int i = 0; i < n; i++)
        scanf("%d%d%d", &tr[i].a, &tr[i].b, &tr[i].c);

    sort_by_area(tr, n);

    for (int i = 0; i < n; i++)
        printf("%d %d %d\n", tr[i].a, tr[i].b, tr[i].c);

    return 0;
}

