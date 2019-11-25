package com.baihy.springbootsecuritydemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:46
 */
@RestController
@RequestMapping("/home")
public class HomeController {

    @RequestMapping(value = "/hello1", produces = "text/plain;charset=UTF-8")
    @PreAuthorize("hasAuthority('p1')") // 拥有p1权限
    public String sayHello() {
        String result = "home/hello1访问";
        return result;
    }

    @RequestMapping(value = "/hello2", produces = "text/plain;charset=UTF-8")
    @PreAuthorize("isAnonymous() or hasAuthority('p1')") // 匿名访问
    public String sayHello1() {
        String result = "home/hello2访问";
        return result;
    }

}
