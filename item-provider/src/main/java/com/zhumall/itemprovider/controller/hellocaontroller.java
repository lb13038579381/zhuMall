package com.zhumall.itemprovider.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

@Controller
public class hellocaontroller {
    @RequestMapping("/hello")
    public ModelAndView hello(ModelAndView modelAndView) {
        modelAndView.addObject("hello", "hellothymeleaf");
        modelAndView.setViewName("index.html");
        ArrayList<Integer> list = new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        modelAndView.addObject("list", list);
        return modelAndView;
    }
}