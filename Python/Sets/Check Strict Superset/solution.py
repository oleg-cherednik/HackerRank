#!/bin/python3

if __name__ == '__main__':
    A = set(input().split())
    n = int(input())
    res = True

    for i in range(n):
        N = set(input().split())

        if not A.issuperset(N):
            res = False
            break

    print(res)
