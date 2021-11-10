sea_level_temperature = float(input('해수면 온도(섭씨) : '))
depth_of_water = float(input('수심(미터) : '))
depth_of_water /= 10

result = sea_level_temperature - (depth_of_water * .5)
print(f'온도 : {float(result)} 도')
