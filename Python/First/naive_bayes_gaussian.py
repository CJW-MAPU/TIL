from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import GaussianNB, BernoulliNB, MultinomialNB
from tensorflow import device
from sklearn.datasets import load_wine
from sklearn.metrics import accuracy_score, recall_score, precision_score, f1_score, confusion_matrix


def main():
    dataset = load_wine()
    x_train, x_test, y_train, y_test = train_test_split(dataset['data'], dataset['target'])

    model = GaussianNB()
    model.fit(x_train, y_train)

    predict = model.predict(x_test)

    accuracy = accuracy_score(y_test, predict)
    # recall = recall_score(y_test, predict)
    # precision = precision_score(y_test, predict)
    # f1 = f1_score(y_test, predict)
    print(confusion_matrix(predict, y_test))
    print(accuracy)
    # print(recall)
    # print(precision)
    # print(f1)


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
