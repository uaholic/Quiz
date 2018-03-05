package com.gyq.quiz.controller;

import com.gyq.quiz.domin.Question;
import com.gyq.quiz.domin.Uanswer;
import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.AdminService;
import com.gyq.quiz.service.QuestionService;
import com.gyq.quiz.service.UanswerService;
import com.gyq.quiz.vo.NaQuestion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {
    @Value("${pagecount}")
    int count;
    @Value("${format.len.stu}")
    int formatstulen;
    @Autowired
    AdminService as;
    @Autowired
    QuestionService qs;
    @Autowired
    UanswerService uas;
    @RequestMapping("/answerQuestionList")
    public ModelAndView questionList(Integer page,HttpSession session){
        ModelAndView mav=new ModelAndView("answerquestionlist");
        if(page==null||page<1){
            page=1;
        }
        List<Question> list = as.findAllQuestionByPage(page,this.count);
        User user = (User) session.getAttribute("user");
        List<NaQuestion> templist = uas.findNqByUid(user.getUid());
        Map<Integer,Integer> overMap=new HashMap<>();
        for (NaQuestion nq: templist) {
            overMap.put(nq.getQid(),nq.getScore());
        }
        List<NaQuestion> qlist=new ArrayList<>();
        for (Question q:list) {                     //不要轻易动这段代码
            NaQuestion temp=new NaQuestion();
            if(overMap.containsKey(q.getQid())){
                temp.setQid(q.getQid());
                temp.setQtext(q.getQtext());
                temp.setOver(true);
                temp.setScore(overMap.get(q.getQid()));
            }else{
                temp.setQid(q.getQid());
                temp.setQtext(q.getQtext());
                temp.setOver(false);
                temp.setScore(400);
            }
            qlist.add(temp);
        }                                           //我也不想这么写但是我也很绝望
        for (NaQuestion q:qlist) {
            if(q.getQtext().length()>this.formatstulen){
                q.setQtext(q.getQtext().substring(0,this.formatstulen)+"...");
            }
        }
        mav.addObject("page",page);
        mav.addObject("qlist",qlist);
        return mav;
    }
    @RequestMapping("/answerQuestion")
    public ModelAndView answerQuestion(int qid){
        ModelAndView mav=new ModelAndView("answerquestion");
        Question question = qs.findQuestionByQid(qid);
        mav.addObject("qid",question.getQid());
        mav.addObject("question",question.getQuestion());
        return mav;
    }
    @RequestMapping("/viewMyAnswer")
    public ModelAndView viewMyAnswer(int qid, HttpSession session){
        ModelAndView mav=new ModelAndView("viewmyanswer");
        int uid=((User)session.getAttribute("user")).getUid();
        Uanswer uanswer = uas.findStuAnswer(qid, uid);
        mav.addObject("qid",uanswer.getQid());
        mav.addObject("question",uanswer.getQuestion());
        mav.addObject("uanswer",uanswer.getUanswer());
        return  mav;
    }

    @RequestMapping("/stuViewAnswer")
    public ModelAndView stuViewAnswer(Integer page,HttpSession session){
        ModelAndView mav=new ModelAndView("stuviewanswer");
        if(page==null||page<1){
            page=1;
        }
        List<Question> list = as.findAllQuestionByPage(page,this.count);
        User user = (User) session.getAttribute("user");
        List<NaQuestion> templist = uas.findNqByUid(user.getUid());
        Map<Integer,Integer> overMap=new HashMap<>();
        for (NaQuestion nq: templist) {
            overMap.put(nq.getQid(),nq.getScore());
        }
        List<NaQuestion> qlist=new ArrayList<>();
        for (Question q:list) {                         //不要轻易动这段代码
            NaQuestion temp=new NaQuestion();
            if(overMap.containsKey(q.getQid())){
                temp.setQid(q.getQid());
                temp.setQtext(q.getQtext());
                temp.setOver(true);
                temp.setScore(overMap.get(q.getQid()));
            }else{
                temp.setQid(q.getQid());
                temp.setQtext(q.getQtext());
                temp.setOver(false);
                temp.setScore(400);
            }
            qlist.add(temp);
        }                                               //我也不想这么写但是我也很绝望
        for (NaQuestion q:qlist) {
            if(q.getQtext().length()>this.formatstulen){
                q.setQtext(q.getQtext().substring(0,this.formatstulen)+"...");
            }
        }
        mav.addObject("page",page);
        mav.addObject("qlist",qlist);
        return mav;
    }
    @RequestMapping("/viewThisAnswer")
    public ModelAndView viewThisAnswer(int qid){
        ModelAndView mav=new ModelAndView("viewthisanswer");
        Question question = qs.findQuestionByQid(qid);
        mav.addObject("qid",question.getQid());
        mav.addObject("question",question.getQuestion());
        mav.addObject("answer",question.getAnswer());
        return mav;
    }

    @RequestMapping("/getUser")
    public ModelAndView getUser(Integer page,int uid){
        ModelAndView mav=new ModelAndView("stuanswerquestionlist");
        if(page==null||page<1){
            page=1;
        }
        List<Question> list = as.findAllQuestionByPage(page,this.count);
        List<NaQuestion> templist = uas.findNqByUid(uid);
        Map<Integer,Integer> overMap=new HashMap<>();
        for (NaQuestion nq: templist) {
            overMap.put(nq.getQid(),nq.getScore());
        }
        List<NaQuestion> qlist=new ArrayList<>();
        for (Question q:list) {                     //不要轻易动这段代码
            NaQuestion temp=new NaQuestion();
            if(overMap.containsKey(q.getQid())){
                temp.setQid(q.getQid());
                temp.setQtext(q.getQtext());
                temp.setOver(true);
                temp.setScore(overMap.get(q.getQid()));
            }else{
                temp.setQid(q.getQid());
                temp.setQtext(q.getQtext());
                temp.setOver(false);
                temp.setScore(400);
            }
            qlist.add(temp);
        }                                           //我也不想这么写但是我也很绝望
        for (NaQuestion q:qlist) {
            if(q.getQtext().length()>this.formatstulen){
                q.setQtext(q.getQtext().substring(0,this.formatstulen)+"...");
            }
        }
        mav.addObject("page",page);
        mav.addObject("uid",uid);
        mav.addObject("qlist",qlist);
        return mav;
    }
}
