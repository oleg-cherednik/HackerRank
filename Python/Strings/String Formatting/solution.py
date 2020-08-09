#!/bin/python3

def print_formatted(number):
    width = len(str(bin(number)[2:]))

    for i in range(number):
        print(str(i + 1).rjust(width) + ' '
              + oct(i + 1)[2:].rjust(width) + ' '
              + hex(i + 1)[2:].upper().rjust(width) + ' '
              + bin(i + 1)[2:].rjust(width))


if __name__ == '__main__':
    n = int(input())
    print_formatted(n)
