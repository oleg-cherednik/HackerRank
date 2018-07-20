#include <stdio.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
int main() {
    char s[100];
    scanf("%[^\n]%*c", &s);
    printf("Hello, World!\n");
    printf(s);
    return 0;
}