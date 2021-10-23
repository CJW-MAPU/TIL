from tensorflow import device
from sklearn.datasets import load_iris
from sklearn.model_selection import train_test_split
from sklearn.linear_model import LogisticRegression
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis as LDA
from sklearn.preprocessing import StandardScaler
from sklearn.svm import SVC
from template import plot_decision_regions
import numpy as np
import matplotlib.pyplot as plt


def main():
    dataset = load_iris()

    X = dataset.data
    y = dataset.target

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.3, random_state = 1, stratify = y)

    sc = StandardScaler()
    sc.fit(X_train)

    svm = SVC(kernel = 'linear', C = 1.0, random_state = 1)

    X_train_std = sc.transform(X_train)
    X_test_std = sc.transform(X_test)

    lda = LDA(n_components = 2)

    X_decomp_train = lda.fit_transform(X_train_std, y_train)

    print(X_train_std.shape)
    print(X_decomp_train.shape)
    print(y_train.shape)

    # print(X_decomp_train)

    # X_combined_std = np.vstack((X_train_std, X_test_std))
    # y_combined = np.hstack((y_train, y_test))
    #
    # # lr = LogisticRegression(C = 100.0, random_state = 1)
    # # lr.fit(X_train_std, y_train)
    # svm.fit(X_train_std, y_train)
    #
    # plot_decision_regions(X_combined_std,
    #                       y_combined,
    #                       classifier = svm,
    #                       test_idx = range(105, 150))
    #
    # plt.xlabel('petal length [standardized]')
    # plt.ylabel('petal width [standardized]')
    # plt.legend(loc = 'upper left')
    # plt.tight_layout()
    # plt.show()


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
