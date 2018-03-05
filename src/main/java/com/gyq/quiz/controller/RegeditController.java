package com.gyq.quiz.controller;

import com.gyq.quiz.domin.User;
import com.gyq.quiz.service.UserService;
import com.gyq.quiz.util.DecodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class RegeditController {
    @Autowired
    UserService us;
    @RequestMapping("/regedit")
    public ModelAndView regeditHandler(User user,String conpassword){
        user.setPassword(DecodeUtil.getMD5(user.getPassword()));
        conpassword=DecodeUtil.getMD5(conpassword);
        ModelAndView mav=new ModelAndView("regedit");
        if(!user.getPassword().equals(conpassword)){
            mav.addObject("errinfo","两次输入的密码不一致请确认");
        }else{
            boolean ok=us.regeditOK(user);
            if(ok){
                mav=new ModelAndView("index");
                mav.addObject("info","注册成功，请登录");
            }else{
                mav.addObject("errinfo","注册失败");
            }
        }
        return mav;
    }
}
