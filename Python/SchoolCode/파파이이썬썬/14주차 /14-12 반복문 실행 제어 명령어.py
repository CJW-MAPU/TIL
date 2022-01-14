# 반복문 명령:  for문 while문
# 반목문 분류: 정해진 횟수만큼 반복 (for), 정해진 조건에 따라 반복 (while)


# 반복문 내에서 실행을 제어하는 명령어들
#continue, pass, break

#continue
#pass
#break

for i in range(1, 11):
    if i % 2 == 0: #continue 조건지정
        continue
        #pass를 넣을수 있지만 모든수가 나온다
    print('홀수:', i)
else: # 있어도 그만 없어도 그만
    print('반복문 종료')
