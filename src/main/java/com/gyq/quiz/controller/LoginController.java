package com.gyq.quiz.controller;

import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.LoginService;
import com.gyq.quiz.util.DecodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;


@Controller
@SessionAttributes({"user"})
public class LoginController {
    @Autowired
    LoginService ls;
    @RequestMapping("/login")
    public ModelAndView loginHandler(User user){
        user.setPassword(DecodeUtil.getMD5(user.getPassword()));
        User realUser=ls.getRealUser(user);
        ModelAndView mav;
        if(realUser!=null&&user.getPassword().equals(realUser.getPassword())){
            mav=new ModelAndView("main");
            mav.addObject("uid",realUser.getUid());
            mav.addObject("author",realUser.getAuthor());
            mav.addObject("name",realUser.getName());
            mav.addObject("user",realUser);
        }else{
            mav=new ModelAndView("forward:/");
            mav.addObject("info","用户名或密码错误");
        }
        return mav;
    }
    @RequestMapping("/gotoreg")
    public ModelAndView loginHandler(){
        ModelAndView mav=new ModelAndView("regedit");
        return mav;
    }
    @RequestMapping("/gohome")
    public ModelAndView gohome(HttpSession session){
        ModelAndView mav=new ModelAndView("main");
        mav.addObject("name",((User)(session.getAttribute("user"))).getName());
        mav.addObject("author",((User)(session.getAttribute("user"))).getAuthor());
        return mav;
    }
}
