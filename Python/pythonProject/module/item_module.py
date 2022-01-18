import pandas
from pandas import DataFrame


def get_harvest_count(log: DataFrame, path: str) -> None:
    """
    :param log: 채집 횟수를 추출하기 위한 원시 로그 데이터.
    :param path: 추출한 채집 횟수를 저장하기 위한 경로.
    :return None:
    """

    feature = log[['actor', 'actor_account']]  # 유저를 구분하기 위한 유저 번호와 임의의 칼럼 추출.
    data = feature.groupby(by = ['actor'], as_index = False).count()  # 유저 번호를 기준으로 Group By 연산 진행 후 그룹 Count.
    data.rename(columns = {'actor_account': 'harvest_count'}, inplace = True)  # Column 명을 데이터에 맞춰 변경.

    data.to_csv(path, sep = ',', index = False)

