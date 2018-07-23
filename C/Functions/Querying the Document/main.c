#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

#define MAX_CHARACTERS 1005
#define MAX_PARAGRAPHS 5

/**
 * @author Oleg Cherednik
 * @since 23.07.2018
 */
char *kth_word_in_mth_sentence_of_nth_paragraph(char ****document, int k, int m, int n) {
    return document[n - 1][m - 1][k - 1];
}

char **kth_sentence_in_mth_paragraph(char ****document, int k, int m) {
    return document[m - 1][k - 1];
}

char ***kth_paragraph(char ****document, int k) {
    return document[k - 1];
}

char *get_word(char *text, char **w) {
    *w = NULL;
    int count = 0;

    while (*text != ' ' && *text != '.' && *text != '\n' && *text != '\0') {
        count++;
        *w = realloc(*w, sizeof(char) * (count + 1));
        (*w)[count - 1] = *text;
        text++;
    }

    (*w)[count] = '\0';

    return text;
}

char *get_sentence(char *text, char ***s) {
    *s = NULL;
    int count = 0;

    while (*text != '.' && *text != '\n' && *text != '\0') {
        count++;
        *s = realloc(*s, sizeof(char *) * count);
        text = get_word(text, *s + count - 1);
        if (*text == ' ')
            text++;
    }

    return text;
}

char *get_paragraph(char *text, char ****p) {
    *p = NULL;
    int count = 0;

    while (*text != '\n' && *text != '\0') {
        count++;
        *p = realloc(*p, sizeof(char **) * count);
        text = get_sentence(text, *p + count - 1);

        if (*text == '.')
            text++;
    }
    return text;
}

char ****get_document(char *text) {
    char ****d = NULL;
    int count = 0;

    while (*text != '\0') {
        count++;
        d = realloc(d, sizeof(char ***) * count);
        text = get_paragraph(text, d + count - 1);
        if (*text == '\n')
            text++;
    }

    return d;
}

char *get_input_test() {
    int paragraph_count;
    scanf("%d", &paragraph_count);

    char p[MAX_PARAGRAPHS][MAX_CHARACTERS], doc[MAX_CHARACTERS];
    memset(doc, 0, sizeof(doc));
    getchar();
    for (int i = 0; i < paragraph_count; i++) {
        scanf("%[^\n]%*c", p[i]);
        strcat(doc, p[i]);
        if (i != paragraph_count - 1)
            strcat(doc, "\n");
    }

    char *returnDoc = (char *) malloc((strlen(doc) + 1) * sizeof(char));
    strcpy(returnDoc, doc);
    return returnDoc;
}

void print_word(char *word) {
    printf("%s", word);
}

void print_sentence(char **sentence) {
    int word_count;
    scanf("%d", &word_count);
    for (int i = 0; i < word_count; i++) {
        printf("%s", sentence[i]);
        if (i != word_count - 1)
            printf(" ");
    }
}

void print_paragraph(char ***paragraph) {
    int sentence_count;
    scanf("%d", &sentence_count);
    for (int i = 0; i < sentence_count; i++) {
        print_sentence(*(paragraph + i));
        printf(".");
    }
}

int main() {
    char *text = get_input_test();
    char ****document = get_document(text);

    int q;
    scanf("%d", &q);

    while (q--) {
        int type;
        scanf("%d", &type);

        if (type == 3) {
            int k, m, n;
            scanf("%d %d %d", &k, &m, &n);
            char *word = kth_word_in_mth_sentence_of_nth_paragraph(document, k, m, n);
            print_word(word);
        } else if (type == 2) {
            int k, m;
            scanf("%d %d", &k, &m);
            char **sentence = kth_sentence_in_mth_paragraph(document, k, m);
            print_sentence(sentence);
        } else {
            int k;
            scanf("%d", &k);
            char ***paragraph = kth_paragraph(document, k);
            print_paragraph(paragraph);
        }

        printf("\n");
    }

    return 0;
}

