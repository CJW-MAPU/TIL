package com.exam.myapp;

import org.springframework.stereotype.Service;

@Service
public class MyServiceImpl implements MyService {

    @Override
    public MyVo find(int no) {
        MyVo vo = new MyVo();
        vo.setMyNo(no);

        if (no == 1) vo.setMyName("너부리");
        else if (no == 2) vo.setMyName("포로리");
        else vo.setMyName("미등록");

        return vo;
    }
}
