package com.gyq.quiz.service;

import com.gyq.quiz.domin.User;

public interface LoginService {
    User getRealUser(User user);
}
