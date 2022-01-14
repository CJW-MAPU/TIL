# 반복문 명령:  for문 while문
# 반목문 분류: 정해진 횟수만큼 반복 (for), 정해진 조건에 따라 반복 (while)


#while문 예제 1~n까지의 수 중 홀수, 짝수 구별하여 출력

num = 1
n = 30

while num <= n:
    if num % 2 ==0:
        print('짝수:', num)
    else:
        print('홀수:', num)
        
    num += 1
