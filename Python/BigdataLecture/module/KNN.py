import numpy as np
from scipy.spatial import distance
from tqdm import tqdm


class KNN:
    __is_lsh = None
    __k = None
    __X = None
    __y = None

    @classmethod
    def __init__(cls, k = 5):
        cls.__k = k

    @classmethod
    def __get_distance(cls, p1, p2):
        return distance.euclidean(p1, p2)

    @classmethod
    def fit(cls, X, y):
        cls.__X = X
        cls.__y = y

    @classmethod
    def predict(cls, X_test):
        result = list()
        for i in tqdm(range(0, len(X_test))):
            dists = list()

            for j in range(0, len(cls.__X)):
                dists.append(cls.__get_distance(cls.__X.iloc[j, :], X_test.iloc[i, :]))

            sorted_idx = np.argsort(dists)
            sorted_labels = np.array(cls.__y.tolist())[sorted_idx]
            K_nearest_labels = sorted_labels[:cls.__k]

            count_dict = {}
            for label in K_nearest_labels:
                count_dict[label] = count_dict.get(label, 0) + 1

            _labels, count_labels = np.array(list(count_dict.keys())), np.array(list(count_dict.values()))
            result.append(_labels[count_labels.argmax()])
        return result
