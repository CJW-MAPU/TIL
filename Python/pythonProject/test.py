from pandas import read_csv

dataset = read_csv('dataset/log_20100416.csv')
labels = read_csv('dataset/labeled_accounts.csv')

log_143 = dataset[dataset['log_id'] == 143]

temp_feature = log_143[['actor', 'etc_num7']]

temp_feature = temp_feature.groupby(by = ['actor'], as_index = False).count()

print(temp_feature)
