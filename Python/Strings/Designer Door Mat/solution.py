#!/bin/python3

def print_mat(N, M):
    a = 0
    side_width = int(M / 2) - 1
    lines = []

    for row in range(int(N / 2)):
        line = '.'

        if a > 0:
            for i in range(a):
                line = '..|' + line

        while len(line) <= side_width:
            line = line + '-'

        line = line[::-1] + '|' + line
        lines.append(line)
        print(line)
        a = a + 1

    offs = ('-' * int((M - len('WELCOME')) / 2))
    print(offs + 'WELCOME' + offs)

    for line in reversed(lines):
        print(line)


if __name__ == '__main__':
    nums = input().split(' ')
    N = int(nums[0])
    M = int(nums[1])
    print_mat(N, M)
