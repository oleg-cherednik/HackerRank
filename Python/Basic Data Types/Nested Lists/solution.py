#!/bin/python3

if __name__ == '__main__':
    data = []

    for _ in range(int(input())):
        name = input()
        score = float(input())
        data.append([name, score])

    mark = sorted(list(set([marks for name, marks in data])))[1]
    data = sorted(data)

    for item in data:
        if item[1] == mark:
            print(item[0])
