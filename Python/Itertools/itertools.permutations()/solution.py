#!/bin/python3

from itertools import permutations

if __name__ == '__main__':
    S, k = input().split()
    print(*[''.join(i) for i in permutations(sorted(S), int(k))], sep='\n')
