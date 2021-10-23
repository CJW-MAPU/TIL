from pandas import read_csv, merge
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.preprocessing import StandardScaler
from sklearn.svm import SVC
from sklearn.pipeline import make_pipeline
from tensorflow import device


def main():
    gaf = read_csv('./dataset/(after) Group activities features.csv')
    nmf = read_csv('./dataset/(after) Network measures features.csv')
    paf = read_csv('./dataset/(after) Player actions features.csv')
    pif = read_csv('./dataset/(after) Player information features.csv')
    sidf = read_csv('./dataset/(after) Social interaction diversity features.csv')

    gaf = gaf.drop(['A_Acc', 'Type'], axis = 'columns')
    nmf = nmf.drop(['A_Acc', 'Type'], axis = 'columns')
    paf = paf.drop(['A_Acc', 'Type'], axis = 'columns')
    pif = pif.drop(['A_Acc', 'Type'], axis = 'columns')
    sidf = sidf.drop(['A_Acc'], axis = 'columns')

    dataset = merge(gaf, nmf, on = 'Actor')
    dataset = merge(dataset, paf, on = 'Actor')
    dataset = merge(dataset, pif, on = 'Actor')
    dataset = merge(dataset, sidf, on = 'Actor')

    dataset = dataset.drop(['Actor'], axis = 'columns')

    x = dataset.iloc[:, :-1]
    y = dataset.iloc[:, -1]

    # y = y.replace('Human', '1')
    # y = y.replace('Bot', '0')
    # y = y.astype('float32')

    X_train, X_test, y_train, y_test = train_test_split(x, y, test_size = 0.3, stratify = y, random_state = 1)

    param_range = [0.0001, 0.001, 0.01, 0.1, 1.0, 10.0, 100.0, 1000.0]
    param_grid = [
        { 'svc__C': param_range,
          'svc__kernel': ['linear'] }
    ]

    pipeline = make_pipeline(
        StandardScaler(),
        SVC(random_state = 1)
    )

    gs = GridSearchCV(estimator = pipeline,
                      param_grid = param_grid,
                      scoring = 'accuracy',
                      cv = 10, refit = True,
                      n_jobs = -1, verbose = 10)

    gs = gs.fit(X_train, y_train)

    print(gs.best_score_)
    print(gs.best_params_)


if __name__ == '__main__':
    with device('/GPU:0'):
        main()
