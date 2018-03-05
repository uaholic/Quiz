package com.gyq.quiz.controller;

import com.gyq.quiz.domin.Uanswer;
import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.UanswerService;
import com.gyq.quiz.service.UserService;
import com.gyq.quiz.vo.Nabean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UanswerController {
    @Autowired
    UanswerService uas;
    @Autowired
    UserService us;
    @RequestMapping("/viewUanswer")
    public ModelAndView  viewUanswer(int qid,int uid){
        ModelAndView mav=new ModelAndView("viewuanswer");
        Uanswer uanswer = uas.findStuAnswer(qid, uid);
        List<Nabean> nabeans = us.findAllNabean(qid);
        mav.addObject("uid",uid);
        mav.addObject("qid",uanswer.getQid());
        mav.addObject("name",uanswer.getName());
        mav.addObject("question",uanswer.getQuestion());
        mav.addObject("answer",uanswer.getAnswer());
        mav.addObject("uanswer",uanswer.getUanswer());
        mav.addObject("nabeans",nabeans);
        return mav;
    }

    @RequestMapping("/updateScore")
    public ModelAndView updateScore(Uanswer uanswer){
        ModelAndView mav=new ModelAndView("forward:/questionList");
        boolean ok = uas.updateScore(uanswer);
        if(ok){
            mav.addObject("info","打分成功");
        }else{
            mav.addObject("info","打分失败");
        }
        return mav;
    }
    @RequestMapping("/updateUanswer")
    public  ModelAndView updateUanswer(Uanswer uanswer, HttpSession session){
        ModelAndView mav=new ModelAndView("forward:/answerQuestionList");
        int uid=((User)session.getAttribute("user")).getUid();
        uanswer.setUid(uid);
        boolean ok = uas.updateUanswer(uanswer);
        if(ok){
            mav.addObject("info","答题成功");
        }else{
            mav.addObject("info","答题失败");
        }
        return  mav;
    }
}
