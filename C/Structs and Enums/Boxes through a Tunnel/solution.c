#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

#define MAX_HEIGHT 41

/**
 * @author Oleg Cherednik
 * @since 23.07.2018
 */
struct box {
    int length;
    int width;
    int height;
};

typedef struct box box;

int get_volume(box b) {
    return b.length * b.width * b.height;
}

int is_lower_than_max_height(box b) {
    return b.height < MAX_HEIGHT ? 1 : 0;
}

int main() {
    int n;
    scanf("%d", &n);
    box *boxes = malloc(n * sizeof(box));

    for (int i = 0; i < n; i++)
        scanf("%d%d%d", &boxes[i].length, &boxes[i].width, &boxes[i].height);

    for (int i = 0; i < n; i++)
        if (is_lower_than_max_height(boxes[i]))
            printf("%d\n", get_volume(boxes[i]));

    return 0;
}

