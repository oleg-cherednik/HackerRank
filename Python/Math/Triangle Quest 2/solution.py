#!/bin/python3

if __name__ == '__main__':
    for i in range(1, int(input()) + 1):
        print(((10 ** i - 1) // 9) ** 2)
