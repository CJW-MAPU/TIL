infected_person = int(input('감염자 수 입력 : '))
strength_of_infect = int(input('감염력 입력 : '))
day_count = int(input('경과일 입력 : '))

for i in range(0, day_count):
    infected_person = infected_person + (infected_person * strength_of_infect)

print(f'{day_count}일 후 감염자 수는 {infected_person}입니다.')