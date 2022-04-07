from sklearn.datasets import make_blobs
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import random


def check_core_point(eps, minPts, df, index):
    x, y = df.iloc[index]['X'], df.iloc[index]['Y']

    temp = df[((np.abs(x - df['X']) <= eps) & (np.abs(y - df['Y']) <= eps)) & (df.index != index)]

    if len(temp) >= minPts:
        return temp.index, True, False, False

    elif (len(temp) < minPts) and len(temp) > 0:
        return temp.index, False, True, False

    elif len(temp) == 0:
        return temp.index, False, False, True


def cluster_with_stack(eps, minPts, df):
    C = 1
    current_stack = set()
    unvisited = list(df.index)
    clusters = []

    while len(unvisited) != 0:
        first_point = True
        current_stack.add(random.choice(unvisited))

        while len(current_stack) != 0:
            curr_idx = current_stack.pop()
            neigh_indexes, iscore, isborder, isnoise = check_core_point(eps, minPts, df, curr_idx)

            if isborder & first_point:
                clusters.append((curr_idx, 0))
                clusters.extend(list(zip(neigh_indexes, [0 for _ in range(len(neigh_indexes))])))

                unvisited.remove(curr_idx)
                unvisited = [e for e in unvisited if e not in neigh_indexes]
                continue

            unvisited.remove(curr_idx)

            neigh_indexes = set(neigh_indexes) & set(unvisited)

            if iscore:
                first_point = False

                clusters.append((curr_idx, C))
                current_stack.update(neigh_indexes)
            elif isborder:
                clusters.append((curr_idx, C))
                continue
            elif isnoise:
                clusters.append((curr_idx, 0))
                continue

        if not first_point:
            C += 1

    return clusters


centers = [(0, 4), (5, 5), (8, 2)]
cluster_std = [1.2, 1, 1.1]

X, y = make_blobs(n_samples = 200, cluster_std = cluster_std, centers = centers, n_features = 2, random_state = 1)

eps = 0.6
minPts = 3

data = pd.DataFrame(X, columns = ["X", "Y"])
clustered = cluster_with_stack(eps, minPts, data)

idx , cluster = list(zip(*clustered))
cluster_df = pd.DataFrame(clustered, columns = ["idx", "cluster"])

plt.figure(figsize=(10,7))
for clust in np.unique(cluster):
    plt.scatter(X[cluster_df["idx"][cluster_df["cluster"] == clust].values, 0], X[cluster_df["idx"][cluster_df["cluster"] == clust].values, 1], s=10, label=f"Cluster{clust}")

plt.legend([f"Cluster {clust}" for clust in np.unique(cluster)], loc ="lower right")
plt.title('Clustered Data')
plt.xlabel('X')
plt.ylabel('Y')
plt.show()
