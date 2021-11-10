start = int(input('시작값 ==> '))
end = int(input('끝값 ==> '))
increase = int(input('증가값 ==> '))

result = 0
for i in range(start, end, increase):
    result += i

print(f'{start}에서 {end}까지 {increase}씩 증가한 값의 합 : {result}')
