#!/bin/python3

def swap_case(s):
    res = ''

    for ch in s:
        if ch.islower():
            res = res + ch.upper()
        else:
            res = res + ch.lower()

    return res

if __name__ == '__main__':
    s = input()
    result = swap_case(s)
    print(result)
