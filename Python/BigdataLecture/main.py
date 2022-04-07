import pandas
from sklearn.cluster import DBSCAN, MeanShift
from sklearn.decomposition import PCA
import matplotlib.pyplot as plt
from pandas import read_csv
import os
import collections


features = list()
with open('dataset/Features.txt') as f:
    features = [line.split()[1] for line in f.readlines()]
print('features: {}'.format(len(features)))

X_train = pandas.read_csv('dataset/train/X_train.txt', delim_whitespace = True, header = None)
X_train.columns = [features]

pca = PCA(n_components = 2)

X_decomp_train = pca.fit_transform(X_train)

model = DBSCAN()
predict = pandas.DataFrame(model.fit_predict(X_decomp_train))
predict.columns = ['predict']
asd = pandas.DataFrame(X_decomp_train)

result = pandas.concat([asd, predict], axis = 1)

plt.scatter(result[, 0], result_0[:, 1], label = 'cluster -1', cmap = 'Pairs')
# plt.scatter(result_1[:, 0], result_1[:, 1], label = 'cluster 0', cmap = 'Pairs')
# plt.scatter(result_2[:, 0], result_2[:, 1], label = 'cluster 1', cmap = 'Pairs')

plt.xlabel('PCA 0')
plt.ylabel('PCA 1')
plt.legend()
plt.show()





