from tensorflow import device
from sklearn.decomposition import KernelPCA
from sklearn.decomposition import PCA
from sklearn.datasets import make_moons
import matplotlib.pyplot as plt


def main():
    X, y = make_moons(n_samples = 100, random_state = 123)
    scikit_kpca = KernelPCA(n_components = 2, kernel = 'rbf', gamma = 15)
    # scikit_kpca = PCA(n_components = 2)

    X_skernpca = scikit_kpca.fit_transform(X)

    plt.scatter(X_skernpca[y == 0, 0], X_skernpca[y == 0, 1], color = 'red', marker = '^', alpha = 0.5)
    plt.scatter(X_skernpca[y == 1, 0], X_skernpca[y == 1, 1], color = 'blue', marker = 'o', alpha = 0.5)

    plt.xlabel('PC1')
    plt.ylabel('PC2')
    plt.tight_layout()
    plt.show()


if __name__ == '__main__':
    with device('/CPU:0'):
        main()