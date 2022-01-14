import pandas
from pandas import DataFrame


# TODO : Refactoring 가능.
def get_harvest_count(target: DataFrame, data: DataFrame):
    """
    :param target: 모듈 호출 시 넘겨받은 채집 횟수를 저장하기 위한 DataFrame.
    :param data: 2010. 04. 16 ~ 2010. 04. 22 기간의 로그 DataFrame.
    :return: None.
    """

    feature1 = data[data['log_id'] == 205]  # 채집 성공 로그 추출.
    feature2 = data[data['log_id'] == 257]  # 채집 실패 로그 추출.

    # 각각의 로그에서 필요한 유저 번호와 GroupBy 를 진행하기 위한 임의의 Column 추출.
    feature1 = feature1[['actor', 'actor_account']]
    feature2 = feature2[['actor', 'actor_account']]

    # 각각의 로그에서 유저 번호를 기준으로 GroupBy 를 진행. 결과는 actor_account Column 에 저장됨.
    feature1 = feature1.groupby(by = ['actor'], as_index = False).count()
    feature2 = feature2.groupby(by = ['actor'], as_index = False).count()

    # 각각의 로그를 하나로 합치고, 유저 번호를 기준으로 다시 한 번 GroupBy 를 진행하여 값을 더함.
    feature = pandas.concat([feature1, feature2])
    feature = feature.groupby(by = ['actor'], as_index = False).sum()

    # actor_account Column 에는 유저의 계정 정보가 아닌 채집 횟수가 담겨 있으므로,
    # 이를 적절한 Column 명으로 변경.
    feature.rename(columns = {'actor_account': 'harvest_count'}, inplace = True)

    # 저장을 위한 DataFrame 에 이어붙이고, GroupBy를 진행하여 중복된 값을 더하고, 기존의 파일에 덮어씌움.
    result = pandas.concat([target, feature1], axis = 0)
    result = result.groupby(by = ['actor'], as_index = False).sum()
    result.to_csv('./after/harvest_count.csv', sep = ',', index = False)
