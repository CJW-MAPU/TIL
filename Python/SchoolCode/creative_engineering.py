# import turtle
#
#
# def make_turtle():
#     t = turtle.Turtle()
#     t.shape('turtle')
#     return t
#
#
# def example1(t = make_turtle()):
#     for i in range(0, 3):
#         t.forward(100)
#         t.right(90)
#     t.forward(100)
#     t.circle(50)
#
#
# def example2(t = make_turtle()):
#     angle = 120
#
#     for i in range(0, 3):
#         if i == 1:
#             angle = -angle
#         t.right(angle)
#         t.forward(100)


def example3():
    email = input('메일 : ')
    name = input('이름: ')
    username = input('아이디: ')
    password = input('비밀번호: ')

    print(f'To. {email}')
    print(f'{name} 고객님 안녕하세요.')
    print(f'{name} 고객님의 아이디와 비밀번호 확인 요청에 응답드립니다.')
    print(f'{name} 고객님의 아이디와 비밀번호는 \n')
    print(f'아이디: {username}')
    print(f'비밀번호: {password}\n')
    print('입니다.')


def example4():
    today = input('요일: ')
    month = input('월: ')
    day = input('일: ')
    min_temperature = input('최저 기온: ')
    max_temperature = input('최저 기온: ')
    precipitation = input('비올 확률: ')
    dust_concentration = input('미세먼지 농도: ')
    sunrise_hour = input('일출 시간(시): ')
    sunrise_minute = input('일출 시간(분): ')
    sunset_hour = input('일몰 시간(시)')
    sunset_minute = input('일몰 시간(분)')

    print('내일 날씨 예보입니다.')
    print(f'{today}요일인 {month}월 {day}일, 최저 기온은 {min_temperature}, 최고 기온은 {max_temperature}로 예상됩니다.')
    print(f'비올 확률은 {precipitation}이고, 미세먼지 수준은 {dust_concentration}입니다.')
    print(f'일출 시간은 오전 {sunrise_hour}시 {sunrise_minute}분, 일몰 시간은 오후 {sunset_hour}시 {sunset_minute}분입니다.')
    print(f'지금까지 {month}월 {day}일 {today}요일, 날씨 예보였습니다.')


def example5():
    sales = []

    for i in range(1, 4):
        sales.append(int(input(f'{i}월 매출 : ')))

    print(f'1분기 매출 현황 : {sum(sales)}')


def example6():
    width = int(input('가로 길이: '))
    height = int(input('세로 길이: '))
    print(f'넓이 : {width * height} cm^2')


def example7():
    weight = float(input('몸무게(kg): '))
    height = float(input('신장(m): '))
    BMI = int(weight / (height * height))
    print(f'BMI: {BMI}')


def example8():
    input_data = int(input('입력 값 : '))

    if input_data % 2 == 0:
        print(f'{input_data}는 짝수 입니다.')
    else:
        print(f'{input_data}는 홀수 입니다.')


def example9():
    bread_count = int(input('빵 갯수 입력 : '))
    distribution_count = int(input('배분 갯수 입력 : '))

    friend_count = bread_count // distribution_count
    remain_count = bread_count % distribution_count

    print(f'{friend_count}명의 친구에게 나눠줄 수 있으며, {remain_count}개의 빵이 남는다.')


def example10():
    infected_person = int(input('감염자 수 입력 : '))
    strength_of_infect = int(input('감염력 입력 : '))
    day_count = int(input('경과일 입력 : '))

    for i in range(0, day_count):
        infected_person = infected_person + (infected_person * strength_of_infect)

    print(f'{day_count}일 후 감염자 수는 {infected_person}입니다.')


if __name__ == '__main__':
    example3()
