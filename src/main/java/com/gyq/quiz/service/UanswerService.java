package com.gyq.quiz.service;

import com.gyq.quiz.domin.Uanswer;
import com.gyq.quiz.vo.NaQuestion;

import java.util.List;

public interface UanswerService {
    Uanswer findStuAnswer(int qid,int uid);
    boolean updateScore(Uanswer uanswer);
    boolean updateUanswer(Uanswer uanswer);
    List<NaQuestion> findNqByUid(int uid);
}
