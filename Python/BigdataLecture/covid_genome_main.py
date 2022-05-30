import numpy as np
from queue import Queue


def is_subsequence(s, t):
    if len(s) == 0:
        return True

    cnt = 0

    for val in t:
        if val == s[cnt]:
            cnt += 1

            if cnt == len(s):
                return True

    return False


if __name__ == '__main__':
    f = open('dataset/MT745584.txt')

    items = ['A', 'C', 'G', 'T']
    dataset = list()

    for line in f.readlines():
        dataset.append(line[:-1])

    # dataset = ['CAGAAGT', 'TGACAG', 'GAAGT']

    min_sup = 498

    Q = Queue()
    for item in items:
        Q.put(item)

    result = []
    while not Q.empty():
        a = Q.get()
        for item in items:
            count = 0
            temp = a + item
            for data in dataset:
                if is_subsequence(temp, data):
                    count += 1

            if count >= min_sup:
                Q.put(temp)
                result.append(temp)
                print(f'qsize : {Q.qsize()} , {result[-1]}')

    print(f'Result : {result[-1]}')
    print(len(result) + 5)



