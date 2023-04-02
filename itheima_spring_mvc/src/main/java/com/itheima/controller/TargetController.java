package com.itheima.controller;

import com.itheima.Exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TargetController {
    @RequestMapping("/target")
    public ModelAndView show(ModelAndView modelAndView){
        System.out.println("目标资源执行");
        modelAndView.addObject("name","wch");
        modelAndView.setViewName("/index.jsp");
        return modelAndView;
    }
    @RequestMapping("/testExceptionResolver")
    public String testExceptionResolver() throws Exception{
        throw new MyException();
    }

}
