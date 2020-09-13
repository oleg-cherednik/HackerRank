#!/bin/python3

from itertools import combinations

if __name__ == '__main__':
    N = int(input())
    l = input().split()
    K = int(input())

    C = list(combinations(l, K))
    F = filter(lambda c: 'a' in c, C)

    print('{0:.3}'.format(len(list(F)) / len(C)))
