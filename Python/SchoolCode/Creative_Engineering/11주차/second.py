temperature = float(input('input temp : '))
want_temp = float(input('input want_temp : '))

if temperature <= 0:
    print('영하니까 히터 킴')
    print(f'영상 2도 까지 {want_temp - temperature} 도 올림.')
else:
    print('영상이니 에어컨 킴')
    print(f'영하 1도 까지 {-(want_temp - temperature)} 도 내림.')
