package com.itheima.listener;

import com.itheima.config.SpringConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextLoaderListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        ApplicationContext app=new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //获取ServletContext对象
        ServletContext servletContext = servletContextEvent.getServletContext();
        //将Spring的应用上下文对象存储到ServletContext域中，这是web应用最大的域
        servletContext.setAttribute("app",app);
    }
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
