from sklearn.datasets import make_blobs
import matplotlib.pyplot as plt
import pandas as pd
import numpy as np
import random


centers = [(0, 4), (5, 5), (8, 2)]
cluster_std = [1.2, 1, 1.1]

X, y = make_blobs(n_samples = 200, cluster_std = cluster_std, centers = centers, n_features = 2, random_state = 1)

