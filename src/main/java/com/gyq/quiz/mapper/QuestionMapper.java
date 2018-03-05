package com.gyq.quiz.mapper;

import com.gyq.quiz.domin.Question;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface QuestionMapper {
    @Select("select * from question order by qid desc limit #{begin},#{count} ")
    List<Question> findAllQuestion(@Param("begin") int begin,@Param("count") int count);
    @Select("select max(qid) from question")
    int getQuestionCount();
    @Insert("insert into question (question,answer,qtext) values (#{question,jdbcType=LONGVARCHAR},#{answer,jdbcType=LONGVARCHAR},#{qtext,jdbcType=LONGVARCHAR})")
    int insertQuestion(Question question);
    @Select("select * from question where qid=#{qid}")
    Question findQuestionByQid(@Param("qid") int qid);
    @Update("update question set question=#{question,jdbcType=LONGVARCHAR},answer=#{answer,jdbcType=LONGVARCHAR},qtext=#{qtext,jdbcType=LONGVARCHAR} where qid=#{qid,jdbcType=INTEGER}")
    void updateQuestion(Question question) throws SQLException;
}
