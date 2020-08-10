#!/bin/python3

def symmetric_difference(m, n):
    m_unique = set(m)
    n_unique = set(n)
    res = set(m_unique - n_unique)
    res.update(n_unique - m_unique)

    for v in sorted(res):
        print(v)


if __name__ == '__main__':
    M = int(input())
    m = list(map(int, input().split(' ')))
    N = int(input())
    n = list(map(int, input().split(' ')))
    symmetric_difference(m, n)
