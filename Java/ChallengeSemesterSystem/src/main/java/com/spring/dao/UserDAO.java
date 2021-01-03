package com.spring.dao;

import com.spring.dto.UserVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO {
    @Select("SELECT * FROM USERS WHERE id=#{id} and password=#{password}")
    public UserVO getUser(UserVO vo) throws Exception;
}
