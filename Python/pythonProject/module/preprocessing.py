import numpy
from pandas import DataFrame
import pandas
import numpy as np


def divide_graph(data: DataFrame) -> np.ndarray:
    """
    :param data:
    :return harvest_count:
    """
    harvest_array = np.zeros(shape = (32, 36, 37), dtype = np.int64)

    for i in range(0, len(data)):
        temp = data.iloc[i, :]
        x = temp['location_x'] // 100
        y = temp['location_y'] // 100
        z = temp['location_z'] // 100
        harvest_array[z][y][x] += 1

    harvest_array = harvest_array.reshape(-1,)
    return harvest_array


def make_user_list(target: DataFrame, data: DataFrame):
    """
    :param target:
    :param data:
    :return:
    """
    data1 = data[data['log_id'] == 205]
    data2 = data[data['log_id'] == 257]

    feature = pandas.concat([data1, data2])
    feature = feature.drop_duplicates(['actor'])

    result = DataFrame()
    result['actor'] = feature['actor']
    output = pandas.concat([target, result])
    output.drop_duplicates(['actor'])

    output.to_csv('./after/userlist_2.csv', sep = ',', index = False)
