#!/bin/python3

# Complete the solve function below.
def solve(s):
    words = s.split(' ')

    for i in range(len(words)):
        words[i] = words[i].capitalize()

    return ' '.join(words)


if __name__ == '__main__':
    s = input()
    result = solve(s)
    print(result)
