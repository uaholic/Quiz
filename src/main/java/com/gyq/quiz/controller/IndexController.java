package com.gyq.quiz.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping("/")
    public String index(ModelMap map){
        map.addAttribute("host","这是一个漂亮的首页");
        return "index";
    }
}
