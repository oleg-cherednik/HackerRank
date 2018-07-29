#include <stdio.h>
#include <stdlib.h>

/**
 * @author Oleg Cherednik
 * @since 22.07.2018
 */
int main() {
    int num, *arr, i;
    scanf("%d", &num);
    arr = (int*) malloc(num * sizeof(int));
    for(i = 0; i < num; i++) {
        scanf("%d", arr + i);
    }

    for(i = num - 1; i >=0; i--)
        printf("%d ", *(arr + i));
    return 0;
}

