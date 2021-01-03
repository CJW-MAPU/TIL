package com.study.dao;

import com.study.dto.UserVO;
import org.apache.ibatis.annotations.Select;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;

import java.beans.ConstructorProperties;
import java.sql.Date;
import java.util.List;

@Repository
public interface UserDAO {
    @Select("SELECT * FROM USERS WHERE id=#{id} and password=#{password}")
    public UserVO getUser(UserVO vo) throws Exception;

    @Select("SELECT NOW()")
    public Date getTime() throws Exception;
}