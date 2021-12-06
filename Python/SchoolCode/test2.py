price = {
    '쌀': 9900, '상추': 1900, '고추': 2900, '마늘': 8900,
    '통닭': 5600, '햄': 6900, '치즈': 3900
}


def discount_price(discount_rate):
    data = {}
    for key in price.keys():
        data[key] = price[key] * (1 - (discount_rate / 100))

    return data


print('-' * 35)
print('-- 한빛마트 오늘의 할인 가격표 출력 시스템 --')
print('-' * 35)

input_data = int(input('오늘의 할인율을 입력하세요. '))
return_data = discount_price(input_data)

for discount_product in price.keys():
    print(f'{discount_product}\t: {price[discount_product]} 원 {input_data} %DC -> {int(return_data[discount_product])} 원')

print('-' * 35)
