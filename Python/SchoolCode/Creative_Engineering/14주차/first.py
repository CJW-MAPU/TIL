score = float(input('input score : '))

# @NOTE : score [<, ==, >] (number) and score [<, ==, >] (number)
# @NOTE : 형태는 (number) < score < (number) 형태로 간단히 표현 가능.

if not 0 <= score <= 100:
    print('범위 초과')
else:
    if 90 <= score < 100:
        print('A')
    elif 80 <= score < 90:
        print('B')
    elif 70 <= score < 80:
        print('C')
    elif 60 <= score < 70:
        print('D')
    else:
        print('F')
