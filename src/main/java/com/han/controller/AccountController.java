package com.han.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.han.service.AccountService;
import com.han.vo.Account;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class AccountController {

    @Resource
    private AccountService accountService;

    @GetMapping("account/{id}")
    @ResponseBody
    public Account queryAccount(@PathVariable Integer id){
        Account account = accountService.queryAccountById(id);
        return account;
    }

    @PostMapping("account")
    @ResponseBody
    public Map<String,Object> addAccount( Account account){
        int i = accountService.addAccount(account);
        Map<String, Object> objectObjectMap = new HashMap<>();
        if(i==1){
            objectObjectMap.put("code",200);
            objectObjectMap.put("msg","添加成功!");
        }else {
            objectObjectMap.put("code",500);
            objectObjectMap.put("msg","添加失败");
        }
        return objectObjectMap;
    }

    @PutMapping("account/update")
    @ResponseBody
    public Map<String,Object> updateAccount(@RequestBody Account account){
        int i = accountService.updateAccount(account);
        Map<String, Object> objectObjectMap = new HashMap<>();
        if(i==1){
            objectObjectMap.put("code",200);
            objectObjectMap.put("msg","修改成功!");
        }else {
            objectObjectMap.put("code",500);
            objectObjectMap.put("msg","修改失败");
        }
        return objectObjectMap;
    }


    @DeleteMapping("accountdel/{id}")
    @ResponseBody
    public Map<String,Object> deleteAccount(@PathVariable Integer id){
        int i = accountService.deleteAccount(id);
        Map<String, Object> objectObjectMap = new HashMap<>();
        if(i==1){
            objectObjectMap.put("code",200);
            objectObjectMap.put("msg","删除成功!");
        }else {
            objectObjectMap.put("code",500);
            objectObjectMap.put("msg","删除失败");
        }
        return objectObjectMap;
    }

    @RequestMapping("/findall")
    public String findAll(Integer startPage, Integer pageSize, Model model){

        if(startPage==null||pageSize==null){
            startPage=1;
            pageSize=4;
        }
        PageHelper.startPage(startPage,pageSize);
        List<Account> accountList=  accountService.selectAccountAll();
        PageInfo<Account> pageInfo= new PageInfo<Account>(accountList);
        model.addAttribute("pageinfo",pageInfo);
        return "main";
    }
}
