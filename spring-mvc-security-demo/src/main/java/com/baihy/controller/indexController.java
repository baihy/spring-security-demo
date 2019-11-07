package com.baihy.controller;

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
@RequestMapping("/index")
public class indexController {

    @RequestMapping(value = "/hello1", produces = "text/plain;charset=UTF-8")
    public String sayHello() {
        String result = "hello1访问";
        return result;
    }

    @RequestMapping(value = "/hello2", produces = "text/plain;charset=UTF-8")
    public String sayHello1() {
        String result = "hello2访问";
        return result;
    }
}
