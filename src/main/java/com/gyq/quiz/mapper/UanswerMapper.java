package com.gyq.quiz.mapper;

import com.gyq.quiz.domin.Uanswer;
import com.gyq.quiz.po.UScore;
import com.gyq.quiz.vo.NaQuestion;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UanswerMapper {
    @Select("select a.uaid uaid,u.uid uid,name,q.qid qid,question,q.answer answer,a.answer uanswer,score from user u,question q,uanswer a where u.uid=a.uid and q.qid=a.qid")
    List<Uanswer> findAllUanswer();
    @Select("select uid,score from uanswer where qid=#{qid}")
    List<UScore> findAnswerStudent(@Param("qid") int qid);
    @Select("select a.uaid uaid,u.uid uid,name,q.qid qid,question,q.answer answer,a.answer uanswer,score from user u,question q,uanswer a where u.uid=a.uid and q.qid=a.qid and a.qid=#{qid} and a.uid=#{uid}")
    Uanswer findStuAnswer(@Param("uid")int uid,@Param("qid") int qid);
    @Insert("insert into uanswer (uid,qid,answer) values (#{uid,jdbcType=INTEGER},#{qid,jdbcType=INTEGER},#{uanswer,jdbcType=LONGVARCHAR})")
    int updateStuAnswer(Uanswer uanswer);
    @Select("select qid,score from uanswer where uid=#{uid}")
    List<NaQuestion> findNaQuestionByUid(@Param("uid") int uid);
    @Update("update uanswer set score=#{score,jdbcType=INTEGER} where qid=#{qid,jdbcType=INTEGER} and uid=#{uid,jdbcType=INTEGER}")
    void updateScore(Uanswer uanswer) throws SQLException;
}
