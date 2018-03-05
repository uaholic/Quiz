package com.gyq.quiz.controller;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.QuestionService;
import com.gyq.quiz.service.UserService;
import com.gyq.quiz.vo.Nabean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class QuestionController {
    @Autowired
    QuestionService qs;
    @Autowired
    UserService us;
    @RequestMapping("/addQuestion")
    public ModelAndView addQuestion(Integer uid){
        ModelAndView mav=new ModelAndView("addquestion");
        int nqid=qs.getQuestionCount()+1;
        mav.addObject("nqid",nqid);
        return mav;
    }
    @RequestMapping("/addquestionsubmit")
    public  ModelAndView addquestionsubmit(Question question){
        ModelAndView mav=new ModelAndView("forward:/questionList");
        boolean b = qs.addQuestion(question);
        if(b){
            mav.addObject("info","添加题目成功");
        }else{
            mav.addObject("info","添加题目失败");
        }
        return mav;
    }
    @RequestMapping("/getQuestion")
    public ModelAndView getQuestion(Integer qid){
        ModelAndView mav=new ModelAndView("showquestion");
        Question question = qs.findQuestionByQid(qid);
        List<Nabean> nabeans = us.findAllNabean(qid);
        mav.addObject("qid",question.getQid());
        mav.addObject("question",question.getQuestion());
        mav.addObject("answer",question.getAnswer());
        mav.addObject("nabeans",nabeans);
        return mav;
    }
    @RequestMapping("/editQuestion")
    public ModelAndView editQuestion(Integer qid){
        ModelAndView mav=new ModelAndView("editquestion");
        Question question = qs.findQuestionByQid(qid);
        mav.addObject("qid",question.getQid());
        mav.addObject("question",question.getQuestion());
        mav.addObject("answer",question.getAnswer());
        return mav;
    }

    @RequestMapping("/editQuestionSubmit")
    public ModelAndView editQuestionSubmit(Question question){
        ModelAndView mav =new ModelAndView("forward:/questionList");
        boolean ok = qs.updateQuestion(question);
        if(ok){
            mav.addObject("info","修改题目成功");
        }else{
            mav.addObject("info","修改题目失败");
        }
        return mav;
    }
}
