package com.study.service;

import com.study.dto.UserVO;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface UserService {
    public UserVO getUser(UserVO vo) throws Exception;

    public Date getTime() throws Exception;
}
