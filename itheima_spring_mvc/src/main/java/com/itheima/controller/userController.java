package com.itheima.controller;

import com.alibaba.fastjson2.JSON;
import com.itheima.pojo.User;
import com.itheima.pojo.VO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
public class userController {
    //请求映射
    @RequestMapping("/quick")
    public String save() {
        System.out.println("controller save running...");
        return "success.jsp";
    }

    @RequestMapping("/quick2")
    public ModelAndView save2() {
        /*
            Model:模型，封装数据
            View：视图，展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        //设置模型数据
        modelAndView.addObject("username", "itcast");
        //设置视图名称
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @RequestMapping("/quick3")
    public ModelAndView save3(ModelAndView modelAndView) {
        //SpringMVC在调用save3方法时会帮你注入形参中的对象
        //设置模型数据
        modelAndView.addObject("username", "wch...");
        //设置视图名称
        modelAndView.setViewName("/success.jsp");
        return modelAndView;
    }

    @RequestMapping("/quick4")
    public String save3(Model model) {
        //SpringMVC在调用save4方法时会帮你注入形参中的对象
        //设置模型数据
        model.addAttribute("username", "wch...");
        return "/success.jsp";
    }

    @RequestMapping("/quick5")
    public String save5(HttpServletRequest request) {
        //request不常用
        //SpringMVC在调用save5方法时会帮你注入形参中的对象
        request.setAttribute("username", "下雨天");
        return "/success.jsp";
    }

    @RequestMapping("/quick6")
    public void save6(HttpServletResponse response) throws IOException {
        //回写数据
        //设置浏览器和输出流编码utf-8
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().println("用SpringMVC注入的response对象回写数据...");
    }

    @RequestMapping("/quick7")
    @ResponseBody
    public String save7() throws IOException {
        //回写数据
        return "hello itheima";
    }
    @RequestMapping("/quick8")
    @ResponseBody
    public String save8() throws IOException {
        //回写数据
        return "{\"username\":\"zhangsan\"}";
    }

    @RequestMapping("/quick9")
    @ResponseBody
    public String save9() throws IOException {
        //回写数据
        User user=new User("wch",22,"nantong");
        String json=JSON.toJSONString(user);
        return json;
    }
    @RequestMapping("/quick10")
    @ResponseBody
    //SpringMVC自动将user转换成JSON格式的字符串
    public User save10() throws IOException {
        //回写数据
        User user=new User("wch",22,"nantong");
        return user;
    }
    @RequestMapping("/quick11")
    @ResponseBody
    public void save11(String username,int age) throws IOException {
        System.out.println("username:"+username);
        System.out.println("age:"+age);
    }
    @RequestMapping("/quick12")
    @ResponseBody
    public void save12(User user) throws IOException {
        System.out.println(user);
    }
    @RequestMapping("/quick14")
    @ResponseBody
    public void save14(VO vo) throws IOException {

        System.out.println(vo);
    }
    @RequestMapping("/quick15")
    @ResponseBody
    public void save15(@RequestBody List<User> userList) throws IOException {
        System.out.println(userList);
    }
    @RequestMapping("/quick16")
    @ResponseBody
    public void save16(@RequestParam(value = "name")String username) throws IOException {
        System.out.println(username);
    }
    @RequestMapping(value = "/quick17/{username}",method = RequestMethod.POST)
    @ResponseBody
    public void save17(@PathVariable(value = "username") String username) throws IOException {
        System.out.println(username);
    }
    @RequestMapping(value = "/quick18")
    @ResponseBody
    public void save18(Date date) throws IOException {
        System.out.println(date);
    }
    @RequestMapping(value = "/quick19")
    @ResponseBody
    public void save19(@RequestHeader(value="User-Agent",required = false) String headerValue) throws IOException {
        System.out.println(headerValue);
    }
    @RequestMapping(value = "/quick20")
    @ResponseBody
    public void save20(String name, MultipartFile upload) throws IOException {
        //获得文件名称
        String originalFilename=upload.getOriginalFilename();
        //保存文件
        upload.transferTo(new File("D:\\code\\Spring\\itheima_spring_mvc\\src\\main\\webapp\\upload\\"+originalFilename));
    }
}
