package com.njit.controller;
import com.alibaba.fastjson.JSON;
import com.njit.domain.Account;
import com.njit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.List;
@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    //保存,前端传一个json对象,要靠springMVC和@RequsetBody直接接的话，需要导入jackson包
    @RequestMapping("/saveOneAccount")
    @ResponseBody
    public String saveOne(@RequestBody Account account){
        accountService.saveOne(account);
        return "success";
    }
    //查询
    @RequestMapping("/selectAllAccount")
    @ResponseBody
    public String findAll(){
        List<Account> accounts = accountService.selectAll();
        String jsonString = JSON.toJSONString(accounts);
        return jsonString;
    }
    @RequestMapping("/deleteOneAccount")
    @ResponseBody
    public String deleteOne(int id){
        accountService.deleteOne(id);
        return "success";
    }
}
