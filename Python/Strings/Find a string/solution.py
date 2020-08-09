#!/bin/python3

def count_substring(string, sub_string):
    total = 0
    pos = 0

    while(True):
        pos = string.find(sub_string, pos)

        if pos == -1:
            break

        total = total + 1
        pos = pos + 1

    return total


if __name__ == '__main__':
    string = input().strip()
    sub_string = input().strip()

    count = count_substring(string, sub_string)
    print(count)
