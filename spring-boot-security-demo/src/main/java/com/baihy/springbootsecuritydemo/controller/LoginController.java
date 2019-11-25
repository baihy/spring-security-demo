package com.baihy.springbootsecuritydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
    @ResponseBody
    public String loginSuccess() {
        return "登录成功！！！";
    }

}
