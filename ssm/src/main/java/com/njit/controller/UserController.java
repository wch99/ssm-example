package com.njit.controller;

import com.njit.domain.User;
import com.njit.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @Autowired
    @Qualifier("userService")
    private UserService userService;


    @RequestMapping("/login")
    public ModelAndView login(ModelAndView modelAndView,String username, String password){
        User user = userService.selectByName(username, password);
        modelAndView.setViewName("/success.jsp");
        modelAndView.addObject("username",username);
        if(user==null){
            modelAndView.setViewName("/error.html");
            return modelAndView;
        }
        return modelAndView;
    }
}
