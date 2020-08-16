#!/bin/python3

from itertools import product

if __name__ == '__main__':
    A = list(map(int, input().split()))
    B = list(map(int, input().split()))
    print(*product(A, B))
