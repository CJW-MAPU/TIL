
# 반복문 명령:  for문 while문
# 반목문 분류: 정해진 횟수만큼 반복 (for), 정해진 조건에 따라 반복 (while)


# 중첩반복문, ~회 반복을, ~세트 반복할 때.
#예제2 구구단 2단부터 9단까지 출력 (각 단 세로 출력)
for i in range(2, 10):
    print('\n')
    print(i,'단')
    for l in range(1, 10):
        print(i , '*', l, '= ', i*l)



#예제2 구구단 2단부터 9단까지 출력 (각 단 가로 출력)
for i in range(2, 10):
    print('\n')
    print(i,'단')
    for l in range(1, 10):       
        print(i , '*', l, '= ', i*l,' ','\t', end = '')
        

    


