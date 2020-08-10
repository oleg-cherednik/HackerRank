#!/bin/python3

def merge_the_tools(string, k):
    for i in range(0, len(string), k):
        unique = []

        for ch in string[i:i + k]:
            if ch not in unique:
                unique.append(ch)

        print(''.join(unique))


if __name__ == '__main__':
    string, k = input(), int(input())
    merge_the_tools(string, k)
