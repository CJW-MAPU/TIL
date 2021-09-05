import numpy
from pandas import read_csv
from sklearn import ensemble
from sklearn.model_selection import train_test_split
from sklearn.metrics import mean_squared_error
from tensorflow import device
from tqdm import tqdm
import numpy as np
from matplotlib import pyplot as plt


def main():
    dataset = read_csv('./winequality-red.csv', sep = ';')

    x = dataset.iloc[:, :-1]
    y = dataset.iloc[:, -1]
    wine_names = np.array(dataset.columns)

    x_train, x_test, y_train, y_test = train_test_split(x, y, test_size = 0.3, random_state = 531)

    mse = []
    n_tree_list = range(50, 500, 10)
    wine_rf_model = None
    for i_trees in tqdm(n_tree_list):

        depth = None
        maxFeat = 4
        wine_rf_model = ensemble.RandomForestRegressor(n_estimators = i_trees, max_depth = depth,
                                                       max_features = maxFeat,
                                                       oob_score = False, random_state = 531)

        wine_rf_model.fit(x_train, y_train)

        prediction = wine_rf_model.predict(x_test)
        mse.append(mean_squared_error(y_test, prediction))

    plt.plot(n_tree_list, mse)
    plt.xlabel('Number of Trees in Ensemble')
    plt.ylabel('Mean Squared Error')
    plt.show()

    feature_importance = wine_rf_model.feature_importances_

    feature_importance = feature_importance / feature_importance.max()

    sorted_idx = numpy.argsort(feature_importance)

    bar_pos = numpy.arange(sorted_idx.shape[0])+.5
    plt.barh(bar_pos, feature_importance[sorted_idx], align = 'center')
    plt.yticks(bar_pos, wine_names[sorted_idx])
    plt.xlabel('Variable importance')
    plt.show()


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
