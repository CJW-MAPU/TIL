# 조건문
# 조건문 종류 (if, if ~ else, if ~ elif)
# 조건문은 중첩하여 더 복잡한 조건문 작성 가능

# if문은, 만약 ~(if 조건식)라면 ~(실행문)하고, 아니라면 안한다.
# if ~ else문은, 만약 ~(if 조건식)라면 ~(실행문)하고, 아니라면, ~(else)한다.
# if ~ elif문은, 만약 ~ (if 조건식)라면, ~(실행문)하고, 아니라면,
#  ~ (elif)하고, 아니라면 ~ (elif)하고,......마지막엔 else한다.

# 예제 6
# pass는 조건문의 실행문이 없이 다음 단계로 코드를 통과시킬 때 사용.

score = int(input('점수를 입력하세요:'))

if score >= 60:
    pass
else:
    pass
