# 조건문
# 조건문 종류 (if, if ~ else, if ~ elif)
# 조건문은 중첩하여 더 복잡한 조건문 작성 가능

# if문은, 만약 ~(if 조건식)라면 ~(실행문)하고, 아니라면 안한다.
# if ~ else문은, 만약 ~(if 조건식)라면 ~(실행문)하고, 아니라면, ~(else)한다.
# if ~ elif문은, 만약 ~ (if 조건식)라면, ~(실행문)하고, 아니라면,
#  ~ (elif)하고, 아니라면 ~ (elif)하고,......마지막엔 else한다.

# 실습 예제 5
# if ~ elif문 다중 비교가 필요할 때 사용, 조건의 순서가 중요

#조건문 and를 사용하여 버그 오류 수정
max_score = float(input('만점 기준:'))
score = float(input('점수 입력:'))

if max_score >= score:
    if score >= 60 and score < 70:
        print('D')
    elif score >= 80 and score < 90:
        print('B')
    elif score >= 70 and score < 80:
        print('C')
    elif score >= 90 and score < 100:
        print('A')
    elif score >= 0 and score < 60:
        print('F')
    


else:
    print('출력 범위를 넘어섰습니다.')
