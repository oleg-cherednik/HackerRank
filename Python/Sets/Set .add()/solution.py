#!/bin/python3

if __name__ == '__main__':
    N = int(input())

    unuque = set()

    for i in range(N):
        unuque.add(input())

    print(len(unuque))
