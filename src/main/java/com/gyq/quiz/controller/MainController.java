package com.gyq.quiz.controller;

import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.UserService;
import com.gyq.quiz.util.DecodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    UserService us;
    @RequestMapping("/gotochangepassword")
    public ModelAndView mainHandler(HttpSession session){
        ModelAndView mav=new ModelAndView("changepassword");
        return mav;
    }
    @RequestMapping("/changepassword")
    public ModelAndView mainHandler(HttpSession session,String oripassword,String password){
        ModelAndView mav=new ModelAndView("changepassword");
        oripassword=DecodeUtil.getMD5(oripassword);
        password= DecodeUtil.getMD5(password);
        User user=((User)session.getAttribute("user"));
        if(user.getPassword().equals(oripassword)){
            user.setPassword(password);
            boolean ok=us.updateUser(user);
            if(ok){
                mav=new ModelAndView("index");
                mav.addObject("info","密码修改成功，请重新登录");
                session.removeAttribute("user");
            }else{
                mav.addObject("errinfo","修改密码失败");
            }
        }else{
            mav.addObject("errinfo","修改密码失败");
        }
        return mav;
    }
}
