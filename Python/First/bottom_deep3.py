from tensorflow.keras.datasets import mnist
from tensorflow import device


def main():
    (x_train, y_train), (x_test, y_test) = mnist.load_data()

    print(x_train.shape)
    print(y_train.shape)
    print(x_test.shape)
    print(y_test.shape)


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
