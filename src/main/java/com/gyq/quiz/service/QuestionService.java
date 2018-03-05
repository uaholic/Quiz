package com.gyq.quiz.service;

import com.gyq.quiz.domin.Question;

public interface QuestionService {
    int getQuestionCount();
    boolean addQuestion(Question question);
    Question findQuestionByQid(int qid);
    boolean updateQuestion(Question question);
}
