/*
package com.study.dao;

import com.study.dao.UserDAO;
import com.study.dto.UserVO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Date;


public class UserDAOImpl implements UserDAO {
    @Autowired
    private SqlSession sqlSession;

    @Override
    public UserVO getUser(UserVO vo) {
        System.out.println(vo.getId());
        System.out.println(vo.getPassword());

        return sqlSession.selectOne("com.study.dao.UserDAO.getUser", vo);
    }

    @Override
    public Date getTime() {
        return sqlSession.selectOne("com.study.dao.UserDAO.getTime");
    }
}*/
