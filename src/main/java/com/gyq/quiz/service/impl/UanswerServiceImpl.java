package com.gyq.quiz.service.impl;

import com.gyq.quiz.domin.Uanswer;
import com.gyq.quiz.mapper.QuestionMapper;
import com.gyq.quiz.mapper.UanswerMapper;
import com.gyq.quiz.service.UanswerService;
import com.gyq.quiz.vo.NaQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
public class UanswerServiceImpl implements UanswerService {
    @Autowired
    UanswerMapper uam;
    @Autowired
    QuestionMapper qm;
    @Override
    public Uanswer findStuAnswer(int qid, int uid) {
        Uanswer uanswer = uam.findStuAnswer(uid, qid);
        return uanswer;
    }

    @Override
    public boolean updateScore(Uanswer uanswer) {
        boolean ok=false;
        try {
            uam.updateScore(uanswer);
            ok=true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ok;
    }

    @Override
    public boolean updateUanswer(Uanswer uanswer) {
        boolean ok=false;
        int count = uam.updateStuAnswer(uanswer);
        if(count==1)
        ok=true;
        return ok;
    }

    @Override
    public List<NaQuestion> findNqByUid(int uid) {
        List<NaQuestion> naqlist = uam.findNaQuestionByUid(uid);
        return naqlist;
    }
}
