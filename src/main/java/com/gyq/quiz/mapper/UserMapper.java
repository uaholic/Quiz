package com.gyq.quiz.mapper;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.domin.User;
import org.apache.ibatis.annotations.*;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from user where username=#{username}")
    User findUserByUsername(@Param("username") String username);
    @Insert("insert into user (name,username,password) values (#{name,jdbcType=VARCHAR},#{username,jdbcType=VARCHAR},#{password,jdbcType=VARCHAR})")
    int insertUser(User user);
    @Update("update user set password=#{password,jdbcType=VARCHAR} where uid=#{uid,jdbcType=INTEGER}")
    void updateUser(User user) throws SQLException;
    @Select("select * from user where author=0 order by uid asc limit #{begin},#{count} ")
    List<User> findAllStudent(@Param("begin") int begin, @Param("count") int count);
    @Select("select * from user where author=0 order by uid asc")
    List<User> findStudentList();
}
