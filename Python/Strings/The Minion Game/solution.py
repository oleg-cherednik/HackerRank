#!/bin/python3

def minion_game(string):
    kevin_score = 0
    stuart_score = 0

    for i in range(len(string)):
        if string[i] in 'AEIOU':
            kevin_score = kevin_score + len(string) - i
        else:
            stuart_score = stuart_score + len(string) - i

    if kevin_score > stuart_score:
        print('Kevin ' + str(kevin_score))
    elif kevin_score < stuart_score:
        print('Stuart ' + str(stuart_score))
    else:
        print('Draw')


def _substrings(string):
    subs = {'consonants': 0, 'vowels': 0}

    for i in range(len(string)):
        for j in range(len(string) - i):
            sub = str(string[j:j + i + 1])

            if sub[0] in 'AEIOU':
                subs['vowels'] = subs['vowels'] + 1
            else:
                subs['consonants'] = subs['consonants'] + 1

    return subs


if __name__ == '__main__':
    s = input()
    minion_game(s)
