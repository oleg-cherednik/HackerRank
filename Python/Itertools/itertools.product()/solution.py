#!/bin/python3

import itertools

if __name__ == '__main__':
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    print(*itertools.product(A, B))
