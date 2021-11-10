sales = []

for i in range(1, 4):
    sales.append(int(input(f'{i}월 매출 : ')))

print(f'1분기 매출 현황 : {sum(sales)}')