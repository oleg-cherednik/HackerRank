#!/bin/python3

if __name__ == '__main__':
    s = input()

    alpha = False
    digit = False
    lower = False
    upper = False

    for ch in s:
        if ch.isalpha():
            alpha = True

            if ch.isupper():
                upper = True

            if ch.islower():
                lower = True

        if ch.isdigit():
            digit = True

    print(alpha or digit)
    print(alpha)
    print(digit)
    print(lower)
    print(upper)
