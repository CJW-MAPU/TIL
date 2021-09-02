import tensorflow
from keras.models import Sequential
from keras.layers import SimpleRNN, Dense
from sklearn.preprocessing import MinMaxScaler
from sklearn.metrics import mean_squared_error
from sklearn.model_selection import train_test_split
import math
import numpy as np
import matplotlib.pyplot as plt
from pandas import read_csv


def main():
    with tensorflow.device('/CPU:0'):
        dataframe = read_csv('./corona_daily.csv', usecols = [3], engine = 'python', skipfooter = 3)
        dataset = dataframe.values
        dataset = dataset.astype('float32')

        scaler = MinMaxScaler(feature_range = (0, 1))

        Dataset = scaler.fit_transform(dataset)

        train_data, test_data = train_test_split(Dataset, test_size = 0.2, shuffle = False)

        print(len(train_data), len(test_data))

        look_back = 3
        x_train, y_train = create_dataset(train_data, look_back)
        x_test, y_test = create_dataset(test_data, look_back)

        print(x_train.shape, y_train.shape)
        print(x_test.shape, y_test.shape)

        x_train = np.reshape(x_train, (x_train.shape[0], 1, x_train.shape[1]))
        x_test = np.reshape(x_test, (x_test.shape[0], 1, x_test.shape[1]))

        model = Sequential()
        model.add(SimpleRNN(3, input_shape = (1, look_back)))
        model.add(Dense(1, activation = "linear"))
        model.compile(loss = 'mse', optimizer = 'adam')
        model.summary()

        model.fit(x_train, y_train, epochs = 100, batch_size = 1, verbose = 1)

        trainPredict = model.predict(x_train)
        testPredict = model.predict(x_test)
        TrainPredict = scaler.inverse_transform(trainPredict)
        y_train = scaler.inverse_transform([y_train])
        TestPredict = scaler.inverse_transform(testPredict)
        y_test = scaler.inverse_transform([y_test])

        trainScore = math.sqrt(mean_squared_error(y_train[0], TrainPredict[:, 0]))
        print("Train Score : %.2f RMSE" % trainScore)
        testScore = math.sqrt(mean_squared_error(y_test[0], TestPredict[:, 0]))
        print("Test Score : %.2f RMSE" % testScore)

        trainPredictPlot = np.empty_like(dataset)
        trainPredictPlot[:, :] = np.nan
        trainPredictPlot[look_back:len(TrainPredict) + look_back, :] = TrainPredict

        testPredictPlot = np.empty_like(dataset)
        testPredictPlot[:, :] = np.nan
        testPredictPlot[len(TrainPredict) + (look_back + 1) * 2: len(dataset), :] = TestPredict

        plt.plot(dataset)
        plt.plot(trainPredictPlot)
        plt.plot(testPredictPlot)
        plt.show()


def create_dataset(dataset, look_back):
    x_data = []
    y_data = []

    for i in range(len(dataset) - look_back - 1):
        data = dataset[i:(i + look_back), 0]
        x_data.append(data)
        y_data.append(dataset[i + look_back, 0])

    return np.array(x_data), np.array(y_data)


if __name__ == '__main__':
    main()

