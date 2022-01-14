for i in range(1, 6):
    for j in range(i):
        print('*', end = '')
    print()
print()


for i in range(2, 10, 4):
    for j in range(4):
        print(f'{i + j} 단', end = '\t\t\t\t\t\t\t\t\t\t\t')
    for j in range(1, 10):
        print()
        for k in range(4):
            print(f'{i + k} * {j} = {(i + k) * j}', end = '\t\t\t\t\t\t\t\t\t')

    print()
    print()
