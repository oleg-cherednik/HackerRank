#!/bin/python3

if __name__ == '__main__':
    line = list(map(int, input().split(' ')))
    arr = list(map(int, input().split(' ')))
    A = set(map(int, input().split(' ')))
    B = set(map(int, input().split(' ')))

    happiness = 0

    for a in arr:
        if a in A:
            happiness += 1
        elif a in B:
            happiness -= 1

    print(happiness)
