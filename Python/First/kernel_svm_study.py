from tensorflow import device
import numpy as np
import matplotlib.pyplot as plt
from sklearn.svm import SVC
from template import plot_decision_regions


def main():
    np.random.seed(1)

    X_xor = np.random.randn(200, 2)

    y_xor = np.logical_xor(X_xor[:, 0] > 0,
                           X_xor[:, 1] > 0)

    y_xor = np.where(y_xor, 1, -1)

    plt.scatter(X_xor[y_xor == 1, 0],
                X_xor[y_xor == 1, 1],
                c = 'b', marker = 'x',
                label = '1')

    plt.scatter(X_xor[y_xor == -1, 0],
                X_xor[y_xor == -1, 1],
                c = 'r', marker = 's',
                label = '-1')

    svm = SVC(kernel = 'rbf', random_state = 1, gamma = 0.10, C = 10.0)
    svm.fit(X_xor, y_xor)
    plot_decision_regions(X_xor, y_xor, classifier = svm)

    plt.legend(loc = 'upper left')s
    plt.tight_layout()
    plt.show()


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
