#include <stdio.h>

/**
 * @author Oleg Cherednik
 * @since 20.07.2018
 */
int main() {
    char ch;
    char s[100];
    char sen[100];

    scanf("%c", &ch);
    scanf("%s", &s);
    scanf(" %[^\n]%*c", &sen);

    printf("%c\n", ch);
    printf("%s\n", s);
    printf("%s\n", sen);

    return 0;
}