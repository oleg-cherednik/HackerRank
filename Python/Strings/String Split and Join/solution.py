#!/bin/python3

def split_and_join(line):
    words = line.split(' ')
    return '-'.join(words)

if __name__ == '__main__':
    line = input()
    result = split_and_join(line)
    print(result)
