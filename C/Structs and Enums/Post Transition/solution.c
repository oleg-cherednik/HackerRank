#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_STR_LEN 10

/**
 * @author Oleg Cherednik
 * @since 23.07.2018
 */
typedef struct Package {
    char id[MAX_STR_LEN];
    unsigned weight;
} Package;

typedef struct {
    unsigned min_weight, max_weight, package_count, capacity;
    Package *packages;
} Office;

typedef struct {
    char name[MAX_STR_LEN];
    Office *offices;
    unsigned office_count, package_count;
} Town;

Package read_package() {
    Package p;
    p.weight = 0;
    scanf("%s %u", p.id, &p.weight);
    return p;
}

Office read_office() {
    Office o;
    scanf("%u %u %u", &o.package_count, &o.min_weight, &o.max_weight);
    o.capacity = o.package_count * 2;
    o.packages = malloc(o.capacity * sizeof(Package));
    unsigned i = 0;
    for (i = 0; i < o.package_count; ++i) {
        o.packages[i] = read_package();
    }
    return o;
}

Town read_town() {
    Town t;
    scanf("%s %u", t.name, &t.office_count);
    t.offices = malloc(t.office_count * sizeof(Office));
    unsigned i = 0;
    t.package_count = 0;
    for (i = 0; i < t.office_count; ++i) {
        t.offices[i] = read_office();
        t.package_count += t.offices[i].package_count;
    }
    return t;
}

void add_package(Office *o, Package p) {
    if (o->package_count == o->capacity) {
        o->capacity *= 2;
        Package *expanded = malloc(o->capacity * sizeof(Package));
        unsigned i = 0;
        for (i = 0; i < o->package_count; ++i) {
            expanded[i] = o->packages[i];
        }
        free(o->packages);
        o->packages = expanded;
    }
    o->packages[o->package_count++] = p;
}

int is_between(unsigned x, unsigned y, unsigned z) {
    return x <= y && y <= z;
}

unsigned send_packages(Office *from, Office *to) {
    unsigned i = 0, sent_count = 0;
    for (i = 0; i < from->package_count; ++i) {
        if (is_between(to->min_weight, from->packages[i].weight, to->max_weight)) {
            add_package(to, from->packages[i]);
            ++sent_count;
        } else if (sent_count) {
            from->packages[i - sent_count] = from->packages[i];
        }
    }
    from->package_count -= sent_count;
    return sent_count;
}

void destroy_office(Office *o) {
    free(o->packages);
}

void destroy_town(Town *t) {
    unsigned i = 0;
    for (i = 0; i < t->office_count; ++i) {
        destroy_office(t->offices + i);
    }
    free(t->offices);
}

void print_town(Town *t) {
    printf("%s:\n", t->name);
    unsigned i = 0, k = 0;
    for (i = 0; i < t->office_count; ++i) {
        printf("\t%u:\n", i);
        for (k = 0; k < t->offices[i].package_count; ++k) {
            printf("\t\t%s\n", t->offices[i].packages[k].id);
        }
    }
}

Town *find_town(Town *towns, unsigned count, const char *name) {
    unsigned i = 0;
    for (i = 0; i < count; ++i) {
        if (strcmp(towns[i].name, name) == 0) {
            return towns + i;
        }
    }
    return NULL;
}

void execute_read_query(Town *towns, unsigned count) {
    unsigned qtype = 0, i = 0;
    scanf("%u", &qtype);
    char temp_buf[MAX_STR_LEN];
    switch (qtype) {
        case 1: {
            scanf("%s", temp_buf);
            print_town(find_town(towns, count, temp_buf));
            break;
        }
        case 2: {
            scanf("%s", temp_buf);
            Town *source = find_town(towns, count, temp_buf);
            unsigned source_off = 0, target_off = 0;
            scanf("%u %s %u", &source_off, temp_buf, &target_off);
            Town *target = find_town(towns, count, temp_buf);
            unsigned sent_count = send_packages(source->offices + source_off, target->offices + target_off);
            source->package_count -= sent_count;
            target->package_count += sent_count;
            break;
        }
        case 3: {
            unsigned most_packages = 0, ind_most = 0;
            for (i = 0; i < count; ++i) {
                if (towns[i].package_count > most_packages) {
                    most_packages = towns[i].package_count;
                    ind_most = i;
                }
            }
            printf("Town with the most number of packages is %s\n", towns[ind_most].name);
        }
    }
}

int main() {
    unsigned towns_count = 0, query_count = 0, i = 0;
    scanf("%u", &towns_count);
    Town *towns = malloc(towns_count * sizeof(Town));
    for (i = 0; i < towns_count; ++i) {
        towns[i] = read_town();
    }
    scanf("%u", &query_count);
    for (i = 0; i < query_count; ++i) {
        execute_read_query(towns, towns_count);
    }
    for (i = 0; i < towns_count; ++i) {
        destroy_town(towns + i);
    }
    free(towns);
}