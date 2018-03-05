package com.gyq.quiz.service.impl;

import com.gyq.quiz.domin.User;
import com.gyq.quiz.mapper.UanswerMapper;
import com.gyq.quiz.mapper.UserMapper;
import com.gyq.quiz.po.UScore;
import com.gyq.quiz.service.UserService;
import com.gyq.quiz.util.ComparatorUtil;
import com.gyq.quiz.vo.Nabean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.*;
@SuppressWarnings("unchecked")
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UanswerMapper uam;
    @Override
    public boolean regeditOK(User user) {
        int count=userMapper.insertUser(user);
        if(count==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        boolean ok=false;
        try {
            userMapper.updateUser(user);
            ok=true;
        } catch (SQLException e) {
            e.printStackTrace();
            ok=false;
        }
        return ok;
    }

    @Override
    public List<Nabean> findAllNabean(int qid) {
        List<Nabean> nabeanlist=new ArrayList<>();
        List<User> studentList = userMapper.findStudentList();
        List<UScore> usList = uam.findAnswerStudent(qid);
        Map<Integer,Integer> tmap=new HashMap<>();
        for (UScore us:usList) {
            tmap.put(us.getUid(),us.getScore());
        }
        for (User student: studentList) {
            Nabean bean=new Nabean();
            bean.setName(student.getName());
            bean.setUid(student.getUid());
            if(tmap.containsKey(student.getUid())){
                bean.setOver(true);
                bean.setScore((tmap.get(student.getUid())==null)?400:tmap.get(student.getUid()));
            }else{
                bean.setOver(false);
            }
            nabeanlist.add(bean);
        }

        Comparator comp = new ComparatorUtil();
        Collections.sort(nabeanlist, comp);
        return nabeanlist;
    }


}
