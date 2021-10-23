from pandas import read_csv, merge
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.preprocessing import StandardScaler
from sklearn.decomposition import KernelPCA, PCA, IncrementalPCA
from sklearn.discriminant_analysis import LinearDiscriminantAnalysis
from sklearn.manifold import TSNE, LocallyLinearEmbedding
from sklearn.linear_model import LogisticRegression
from sklearn.svm import SVC
from sklearn.metrics import confusion_matrix, accuracy_score, f1_score
from matplotlib import pyplot as plt
from sklearn.pipeline import make_pipeline
import tensorflow as tf
from tensorflow.python.client import device_lib
from tensorflow import device


def main():
    gaf = read_csv('dataset/(after) Group activities features.csv')
    nmf = read_csv('dataset/(after) Network measures features.csv')
    paf = read_csv('dataset/(after) Player actions features.csv')
    pif = read_csv('dataset/(after) Player information features.csv')
    sidf = read_csv('dataset/(after) Social interaction diversity features.csv')

    gaf = gaf.drop(['A_Acc', 'Type'], axis = 'columns')
    nmf = nmf.drop(['A_Acc', 'Type'], axis = 'columns')
    paf = paf.drop(['A_Acc', 'Type'], axis = 'columns')
    pif = pif.drop(['A_Acc', 'Type'], axis = 'columns')
    sidf = sidf.drop(['A_Acc'], axis = 'columns')

    dataset = merge(gaf, nmf, on = 'Actor')
    # dataset = merge(gaf, paf, on = 'Actor')
    dataset = merge(dataset, paf, on = 'Actor')
    dataset = merge(dataset, pif, on = 'Actor')
    dataset = merge(dataset, sidf, on = 'Actor')

    dataset = dataset.drop(['Actor'], axis = 'columns')
    # dataset = dataset[[
    #     'Avg_PartyTime',
    #     'GuildAct_count',
    #     'GuildJoin_count',
    #     'Exp_get_ratio',
    #     'Exp_get_count',
    #     'exp_get_count_per_day',
    #     'Item_get_ratio',
    #     'Item_get_count',
    #     'item_get_count_per_day',
    #     'Money_get_ratio',
    #     'Money_get_count',
    #     'money_get_count_per_day',
    #     'Abyss_get_ratio',
    #     'Abyss_get_count',
    #     'abyss_get_count_per_day',
    #     'Use_portal_count',
    #     'Use_portal_count_per_day',
    #     'Playtime',
    #     'playtime_per_day',
    #     'Social_diversity',
    #     'Type'
    # ]]
    print('aaa')
    x = dataset.iloc[:, :-1]
    y = dataset.iloc[:, -1]

    y = y.replace('Human', '1')
    y = y.replace('Bot', '0')
    y = y.astype('int')

    X_train, X_test, y_train, y_test = train_test_split(x, y, test_size = 0.3, random_state = 1)

    param_range = [ 0.0001, 0.001, 0.01, 0.1, 1.0, 10.0, 100.0, 1000.0 ]
    param_grid = [
        {'svc__C': param_range,
         'svc__kernel': ['linear']}
    ]

    pipeline = make_pipeline(
        StandardScaler(),
        # PCA(n_components = 2),
        # KernelPCA(n_components = 2, kernel = 'rbf', gamma = 0.1),
        # LocallyLinearEmbedding(n_components = 2, random_state = 1),
        # LogisticRegression(C = 1.0, random_state = 1, penalty = 'none')
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

    # pipeline.fit(X_train, y_train)

    # predict = pipeline.predict(X_test)

    # print('f1_score : ')
    # print(f1_score(y_test, predict))
    # print()
    # print('accuracy : ')
    # print(accuracy_score(y_test, predict))
    # print()
    # print('confusion_matrix : ')
    # print(confusion_matrix(y_test, predict))



    # sc = StandardScaler()
    #
    # X_standard_train = sc.fit_transform(X_train)
    # X_standard_test = sc.transform(X_test)

    # svm = SVC(kernel = 'rbf', gamma = 1.0, C = 1.0)
    # svm = LogisticRegression(random_state = 1)
    # svm.fit(X_train, y_train)
    #
    # predict = svm.predict(X_test)
    #
    # print(confusion_matrix(y_test, predict))

    # pca = KernelPCA(n_components = 2, kernel = 'sigmoid', gamma = 0.1)
    # pca = PCA(n_components = 2)
    # pca = IncrementalPCA(n_components = 2)
    # lda = LinearDiscriminantAnalysis(n_components = 2)
    # lle = LocallyLinearEmbedding(n_components = 2, random_state = 1)
    # tsne = TSNE(n_components = 2, random_state = 1)

    # X_decomp_train = lle.fit_transform(X_standard_train, y_train)
    # X_decomp_train = tsne.fit_transform(X_standard_train, y_train)
    # X_decomp_train = pca.fit_transform(X_standard_train, y_train)
    # X_decomp_train = lda.fit_transform(X_standard_train, y_train)
    # X_decomp_test = pca.transform(X_standard_test)

    # plt.scatter(X_decomp_train[y_train == 1, 0], X_decomp_train[y_train == 1, 1], color = 'red', marker = 'o')
    # # plt.scatter(X_decomp_train[y_train == 0, 0], X_decomp_train[y_train == 0, 1], color = 'blue', marker = 'x')
    #
    # plt.title('All Features TSNE Human')
    # plt.xlabel('PC1')
    # plt.ylabel('PC2')
    # plt.show()


if __name__ == '__main__':
    with device('/CPU:0'):
        main()
    # print(tf.config.list_physical_devices())
    # print(device_lib.list_local_devices())
