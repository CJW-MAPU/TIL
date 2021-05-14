import urllib.request
import pandas
from datetime import datetime

import numpy as np
import pandas as pd
import matplotlib.pyplot as plt

if __name__ == '__main__':

    y1 = [350, 410, 520, 695]
    y2 = [200, 250, 385, 350]
    x = range(len(y1))

    plt.bar(x, y1, width = 0.7, color = "blue")
    plt.bar(x, y2, width = 0.7, color = "red", bottom = y1)
    plt.title('Quarterly sales')
    plt.xlabel('Quarters')
    plt.ylabel('sales')
    xLabel = ['first', 'second', 'third', 'fourth']
    plt.xticks(x, xLabel, fontsize = 10)
    plt.legend(['chairs', 'desks'])
    plt.show()


    # print(np.__version__)
    # ar1 = np.array([1, 2, 3, 4, 5])
    # print(ar1)
    # print(type(ar1))
    # ar2 = np.array([[1, 2, 3],
    #                [4, 5, 6]])
    # print(ar2)
    #
    # ar3 = np.arange(1, 11, 2)
    # print(ar3)
    #
    # ar4 = np.array([1, 2, 3, 4, 5, 6]).reshape(3, 2)
    # print(ar4)
    #
    # ar5 = np.zeros((2, 3))
    # print(ar5)

    # print(pd.__version__)
    # data1 = [10, 20, 30, 40, 50]
    #
    # sr1 = pd.Series(data1)
    # print(sr1)
    #
    # data_dic = {
    #     'year': [2018, 2019, 2020],
    #     'sales': [350, 480, 1099]
    # }
    # print(data_dic)
    # df_index = np.arange(1, len(data_dic.get('year')) + 1)
    #
    # df1 = pd.DataFrame(data_dic, index = df_index)
    #
    # print(df1)
    #
    # df2 = pd.DataFrame([[89.2, 92.5, 90.8], [92.8, 89.9, 95.2]], index = ['중간고사', '기말고사'], columns = ['1반', '2반', '3반'])
    #
    # print(df2)
    #
    # data_df = [
    #     ['20201101', 'Hong', '90', '95'],
    #     ['20201102', 'Kim', '93', '94'],
    #     ['20201103', 'Lee', '87', '97']
    # ]
    #
    # df3 = pd.DataFrame(data_df)
    # df3.columns = ['학번', '이름', '중간고사', '기말고사']
    #
    # print(df3)
    #
    # # df3.to_csv('score.csv', header = True)
    # df4 = pd.read_csv('score.csv', encoding = 'utf-8', index_col = 0, engine = 'python')
    # print(df4)
    #
    # x = [2016, 2017, 2018, 2019, 2020]
    # y = [350, 410, 520, 695, 543]
    #
    # plt.plot(x, y)
    # plt.title('Annual Sales')
    # plt.xlabel('years')
    # plt.ylabel('sales')
    # plt.show()

    # a = 1 + 2j  # 복소수 정의
    # print(a.real)  # 실수 부분 출력
    # print(a.imag)  # 허수 부분 출력
    # print(a.conjugate())  # 복소수 출력
    #
    # str1 = 'Hello, World!'
    # print(str1)
    # str2 = 'Hello,World'
    # str3 = str2.split(',')
    # print(str3)
    #
    # aa = [1, 2, 3]
    # bb = ['Life', 'is', 'too', 'short']
    #
    # print(bb[0] + " hi~ ^^;")
    # print("%d %s" % (aa[0], "hi~ ^^;"))
    #
    # t1 = (1, 2, 3)
    # print(t1)
    #
    # dic = { 'name': 'Hong', 'phone': '01012345678', 'birth': '0814' }
    # print(dic)
    # del dic['name']
    # print(dic)
    #
    # s1 = { 1, 2, 3, 4, 5, 6 }
    # print(s1)
    #
    # s1.update([7, 8, 9])
    # print(s1)
    #
    # s1.remove(9)
    # print(s1)
    #
    # print(dir([1, 2, 3]))  # 객체가 가지고 있는 메소드나 변수 출력
    #
    # Sub = lambda param1, param2: {
    #     param1 - param2
    #     if param1 >= param2
    #     else param2 - param1
    # }
    #
    # print(Sub(3, 1))
    #
    # print(urllib.request.Request('http://www.hanb.co.kr'))
    # print(pandas.DataFrame())
    # print(datetime.now())
    # f = open("test.txt", "r")
    #
    # lines = f.readlines()
    #
    # for line in lines:
    #     print(line, end="")
    #
    # f.close()
