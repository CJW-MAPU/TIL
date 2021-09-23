import pandas as pd
from tensorflow import device
from sklearn.model_selection import train_test_split
from sklearn.preprocessing import StandardScaler
import numpy as np
from sklearn.datasets import load_wine


def main():
    # df_wine = pd.read_csv('https://archive.ics.uci.edu/ml/machine_learning-databases/wine/wine.data', header = None)

    # X, y = df_wine.iloc[:, 1:].values, df_wine.iloc[:, 0].values
    dataset = load_wine()
    X_train, X_test, y_train, y_test = train_test_split(dataset['data'], dataset['target'], test_size = 0.3, stratify = dataset['target'], random_state = 0)
    sc = StandardScaler()

    X_train_std = sc.fit_transform(X_train)
    X_test_std = sc.transform(X_test)

    cov_mat = np.cov(X_train_std.T)
    eigen_vals, eigen_vecs = np.linalg.eig(cov_mat)
    print(eigen_vecs)

    print('\n고윳값 \n%s' % eigen_vals)
    eigen_pairs = [(np.abs(eigen_vals[i]), eigen_vecs[:, i]) for i in range(len(eigen_vals))]

    eigen_pairs.sort(key = lambda k: k[0], reverse = True)

    w = np.hstack((eigen_pairs[0][1][:, np.newaxis],
                   eigen_pairs[1][1][:, np.newaxis]))
    print(eigen_vecs)
    print('투영 행렬 W:\n', w)


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
