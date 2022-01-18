import pandas
from pandas import DataFrame


def drop_columns(dataset: DataFrame, path: str) -> None:
    """
    :param dataset: 차원 축소를 진행항 데이터셋.
    :param path: 차원 축소가 완료된 결과를 저장할 경로.
    :return None:
    """

    n = 2  # drop 할 Column 번호.

    # for 구문 : 데이터셋의 Feature Column 수만큼 반복하여 의미없는 Column 을 Drop.
    #           ( Column 의 총합이 0 인 경우. -> 모든 유저가 채집을 하지 않는 좌표. )
    for i in range(2, len(dataset.columns) - 1):
        if dataset[dataset.columns[n]].sum() == 0:
            dataset = dataset.drop(dataset.columns[n], axis = 'columns')
        else:
            n += 1

    dataset.to_csv(path, sep = ',', index = False)

