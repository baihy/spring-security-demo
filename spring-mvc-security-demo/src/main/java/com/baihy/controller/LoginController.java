package com.baihy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:55
 */
@RestController
public class LoginController {

    @RequestMapping(value = "/login-success", produces = "text/plain;charset=UTF-8")
    public String loginSuccess() {
        return "登录成功！！";
    }

}
