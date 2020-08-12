#!/bin/python3

if __name__ == '__main__':
    n = int(input())
    english = list(map(int, input().split(' ')))
    b = int(input())
    french = list(map(int, input().split(' ')))

    students = set(english).symmetric_difference(french)
    print(len(students))
