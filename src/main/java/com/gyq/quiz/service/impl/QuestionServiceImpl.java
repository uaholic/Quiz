package com.gyq.quiz.service.impl;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.mapper.QuestionMapper;
import com.gyq.quiz.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    QuestionMapper qm;
    @Override
    public int getQuestionCount() {
        int count=0;
        try {
            count=qm.getQuestionCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    @Override
    public boolean addQuestion(Question question) {
        boolean ok=false;
        int count = qm.insertQuestion(question);
        if(count>0){
            ok=true;
        }
        return ok;
    }

    @Override
    public Question findQuestionByQid(int qid) {
        Question question = qm.findQuestionByQid(qid);
        return question;
    }

    @Override
    public boolean updateQuestion(Question question) {
        boolean ok=false;
        try {
            qm.updateQuestion(question);
            ok=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }
}
