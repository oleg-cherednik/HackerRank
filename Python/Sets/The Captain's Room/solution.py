#!/bin/python3

if __name__ == '__main__':
    K = int(input())
    rooms = list(map(int, input().split(' ')))
    print(((sum(set(rooms)) * K) - (sum(rooms))) // (K - 1))
