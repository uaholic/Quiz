package com.gyq.quiz.service;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.domin.User;

import java.util.List;

public interface AdminService {
    List<Question> findAllQuestionByPage(int page,int count);
    List<User> findAllStudentByPage(int page,int count);
}
