import numpy
from pandas import DataFrame
import pandas
import numpy as np


def make_user_list(log: DataFrame, path: str) -> None:
    """
    :param log: 유저 리스트를 추출하기 위한 원시 로그 데이터.
    :param path: 추출한 유저 리스트를 저장하기 위한 경로.
    :return None:
    """

    data = log[['actor']]  # 원시 로그에서 유저 번호 추출.
    data = data.drop_duplicates(['actor'])  # 유저 번호의 중복 제거.
    data.to_csv(path, sep = ',', index = False)


def make_columns() -> list:
    """
    :return columns: 완성된 Column 명 리스트 반환.
    """

    # 데이터셋의 Column 명을 자동 생성. [actor, actor_account, ... , label] 형태.
    columns = list()
    columns.append('actor')
    columns.append('actor_account')
    for z in range(0, 32):
        for y in range(0, 36):
            for x in range(0, 37):
                _str = f'x{x}y{y}z{z}'
                columns.append(_str)
    columns.append('label')

    return columns


def divide_graph(data: DataFrame) -> np.ndarray:
    """
    :param data: 하나의 유저의 Feature Row 를 생성하기 위한 로그 데이터.
    :return harvest_array: 완성된 Feature Row 를 numpy 배열로 반환.
    """

    harvest_array = np.zeros(shape = (32, 36, 37), dtype = np.int64)  # 좌표가 찍힌 지점을 저장하기 위한 3차원 배열 생성.

    # for 구문 : 채집 로그의 좌표 데이터를 임의의 값으로 나누어 구별하고, 해당 범위 내에 몇 번의 로그가 발생하였는지 기록.
    for i in range(0, len(data)):
        temp = data.iloc[i, :]
        x = temp['location_x'] // 100
        y = temp['location_y'] // 100
        z = temp['location_z'] // 100
        harvest_array[z][y][x] += 1

    harvest_array = harvest_array.reshape(-1,)  # 완성된 3차원 배열을 1차원으로 Reshape
    return harvest_array


