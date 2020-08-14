#!/bin/python3

import cmath

if __name__ == '__main__':
    z = complex(input())
    print(abs(z))
    print(cmath.phase(z))
