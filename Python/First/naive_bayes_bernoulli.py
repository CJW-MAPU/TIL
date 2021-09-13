from tensorflow import device
from sklearn.datasets import load_breast_cancer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import BernoulliNB, GaussianNB, MultinomialNB
from sklearn.metrics import confusion_matrix, accuracy_score


def main():
    dataset = load_breast_cancer()

    x_train, x_test, y_train, y_test = train_test_split(dataset['data'], dataset['target'])

    model = BernoulliNB()

    model.fit(x_train, y_train)
    predict = model.predict(x_test)
    print(confusion_matrix(predict, y_test))
    print(accuracy_score(predict, y_test))


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
