#!/bin/python3

from itertools import combinations_with_replacement

if __name__ == '__main__':
    S, k = input().split()
    S = sorted(S)
    print(*[''.join(i) for i in combinations_with_replacement(S, int(k))], sep='\n')
