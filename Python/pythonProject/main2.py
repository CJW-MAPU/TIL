import pandas
from pandas import read_csv
from module.item_module import get_harvest_count
from module.preprocessing import \
    make_user_list, divide_graph, make_columns
from module.decomposition import drop_columns
import matplotlib.pyplot as plt
from mpl_toolkits.mplot3d import Axes3D
import numpy as np
from sklearn.model_selection import train_test_split, GridSearchCV
from sklearn.pipeline import make_pipeline
from sklearn.preprocessing import StandardScaler, MinMaxScaler, MaxAbsScaler, RobustScaler
from sklearn.svm import SVC
from sklearn.linear_model import LogisticRegression
from sklearn.tree import DecisionTreeClassifier
from sklearn.neighbors import KDTree
from sklearn.metrics import confusion_matrix, accuracy_score, recall_score, precision_score, f1_score


# @TODO : make harvest_log_7days
data = pandas.DataFrame()  # 전체 로그를 저장하기 위한 Empty DataFrame.
# for 구문: 7일치의 로그을 각각 불러오며 처리하는 것보다 한 번에 저장해놓고 가공할 수 있도록,
#          2010. 04. 16 ~ 2010. 04. 22 기간의 채집 성공과 실패 로그를 따로 추출하여 저장.
for i in range(1, 8):
    load = read_csv(f'dataset/{i}.csv')  # 1일치 로그 불러오기.
    temp1 = load[load['log_id'] == 205]  # 채집 성공 로그 추출.
    temp2 = load[load['log_id'] == 257]  # 채집 실패 로그 추출.
    load = pandas.concat([temp1, temp2])  # 채집 성공 로그와 실패 로그 결합.
    data = pandas.concat([data, load])  # 전체 로그를 저장하기 위한 변수에 결합.

data.to_csv('./after/harvest_log_7days.csv', sep = ',', index = False)

# TODO : harvest_count 로그 추출
log = read_csv('research/harvest_log_7days.csv')  # 7일치의 채집 로그 불러오기.
get_harvest_count(log = log, path = './research/harvest_count.csv')  # 각 유저 별 채집 횟수를 추출하는 모듈 호출.

# TODO : make userlist.csv
log = read_csv('research/harvest_log_7days.csv')  # 7일치의 채집 로그 불러오기.
make_user_list(log = log, path = './research/userlist.csv')  # 7일의 기간 중 채집 로그를 남긴 유저의  리스트를 추출하는 모듈 호출.

# TODO : make Dataset
columns = make_columns()  # Column 명 생성 모듈 호출.

user_csv = read_csv('research/userlist.csv')  # 유저 리스트 불러오기.
log = read_csv('research/harvest_log_7days.csv')  # 7일간의 채집 로그 불러오기.
labels = read_csv('dataset/labeled_accounts.csv')  # 각 유저 별 라벨링 된 봇/휴먼 여부 불러오기.

labeled_dataframe = pandas.DataFrame(columns = columns)  # 라벨링 된 데이터를 저장할 DataFrame 생성.
no_labeled_dataframe = pandas.DataFrame(columns = columns)  # 라벨링 되지 않은 데이터를 저장할 DataFrame 생성.

for i, user in enumerate(user_csv.values.tolist()):  # 불러온 유저의 수 만큼 반복.
    data = log[log['actor'] == user[0]]  # 전체 로그에서 각 유저 별 로그 추출.
    data = data[['actor', 'actor_account', 'location_x', 'location_y', 'location_z']]  # 불러온 유저의 로그 데이터 중 좌표 데이터만을 추출.
    acc = data['actor_account'].values[0]  # 해당 유저의 계정 번호 추출.
    flag = False  # 봇/휴먼으로 레이블이 된 데이터를 구분하기 위한 Flag 변수.

    # try 구문: 유저의 봇/휴먼 라벨링 정보 추출.
    try:
        label = labels[labels['account_uid'] == acc]['class'].values[0]
    except IndexError:  # IndexError 가 발생한다면 봇/휴먼 라벨링이 되어있지 않은 캐릭터이다.
        label = 2  # 봇/휴먼 라벨링이 되어있지 않은 데이터는 추후 분리를 위해 임의의 값 저장.
        flag = True

    result = divide_graph(data)  # Feature Row 생성 모듈 호출.
    # Feature 가 담긴 numpy 배열에 유저 번호, 유저의 계정 번호, 라벨링 정보를 삽입하여 완성.
    result = np.insert(arr = result, obj = 0, values = acc, axis = 0)
    result = np.insert(arr = result, obj = 0, values = user[0], axis = 0)
    result = np.append(arr = result, values = [label], axis = 0)

    if not flag:  # 라벨링이 되어 있는 데이터라면 labeled_dataframe 변수에 Feature Row 저장.
        length = len(labeled_dataframe)
        labeled_dataframe.loc[length] = result.tolist()
    else:  # 라벨링이 되어 있지 않은 데이터라면 no_labeled_dataframe 변수에 Feature Row 저장.
        length = len(no_labeled_dataframe)
        no_labeled_dataframe.loc[length] = result.tolist()


labeled_dataframe.to_csv('./research/labeled_dataset.csv', sep = ',', index = False)  # 완성된 DataFrame 저장.
no_labeled_dataframe.to_csv('./research/no_labeled_dataset.csv', sep = ',', index = False)  # 완성된 DataFrame 저장.

# TODO : 차원 축소
labeled_data = read_csv('research/labeled_dataset.csv')
drop_columns(labeled_data, './research/dataset.csv')  # 데이터셋에서 의미를 가지지 않는 차원을 축소하기 위한 모듈 호출.

# TODO : 학습 해보기
dataset = read_csv('research/dataset.csv')  # 데이터셋 호출.
count = read_csv('research/harvest_count.csv')  # 채집 횟수 호출.

count = count.loc[count['harvest_count'] >= 1000]  # 1000 회 이상의 채집 로그를 기록한 유저 추출.
temp = count['actor'].tolist()  # 추출된 유저를 리스트 화.
dataset = dataset.loc[dataset['label'] == 0 | dataset['actor'].isin(temp)]  # 데이터셋에서 채집 횟수가 적은 봇 유저 제외.
dataset = dataset.drop(['actor', 'actor_account'], axis = 'columns')
x = dataset.iloc[:, :-1]
y = dataset.iloc[:, -1]

# 전체 데이터셋을 학습 70%, 테스트 30%의 비율로 나눔
X_train, X_test, y_train, y_test = train_test_split(x, y, test_size = 0.3, random_state = 1)

# 학습을 위한 파이프라인 구축.
pipeline = make_pipeline(
    StandardScaler(),  # 평균 0, 분산 1로 전처리.

    # LogisticRegression(C = 1.0, random_state = 1)  # Logistic Regression 학습.
    # SVC(C = 0.1, kernel = 'linear', random_state = 1)  # linear SVM 학습.
    DecisionTreeClassifier()  # 결정트리 학습.
)

pipeline.fit(X_train, y_train)  # 구축된 파이프라인을 학습.
predict = pipeline.predict(X_test)  # 학습된 모델을 토대로 테스트.

print(confusion_matrix(y_test, predict))  # Confusion Matrix 출력.
print(f'accuracy : {accuracy_score(y_test, predict)}')  # 정확도 출력.
print(f'recall : {recall_score(y_test, predict)}')  # 재현율 출력.
print(f'precision : {precision_score(y_test, predict)}')  # 정밀도 출력.
print(f'f1-score : {f1_score(y_test, predict)}')  # F1-Score 출력.
print()

