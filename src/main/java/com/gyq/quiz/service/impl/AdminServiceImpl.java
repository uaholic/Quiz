package com.gyq.quiz.service.impl;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.domin.User;
import com.gyq.quiz.mapper.QuestionMapper;
import com.gyq.quiz.mapper.UserMapper;
import com.gyq.quiz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    QuestionMapper qm;
    @Override
    public List<Question> findAllQuestionByPage(int page,int count) {
        int begin=(page-1)*count;
        List<Question> qlist=qm.findAllQuestion(begin,count);
        return qlist;
    }
    @Autowired
    UserMapper um;
    @Override
    public List<User> findAllStudentByPage(int page, int count) {
        int begin=(page-1)*count;
        List<User> ulist=um.findAllStudent(begin,count);
        return ulist;
    }
}
