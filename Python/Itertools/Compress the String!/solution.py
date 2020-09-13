#!/bin/python3

from itertools import groupby

if __name__ == '__main__':
    S = input()
    print(*[(len(list(c)), int(k)) for k, c in groupby(S)])
