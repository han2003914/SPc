package com.han.service;

import com.han.dao.UserMapper;
import com.han.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;


    public User queryUser(Integer userId){
        User user = userMapper.selectByPrimaryKey(userId);
        return user;
    }
}
