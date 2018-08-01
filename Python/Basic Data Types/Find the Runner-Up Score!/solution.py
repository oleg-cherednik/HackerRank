#!/bin/python3

if __name__ == '__main__':
    n = int(input())
    arr = map(int, input().split())
    sl = list(arr)
    sl.sort()

    for i in reversed(sl):
        if i != sl[-1]:
            print(i)
            break
