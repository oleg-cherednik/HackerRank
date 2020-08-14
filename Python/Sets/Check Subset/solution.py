#!/bin/python3

if __name__ == '__main__':
    T = int(input())

    for i in range(T):
        a = input()
        A = set(input().split())
        b = input()
        B = set(input().split())
        print(A.issubset(B))
