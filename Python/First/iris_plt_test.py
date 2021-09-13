import pandas as pd
from tensorflow import device
from sklearn.datasets import load_iris
import numpy as np
import matplotlib.pyplot as plt
import Perceptron


if __name__ == '__main__':
    with device('/CPU:0'):
        dataset = load_iris()
        df = pd.DataFrame(data = np.c_[dataset['data'], dataset['target']],
                          columns = dataset['feature_names'] + ['target'])

        y = df.iloc[0:100, 4].values
        y = np.where(y == 0.0, -1, 1)
        X = df.iloc[0:100, [0, 2]].values

        plt.scatter(X[:50, 0], X[:50, 1],
                    color = 'red', marker = 'o', label = 'setosa')
        plt.scatter(X[50:100, 0], X[50:100, 1],
                    color = 'blue', marker = 'x', label = 'versicolor')
        # plt.scatter(X[100:150, 0], X[100:150, 1],
        #             color = 'green', marker = '*', label = 'virginica')

        plt.xlabel('sepal length [cm]')
        plt.ylabel('petal length [cm]')
        plt.legend(loc = 'upper left')
        plt.show()

        ppn = Perceptron.Perceptron(eta = 0.1, n_iter = 10)
        ppn.fit(X, y)
        plt.plot(range(1, len(ppn.errors_) + 1), ppn.errors_, marker = 'o')
        plt.xlabel('Epochs')
        plt.ylabel('Number of updates')
        plt.show()
