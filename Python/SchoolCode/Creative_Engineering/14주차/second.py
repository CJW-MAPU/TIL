for i in range(10):
    print(f'#{i} : hello')

for i, data in enumerate('SOME STRING'):
    print(f'{i + 1}번 째 문자열 : {data}')

for character in 'SOME STRING':
    print(f'[{character}]', end = ', ')
