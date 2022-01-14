# 반복문 명령:  for문 while문
# 반목문 분류: 정해진 횟수만큼 반복 (for), 정해진 조건에 따라 반복 (while)


# 중첩반복문, ~회 반복을, ~세트 반복할 때.
#예제 *의 개수를 1부터 5까지 하나씩 증가시키면서 출력

for i in range (1, 6):
    for l in range (i):
        print('*', end ='')
    else:    
        print('\n')
    


