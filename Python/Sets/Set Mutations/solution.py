#!/bin/python3

if __name__ == '__main__':
    n = int(input())
    A = set(map(int, input().split(' ')))
    N = int(input())

    for i in range(N):
        line = input().split(' ')
        other = set(map(int, input().split(' ')))

        if line[0] == 'intersection_update':
            A &= other
        elif line[0] == 'update':
            A |= other
        elif line[0] == 'symmetric_difference_update':
            A ^= other
        elif line[0] == 'difference_update':
            A -= other

    print(sum(A))

