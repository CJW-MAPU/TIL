package com.spring.service;

import com.spring.dto.UserVO;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    public UserVO getUser(UserVO vo) throws Exception;
}
