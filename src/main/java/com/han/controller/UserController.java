package com.han.controller;

import com.han.service.UserService;
import com.han.vo.User;
import com.han.vo.Users;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class UserController extends BaseController {

    @Resource
    private UserService userService;

    @RequestMapping("/hello")
    public String hello(Integer userId, Model model){
        User user = userService.queryUser(userId);
        int i =1/0;
        model.addAttribute("user",user);
        return "hello";
    }

    @RequestMapping("/home")
    public String home(Integer id, Model model, HttpServletRequest request){
        User user = userService.queryUser(id);
        model.addAttribute("user",user);
        request.setAttribute("flag",true);
        request.setAttribute("createDate",new Date());
        request.setAttribute("age",18);
        request.setAttribute("salary",10000);
        request.setAttribute("avg",0.545);
        request.setAttribute("msg","Hello ");
        request.setAttribute("msg2","freemarker");
        String[] stars = new String[]{"周杰伦","林俊杰","陈奕迅","五月天"};
        request.setAttribute("stars",stars);
// List操作
        List<String> citys = Arrays.asList("上海","北京","杭州","深圳");
        request.setAttribute("cityList",citys);
// JavaBean集合
        List<Users> usersList = new ArrayList<>();
        usersList.add(new Users(1,"zhangsan",22));
        usersList.add(new Users(2,"lisi",18));
        usersList.add(new Users(3,"wangwu",20));
        for (Users us:usersList){
            System.out.println(us);
        }
        request.setAttribute("userList",usersList);
        // Map操作
        Map<String,String> cityMap = new HashMap<>();
        cityMap.put("sh","上海");
        cityMap.put("bj","北京");
        cityMap.put("sz","深圳");
        request.setAttribute("cityMap",cityMap);
        return "home";
    }

}
