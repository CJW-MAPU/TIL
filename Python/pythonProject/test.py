import pandas
from pandas import read_csv
from module.item_module import get_harvest_count
from module.preprocessing import make_user_list, divide_graph
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
from sklearn.model_selection import train_test_split
from sklearn.pipeline import make_pipeline
from sklearn.svm import SVC
from sklearn.preprocessing import StandardScaler
from sklearn.linear_model import LogisticRegression
from sklearn.metrics import confusion_matrix, accuracy_score, recall_score, precision_score, f1_score

# F5C158


# TODO : 학습 해보기
# dataset = read_csv('after/labeled_dataset.csv')
# dataset = dataset.drop(['actor', 'actor_account'], axis = 'columns')
#
# x = dataset.iloc[:, :-1]
# y = dataset.iloc[:, -1]
#
# X_train, X_test, y_train, y_test = train_test_split(x, y, test_size = 0.3, random_state = 1)
#
# pipeline = make_pipeline(
#     # LogisticRegression(C = 0.1, random_state = 1)
#     SVC(C = 0.1, kernel = 'linear', random_state  = 1)
# )
#
# pipeline.fit(X_train, y_train)
#
# predict = pipeline.predict(X_test)
#
# print(confusion_matrix(y_test, predict))
# print(f'accuracy : {accuracy_score(y_test, predict)}')
# print(f'recall : {recall_score(y_test, predict)}')
# print(f'precision : {precision_score(y_test, predict)}')
# print(f'f1-score : {f1_score(y_test, predict)}')


# @TODO : harvest_count 로그 추출
# 이거 코드 Refactoring 하고, 주석 다시 달기.
# for i in range(1, 8):
#     harvest_count_csv = read_csv('after/harvest_count.csv')  # 각 캐릭터 별 채집 횟수를 저장할 파일 불러오기.
#     log_str = f'{i}.csv'
#     data = read_csv(log_str)  # 2010. 04. 16 ~ 2010. 04. 22 기간의 로그 불러오기.
#     get_harvest_count(target = harvest_count_csv, data = data)  # 채집 시도(성공 및 실패) 횟수를 불러올 모듈 호출.
#     print(f'#{i} 번쨰 반복')

# @TODO : make userlist.csv
# 이거 코드 Refactoring 하고, 주석 달기.
# for i in range(1, 8):
#     user_list = read_csv('after/userlist_2.csv')
#     log_str = f'dataset/{i}.csv'
#     data = read_csv(log_str)
#     make_user_list(target = user_list, data = data)


# TODO : make Dataset
# 데이터셋의 Column 명 생성.
# columns = list()
# columns.append('actor')
# columns.append('actor_account')
# for z in range(0, 32):
#     for y in range(0, 36):
#         for x in range(0, 37):
#             _str = f'x{x}y{y}z{z}'
#             columns.append(_str)
# columns.append('label')
#
# user_csv = read_csv('after/userlist.csv')  # 유저 리스트 불러오기.
# log = read_csv('after/harvest_log_7days.csv')  # 7일간의 로그 불러오기.
# labels = read_csv('dataset/labeled_accounts.csv')  # 각 유저 별 라벨링 된 봇/휴먼 여부 불러오기.
#
# dataframe = pandas.DataFrame(columns = columns)  # 생성한 Column 명을 토대로 DataFrame 생성.
#
# for i, user in enumerate(user_csv.values.tolist()):  # 불러온 유저의 수 만큼 반복.
#     print(f'#{i + 1}번쨰 반복')
#     data = log[log['actor'] == user[0]]  # 전체 로그에서 반복으로 불러온 유저의 로그 데이터 추출.
#     # 불러온 유저의 로그 데이터 중 좌표 데이터만을 추출.
#     data = data[['actor', 'actor_account', 'location_x', 'location_y', 'location_z']]
#     acc = data['actor_account'].values[0]  # 해당 유저의 계정 번호 추출.
#
#     # try 구문: 유저의 봇/휴먼 라벨링 정보 추출.
#     try:
#         label = labels[labels['account_uid'] == acc]['class'].values[0]
#     except IndexError:  # IndexError 가 발생한다면 봇/휴먼 라벨링이 되어있지 않은 캐릭터이다.
#         label = 2  # 봇/휴먼 라벨링이 되어있지 않은 데이터는 추후 분리를 위해 임의의 값 저장.
#
#     result = divide_graph(data)  # Feature 생성 모듈 호출.
#     # Feature 가 담긴 numpy 배열에 유저 번호, 유저의 계정 번호, 라벨링 정보 삽입하여 완성.
#     result = np.insert(arr = result, obj = 0, values = acc, axis = 0)
#     result = np.insert(arr = result, obj = 0, values = user[0], axis = 0)
#     result = np.append(arr = result, values = [label], axis = 0)
#
#     # TODO : 임시 변수 삭제할 수 있도록 Refactoring 가능.
#     temp = pandas.DataFrame(columns = columns)  # 임시 DataFrame 생성.
#     temp.loc[1] = result.tolist()  # 임시 DataFrame 에 완성된 Feature Row 삽입.
#
#     dataframe = pandas.concat([dataframe, temp])  # 미리 생성한 최종 DataFrame 에 결합.
#     print(len(dataframe.index))
#
#
# dataframe.to_csv('./after/dataset.csv', sep = ',', index = False)  # 완성된 DataFrame 저장.

# @TODO : 차원 축소
# data = read_csv('after/dataset.csv')  # 제작한 데이터셋 불러오기.
# print(f'Initial Column Count : {len(data.columns)}')
# n = 2
#
# # for 구문: actor, actor_account, label 과 같이 구분하기 위한 Column 을 제외한
# #          모든 Column 을 각각 순회하며 Column 의 총합이 0이면 해당 Column 을 Drop.
# for i in range(2, len(data.columns) - 1):
#     print(f'#{i - 1} 번째 실행')
#     # print(data.sample(data.columns[i]).sum())
#     if data[data.columns[n]].sum() == 0:
#         data = data.drop(data.columns[n], axis = 'columns')
#     else:
#         n += 1
#
#     print(f'Column Count : {len(data.columns)}')
#
# data.to_csv('./after/drop_dataset.csv', sep = ',', index = False)


# @TODO : make harvest_log_7days
# data = pandas.DataFrame()
# # for 구문: 7일치의 로그을 각각 불러오며 처리하는 것보다 한 번에 저장해놓고 가공할 수 있도록,
# #          2010. 04. 16 ~ 2010. 04. 22 기간의 채집 성공과 실패 로그를 따로 추출하여 저장.
# for i in range(1, 8):
#     load = read_csv(f'dataset/{i}.csv')
#     temp1 = load[load['log_id'] == 205]
#     temp2 = load[load['log_id'] == 257]
#     load = pandas.concat([temp1, temp2])
#     data = pandas.concat([data, load])
#     print(f'#{i}')
#     print(data)
#
# data.to_csv('./after/harvest_log_7days.csv', sep = ',', index = False)

# TODO : 당연히 Refactoring 해야 하는 코드.
# harvest_count.csv 를 직접 확인하여 많은 횟수 채집을 진행한 Player Character 를
# bot/human/none 으로 나누어 좌표 데이터를 각각 추출하여 저장함.
# for i in range(1, 5):
#     # human_dataset = read_csv('after/human3.csv')
#     bot_dataset = read_csv('after/bot1.csv')
#     # none_dataset = read_csv('after/none2.csv')
#
#     log_str = f'dataset/{i}.csv'
#     data = read_csv(log_str)
#
#     # human_feature = data[data['actor_account'] == 20013166]
#     bot_feature = data[data['actor_account'] == 20005023]
#     # none_feature = data[data['actor_account'] == 20099637]
#
#     # human_feature1 = human_feature[human_feature['log_id'] == 205]
#     # human_feature2 = human_feature[human_feature['log_id'] == 257]
#     bot_feature1 = bot_feature[bot_feature['log_id'] == 205]
#     bot_feature2 = bot_feature[bot_feature['log_id'] == 257]
#     # none_feature1 = none_feature[none_feature['log_id'] == 205]
#     # none_feature2 = none_feature[none_feature['log_id'] == 257]
#
#     # human_feature = pandas.concat([human_feature1, human_feature2])
#     bot_feature = pandas.concat([bot_feature1, bot_feature2])
#     # none_feature = pandas.concat([none_feature1, none_feature2])
#
#     # human_feature = human_feature[['actor', 'location_x', 'location_y', 'location_z']]
#     bot_feature = bot_feature[['actor', 'location_x', 'location_y', 'location_z']]
#     # none_feature = none_feature[['actor', 'location_x', 'location_y', 'location_z']]
#
#     # human_result = pandas.concat([human_dataset, human_feature])
#     bot_result = pandas.concat([bot_dataset, bot_feature])
#     # none_result = pandas.concat([none_dataset, none_feature])
#
#     # human_result.to_csv('./after/human3.csv', sep = ',', index = False)
#     bot_result.to_csv('./after/bot1.csv', sep = ',', index = False)
#     # none_result.to_csv('./after/none2.csv', sep = ',', index = False)
#     print(f'#{i} 번쨰 반복')

# TODO : 20058154 - 800997 사람
# TODO : 20068218 - 801224 사람
# TODO : 20077101 - 804710 사람
# TODO : 20013166 - 808254 사람
# TODO : 20087381 - 800231 봇
# TODO : 20005023 - 806236 봇
# TODO : 20052072 - 806768 봇
# TODO : 20097023 - 813191 None
# TODO : 20059063 - 814803 None
# TODO : 20099637 - 815963 None

# 분석을 위해 추출한 샘플 데이터의 좌표 데이터를 3차원 산점도 그래프로 Plot 하고, svg 로 저장.
# human = read_csv('after/human3.csv')
# bot = read_csv('after/bot2.csv')
none = read_csv('after/none2.csv')

fig = plt.figure(figsize = (10, 10))
ax = fig.gca(projection = '3d')

for i in range(len(none)):
    x = none.iloc[i, 1]
    y = none.iloc[i, 2]
    z = none.iloc[i, 3]

    ax.scatter(x, y, z)
    print(f'#{i}')

ax.set_xlabel('location_x')
ax.set_ylabel('location_y')
ax.set_zlabel('location_z')
plt.title('815963 - None')
plt.savefig('None-8145963.svg')
plt.show()



