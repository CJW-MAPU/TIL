from pandas import read_csv

dataset = read_csv('dataset/log_20100416.csv')
labels = read_csv('dataset/labeled_accounts.csv')
print(dataset.columns)
print(labels)
