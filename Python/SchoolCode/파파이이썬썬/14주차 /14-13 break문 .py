# 반복문 명령:  for문 while문
# 반목문 분류: 정해진 횟수만큼 반복 (for), 정해진 조건에 따라 반복 (while)


# 반복문 내에서 실행을 제어하는 명령어들
#continue, pass, break

#continue
#pass
#break  반복문을 빠져나오는것

num = 0
result = 0

while num < 11:
    result += num
    if result >= 30:
        break
        #pass 10까지 더함
    print('num:', num)
    print('result:', result)

    num += 1
