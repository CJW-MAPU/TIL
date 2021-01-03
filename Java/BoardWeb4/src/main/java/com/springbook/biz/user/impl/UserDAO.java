package com.springbook.biz.user.impl;

import com.springbook.biz.common.AbstractDAO;
import com.springbook.biz.user.UserVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;

@Repository
public class UserDAO extends AbstractDAO {

    public UserVO getUser(UserVO vo) {
        System.out.println("===> JDBC로 getUser() 기능 처리");
        Object[] args = {vo.getId(), vo.getPassword()};

        return (UserVO) selectOneParam("com.springbook.biz.common.InterfaceDAO.selectOne", args);
    }
}