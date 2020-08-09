#!/bin/python3

def print_rangoli(size):
    alphabet = 'abcdefghijklmnopqrstuvwxyz'
    a = 0
    lines = []

    for i in range(size):
        line = alphabet[a]

        for j in range(size - i - 1):
            line = line + '-' + alphabet[i + j + 1]

        while len(line) <= size * 2 - 2:
            line = line + '-'

        lines.append(line[1:][::-1] + line)
        a = a + 1

    for i in reversed(range(size)):
        print(lines[i])

    for i in range(size - 1):
        print(lines[i + 1])


if __name__ == '__main__':
    n = int(input())
    print_rangoli(n)
