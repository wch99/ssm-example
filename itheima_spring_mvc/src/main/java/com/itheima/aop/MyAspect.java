package com.itheima.aop;

import org.springframework.stereotype.Component;

@Component("myAspect")
public class MyAspect {
    public void before(){
        System.out.println("前置增强。。");
    }
}
