package com.itheima.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


//相当于组件扫描器，告诉spring去哪个包里面扫描创建bean对象
@ComponentScan("com.itheima")
//加载模块配置文件
@Import(DataSourceConfiguration.class)
//标志该类是Spring核心配置类
@Configuration
public class SpringConfiguration {

}
