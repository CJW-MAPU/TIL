bread_count = int(input('빵 갯수 입력 : '))
distribution_count = int(input('배분 갯수 입력 : '))

friend_count = bread_count // distribution_count
remain_count = bread_count % distribution_count

print(f'{friend_count}명의 친구에게 나눠줄 수 있으며, {remain_count}개의 빵이 남는다.')