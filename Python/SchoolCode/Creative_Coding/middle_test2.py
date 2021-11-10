product_dict = dict()

while True:
    product = input('입력 물품 ==> ')

    if not product == 'z':
        count = int(input('재고량 ==> '))
        product_dict[product] = count
    else:
        break

print('*** 물품의 재고량 확인 ***')
while True:
    find_product = input('찾을 물품 ==> ')
    if not find_product == '':
        try:
            print(f'{product_dict[find_product]} 개 남았어요.')
        except KeyError:
            print('그 물품은 없어요.')
    else:
        break

