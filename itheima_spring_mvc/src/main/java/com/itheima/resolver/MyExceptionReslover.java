package com.itheima.resolver;

import com.itheima.Exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionReslover implements HandlerExceptionResolver {
    /*
        参数Exception：异常对象
        返回值ModelAndView：跳转到错误视图信息
    */
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {
        ModelAndView modelAndView=new ModelAndView();

        if(e instanceof MyException){
            //执行相应逻辑操作，指定视图等。。
          modelAndView.addObject("info","自定义异常.") ;
        }
        else if(e instanceof ClassCastException){
            //执行相应逻辑操作，指定视图等。。
            modelAndView.addObject("info","类转换异常");
        }
        modelAndView.setViewName("error.jsp");
        return modelAndView;
    }
}
