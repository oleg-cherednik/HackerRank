#!/bin/python3

if __name__ == '__main__':
    n = int(input())
    student_marks = {}
    for _ in range(n):
        name, *line = input().split()
        scores = list(map(float, line))
        student_marks[name] = scores
    query_name = input()

    s = 0

    for i in student_marks[query_name]:
        s += i

    print("{0:.2f}".format(s / len(student_marks[query_name])))
