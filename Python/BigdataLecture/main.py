import numpy as np
import pandas as pd
from matplotlib import pyplot as plt
from sklearn.datasets import load_iris
from sklearn.decomposition import PCA
from sklearn.metrics import confusion_matrix, accuracy_score
from sklearn.model_selection import train_test_split
from sklearn.neighbors import KNeighborsClassifier
from sklearn.cluster import KMeans
from module.KNN import KNN
from module.LSH import LSH


def make_dataset():
    a = np.random.rand(10000, 10)
    model = KMeans(n_clusters = 2, random_state = 431)
    model.fit(a)
    b = model.fit_predict(a)
    return np.hstack((a, b.reshape(-1, 1)))


def plot_data(X, y):
    pca = PCA()
    X_pca = pca.fit_transform(X)

    fig, ax = plt.subplots(figsize = (20, 14))
    plt.scatter(X_pca[y == 0, 0], X_pca[y == 0, 1], color = 'red', marker = 'o', alpha = 0.5)
    plt.scatter(X_pca[y == 1, 0], X_pca[y == 1, 1], color = 'blue', marker = 'o', alpha = 0.5)
    plt.xlabel('x', size = 24, labelpad = 15)
    plt.ylabel('y', size = 24, labelpad = 15)
    plt.legend(fontsize = 30)
    plt.show()


def main():
    data = make_dataset()
    dataset = pd.DataFrame(columns = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 'label'], data = data)
    X, y = dataset.iloc[:, :-1], dataset.iloc[:, -1]

    X_train, X_test, y_train, y_test = train_test_split(X, y, test_size = 0.01, random_state = 431)

    # @todo : 구성된 데이터 시각화
    # plot_data(X, y)

    # @todo : 구현한 KNN -> module KNN.py 파일 내 KNN 클래스
    # knn = KNN()
    # knn.fit(X_train, y_train)
    # predict = knn.predict(X_test)
    #
    # print(confusion_matrix(predict, y_test))
    # print(accuracy_score(predict, y_test))

    # @todo : 구현한 LSH -> module LSH.py 파일 내 LSH 클래스
    lsh = LSH()
    lsh.fit(X_train, y_train)
    predict = lsh.predict(X_test)

    print(confusion_matrix(predict, y_test))
    print(accuracy_score(predict, y_test))


if __name__ == '__main__':
    main()
