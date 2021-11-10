import random

RCP = {0: '가위', 1: '바위', 2: '보'}

rand = random.randint(0, 3)
computer = RCP[rand]

player = input('나의 가위/바위/보 ==> ')
print(f'컴퓨터의 가위/바위/보 ==> {computer}')

if player == computer:
    print('비겼습니다. --')
else:
    if player == '가위':
        if computer == '바위':
            print('졌습니다. ㅠㅠ')
        elif computer == '보':
            print('이겼습니다. ^^')

    elif player == '바위':
        if computer == '보':
            print('졌습니다. ㅠㅠ')
        elif computer == '가위':
            print('이겼습니다. ^^')

    elif player == '보':
        if computer == '가위':
            print('졌습니다. ㅠㅠ')
        elif computer == '바위':
            print('이겼습니다. ^^')
