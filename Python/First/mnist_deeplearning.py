import tensorflow.python.eager.context
from tensorflow.keras.models import Sequential
from tensorflow.keras.layers import Dense, Activation
from tensorflow.keras.utils import to_categorical
from tensorflow.keras.datasets import mnist
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import confusion_matrix, accuracy_score
import numpy as np
import matplotlib.pyplot as plt

if __name__ == '__main__':
    with tensorflow.device('/CPU:0'):
        (x_train, y_train), (x_test, y_test) = mnist.load_data()

        X_train = x_train.reshape(60000, 784)
        X_test = x_test.reshape(10000, 784)
        X_train = X_train.astype('float32')
        X_test = X_test.astype('float32')

        X_train /= 255
        X_test /= 255

        # model = MultinomialNB()
        #
        # model.fit(X_train, y_train)
        #
        # predict = model.predict(X_test)
        #
        # print(confusion_matrix(y_test, predict))
        # print(accuracy_score(y_test, predict))

        print(X_train.shape)
        print(X_test.shape)

        Y_train = to_categorical(y_train, 10)
        Y_test = to_categorical(y_test, 10)

        print(Y_train.shape)
        print(Y_test.shape)

        model = Sequential()
        model.add(Dense(512, input_shape=(784,)))
        model.add(Activation('relu'))
        model.add(Dense(256))
        model.add(Activation('relu'))
        model.add(Dense(10))
        model.add(Activation('softmax'))
        model.summary()

        model.compile(loss = 'categorical_crossentropy', optimizer = 'adam', metrics = ['accuracy'])
        model.fit(X_train, Y_train, batch_size = 128, epochs = 10, verbose = 1)

        score = model.evaluate(X_test, Y_test)
        print('Test score:', score[0])
        print('Test accuracy:', score[1])

        predicted_classes = np.argmax(model.predict(X_test), axis = 1)
        print(predicted_classes)
        correct_indices = np.nonzero(predicted_classes == y_test)[0]
        incorrect_indices = np.nonzero(predicted_classes != y_test)[0]

        # plt.figure()
        # for i in range(25):
        #     plt.subplot(5, 5, i + 1)
        #     correct = correct_indices[i]
        #     plt.imshow(X_test[correct].reshape(28, 28), cmap = 'gray')
        #     plt.title("Predicted {}, Class {}".format(predicted_classes[correct], y_test[correct]))
        # plt.tight_layout()
        # plt.show()

        plt.figure()
        for i in range(9):
            plt.subplot(3, 3, i + 1)
            incorrect = incorrect_indices[i]
            plt.imshow(X_test[incorrect].reshape(28, 28), cmap = 'gray')
            plt.title("Predicted {}, Class {}".format(predicted_classes[incorrect], y_test[incorrect]))
        plt.tight_layout()
        plt.show()
