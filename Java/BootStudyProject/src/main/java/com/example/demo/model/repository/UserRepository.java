package com.example.demo.model.repository;

import com.example.demo.model.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Mapper
public class UserRepository {
    protected static final String NAMESPACE = "com.example.demo.model.repository.UserRepository";

    @Autowired private SqlSession sqlSession;

    public String getUser(UserEntity userEntity) {
        return sqlSession.selectOne(NAMESPACE + "loginCheck");
    }
}
