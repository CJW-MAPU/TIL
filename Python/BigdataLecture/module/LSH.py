import numpy as np
import pandas
from scipy.spatial import distance
from tqdm import tqdm


class LSH:
    __X = None
    __y = None
    __threshold = None
    __hash_table = pandas.DataFrame(columns = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'label'])

    @classmethod
    def __init__(cls, threshold = 0.5):
        cls.__threshold = threshold

    @classmethod
    def __get_distance(cls, p1, p2):
        return distance.jaccard(p1, p2)

    @classmethod
    def __create_hash(cls, data):
        temp = list()
        for item in data:
            if item <= 0.5:
                temp.append(0)
            else:
                temp.append(1)
        result = pandas.DataFrame(columns = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9], data = [temp])
        return result

    @classmethod
    def fit(cls, X, y):
        cls.__X = X
        cls.__y = y

        temp = cls.__y.tolist()

        for i in range(len(cls.__X)):
            result = cls.__create_hash(cls.__X.iloc[i, :].tolist())
            result['label'] = temp[i]
            cls.__hash_table = pandas.concat([cls.__hash_table, result])

    @classmethod
    def predict(cls, X_test):
        # @todo : Hash 값 생성 (__Create_Hash method)
        # @todo : 해쉬 테이블이랑 비교 (__get_distance method)
        predict = []
        for i in tqdm(range(len(X_test))):
            temp = X_test.iloc[i, :]
            data = cls.__create_hash(temp)
            a = 0  # 1
            b = 0  # 0
            for j in range(len(cls.__hash_table)):
                _distance = cls.__get_distance(data, cls.__hash_table.iloc[j, :-1])
                label = cls.__hash_table.iloc[j, -1]
                if label == 1:
                    a += _distance
                else:
                    b += _distance
            if a < b:
                predict.append(1.0)
            else:
                predict.append(0.0)

        return predict
