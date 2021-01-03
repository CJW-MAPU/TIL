package com.spring.dao;

import com.spring.dto.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("userAuthDAO")
public class UserAuthDAO {
    @Autowired
    private SqlSessionTemplate sqlSession;

    public UserVO getUserById(String username) {
        return sqlSession.selectOne("user.selectUserById", username);
    }
}
