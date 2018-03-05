package com.gyq.quiz.service.impl;

import com.gyq.quiz.domin.User;
import com.gyq.quiz.mapper.UserMapper;
import com.gyq.quiz.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User getRealUser(User user) {
        User tempUser=userMapper.findUserByUsername(user.getUsername());
        return tempUser;
    }
}
