# 조건문
# 조건문 종류 (if, if ~ else, if ~ elif)
# 조건문은 중첩하여 더 복잡한 조건문 작성 가능

# if문은, 만약 ~(if 조건식)라면 ~(실행문)하고, 아니라면 안한다.
# if ~ else문은, 만약 ~(if 조건식)라면 ~(실행문)하고, 아니라면, ~(else)한다.
# if ~ elif문은, 만약 ~ (if 조건식)라면, ~(실행문)하고, 아니라면,
#  ~ (elif)하고, 아니라면 ~ (elif)하고,......마지막엔 else한다.

# 예제 2
# 현재 기온이 영하이면, '영하권입니다.' 메세지 출력.
temp = float(input('현재 기온은:'))
if temp <= 0:
    print('영하권입니다.')
    
print('영하권이라 춥습니다.')
    
