# 반복문 명령:  for문 while문
# 반목문 분류: 정해진 횟수만큼 반복 (for), 정해진 조건에 따라 반복 (while)


#while문 예제2. 1~100까지의 수 중 3과 8의 공배수와 최소 공배수 출

num = 1
n = 100

while num <= n:
    if num % 3 == 0 and num % 8 == 0:
        print('3과 8의 공배수:', num)
        
    num += 1   #공배수 찾는 방법


num = 1
lcm = 0 # 최송 공배수 줄임말
n = 100

while num <= n:
    if num % 3 == 0 and num % 8 == 0:
        print('3과 8의 공배수:', num)
        if lcm == 0:
            lcm = num # 최소 공배수 저장
            
        
    num += 1  
print('최소공배수는', lcm)
