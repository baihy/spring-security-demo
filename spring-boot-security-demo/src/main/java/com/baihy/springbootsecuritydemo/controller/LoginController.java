package com.baihy.springbootsecuritydemo.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:55
 */
@Controller
public class LoginController {

    @RequestMapping(value = "/login-success")
    public String loginSuccess() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();// 获取用户的身份；
        String username = "游客";
        if (principal != null && principal instanceof User) {
            User user = (User) principal;
            username = user.getUsername();
        }
        System.out.println(username + "登录成功！！！");
        return "redirect:/main.html";
    }

}
