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
struct word {
    char *data;
};

struct sentence {
    struct word *data;
    int word_count;
};

struct paragraph {
    struct sentence *data;
    int sentence_count;
};

struct document {
    struct paragraph *data;
    int paragraph_count;
};

void add_word(struct sentence *sen, char *data) {
    struct word *word = malloc(sizeof(struct word));
    word->data = data;

    sen->data = (struct word *) realloc(sen->data, sizeof(struct word) * (sen->word_count + 1));
    sen->data[sen->word_count] = *word;
    sen->word_count++;
}

void add_sentence(struct paragraph *par, char *data) {
    size_t offs = 0;
    size_t size = strlen(data);

    struct sentence *sen = malloc(sizeof(struct sentence));
    sen->data = NULL;
    sen->word_count = 0;

    while (offs < size) {
        char *s = strchr(data + offs, ' ');
        size_t len = s == NULL ? size - offs : s - data - offs;

        char *word = malloc((len + 1) * sizeof(char));
        memset(word, '\0', (len + 1) * sizeof(char));
        strncpy(word, data + offs, len);

        add_word(sen, word);
        offs += len + 1;
    }

    par->data = (struct sentence *) realloc(par->data, sizeof(struct sentence) * (par->sentence_count + 1));
    par->data[par->sentence_count] = *sen;
    par->sentence_count++;
}

void add_paragraph(struct document *doc, char *data) {
    size_t offs = 0;
    size_t size = strlen(data);

    struct paragraph *par = malloc(sizeof(struct paragraph));
    par->data = NULL;
    par->sentence_count = 0;

    while (offs < size) {
        char *s = strchr(data + offs, '.');
        size_t len = s == NULL ? size - offs : s - data - offs;

        char *sentence = malloc((len + 1) * sizeof(char));
        memset(sentence, '\0', (len + 1) * sizeof(char));
        strncpy(sentence, data + offs, len);

        add_sentence(par, sentence);
        offs += len + 1;
    }

    doc->data = (struct paragraph *) realloc(doc->data, sizeof(struct paragraph) * (doc->paragraph_count + 1));
    doc->data[doc->paragraph_count] = *par;
    doc->paragraph_count++;
}

struct document get_document(char *text) {
    struct document *doc = malloc(sizeof(struct document));
    doc->data = NULL;
    doc->paragraph_count = 0;

    size_t offs = 0;
    size_t size = strlen(text);

    while (offs < size) {
        char *s = strchr(text + offs, '\n');
        size_t len = s == NULL ? size - offs : s - text - offs;

        char *paragraph = malloc((len + 1) * sizeof(char));
        memset(paragraph, '\0', (len + 1) * sizeof(char));
        strncpy(paragraph, text + offs, len);

        add_paragraph(doc, paragraph);
        offs += len + 1;
    }

    return *doc;
}

struct word kth_word_in_mth_sentence_of_nth_paragraph(struct document doc, int k, int m, int n) {
    return doc.data[n - 1].data[m - 1].data[k - 1];
}

struct sentence kth_sentence_in_mth_paragraph(struct document doc, int k, int m) {
    return doc.data[m - 1].data[k - 1];
}

struct paragraph kth_paragraph(struct document doc, int k) {
    return doc.data[k - 1];
}

void print_word(struct word w) {
    printf("%s", w.data);
}

void print_sentence(struct sentence sen) {
    for (int i = 0; i < sen.word_count; i++) {
        print_word(sen.data[i]);
        if (i != sen.word_count - 1)
            printf(" ");
    }
}

void print_paragraph(struct paragraph para) {
    for (int i = 0; i < para.sentence_count; i++) {
        print_sentence(para.data[i]);
        printf(".");
    }
}

char *get_input_text() {
    int paragraph_count;
    scanf("%d", &paragraph_count);

    char p[MAX_PARAGRAPHS][MAX_CHARACTERS], doc[MAX_CHARACTERS];
    memset(doc, 0, sizeof(doc));
    memset(p, 0, sizeof(p));
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

int main() {
    char *text = get_input_text();
    struct document doc = get_document(text);

    int q;
    scanf("%d", &q);

    while (q--) {
        int type;
        scanf("%d", &type);

        if (type == 3) {
            int k, m, n;
            scanf("%d %d %d", &k, &m, &n);
            struct word w = kth_word_in_mth_sentence_of_nth_paragraph(doc, k, m, n);
            print_word(w);
        } else if (type == 2) {
            int k, m;
            scanf("%d %d", &k, &m);
            struct sentence sen = kth_sentence_in_mth_paragraph(doc, k, m);
            print_sentence(sen);
        } else {
            int k;
            scanf("%d", &k);
            struct paragraph para = kth_paragraph(doc, k);
            print_paragraph(para);
        }
        printf("\n");
    }
}