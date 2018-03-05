package com.gyq.quiz.controller;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Value("${pagecount}")
    int count;
    @Value("${format.len}")
    int formatlen;
    @Autowired
    AdminService as;
    @RequestMapping("/admin")
    public ModelAndView adminHandler(){
        ModelAndView mav=new ModelAndView("admin");
        return mav;
    }
    @RequestMapping("/questionList")
    public ModelAndView questionList(Integer page){
        ModelAndView mav=new ModelAndView("questionlist");
        if(page==null||page<1){
            page=1;
        }
        List<Question> qlist = as.findAllQuestionByPage(page,this.count);
        for (Question q:qlist) {
            if(q.getQuestion().length()>this.formatlen){
                q.setQuestion(q.getQuestion().substring(0,this.formatlen)+"...");
            }
            if(q.getAnswer().length()>this.formatlen){
                q.setAnswer(q.getAnswer().substring(0,this.formatlen)+"...");
            }
        }
        mav.addObject("page",page);
        mav.addObject("qlist",qlist);
        return mav;
    }
    @RequestMapping("/studentList")
    public ModelAndView studentList(Integer page){
        ModelAndView mav=new ModelAndView("studentlist");
        if(page==null||page<1){
            page=1;
        }
        List<Question> qlist = as.findAllQuestionByPage(page,this.count);
        List<User> ulist = as.findAllStudentByPage(page, this.count);
        mav.addObject("page",page);
        mav.addObject("ulist",ulist);
        return mav;
    }
    @RequestMapping("waitscore")
    public  ModelAndView waitscore(){
        ModelAndView mav=new ModelAndView("/wait");
        return mav;
    }

}
