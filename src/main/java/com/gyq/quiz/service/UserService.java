package com.gyq.quiz.service;

import com.gyq.quiz.domin.User;
import com.gyq.quiz.vo.Nabean;

import java.util.List;

public interface UserService {
    boolean regeditOK(User user);
    boolean updateUser(User user);
    List<Nabean> findAllNabean(int qid);
}
