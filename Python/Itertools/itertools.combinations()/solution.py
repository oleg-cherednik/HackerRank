#!/bin/python3

from itertools import combinations

if __name__ == '__main__':
    S, k = input().split()
    S = sorted(S)

    for i in range(int(k)):
        print(*[''.join(j) for j in combinations(S, i + 1)], sep='\n')
