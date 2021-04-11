import urllib.request
import pandas
from datetime import datetime

if __name__ == '__main__':
    a = 1 + 2j  # 복소수 정의
    print(a.real)  # 실수 부분 출력
    print(a.imag)  # 허수 부분 출력
    print(a.conjugate())  # 복소수 출력

    str1 = 'Hello, World!'
    print(str1)
    str2 = 'Hello,World'
    str3 = str2.split(',')
    print(str3)

    aa = [1, 2, 3]
    bb = ['Life', 'is', 'too', 'short']

    print(bb[0] + " hi~ ^^;")
    print("%d %s" % (aa[0], "hi~ ^^;"))

    t1 = (1, 2, 3)
    print(t1)

    dic = { 'name': 'Hong', 'phone': '01012345678', 'birth': '0814' }
    print(dic)
    del dic['name']
    print(dic)

    s1 = { 1, 2, 3, 4, 5, 6 }
    print(s1)

    s1.update([7, 8, 9])
    print(s1)

    s1.remove(9)
    print(s1)

    print(dir([1, 2, 3]))  # 객체가 가지고 있는 메소드나 변수 출력

    Sub = lambda param1, param2: {
        param1 - param2
        if param1 >= param2
        else param2 - param1
    }

    print(Sub(3, 1))

    print(urllib.request.Request('http://www.hanb.co.kr'))
    print(pandas.DataFrame())
    print(datetime.now())
