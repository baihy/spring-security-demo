package com.baihy.controller;

import com.baihy.domain.UserDto;
import com.baihy.utils.Constants;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:46
 */
@RestController
public class IndexController {

    @RequestMapping(value = "/hello1", produces = "text/plain;charset=UTF-8")
    public String sayHello(HttpSession session) {
        String result = null;
        Object obj = session.getAttribute(Constants.SESSION_USER_KEY);
        if (obj == null) {
            result = "匿名访问";
        } else {
            result = ((UserDto) obj).getUsername() + "访问";
        }
        return result;
    }

    @RequestMapping(value = "/hello2", produces = "text/plain;charset=UTF-8")
    public String sayHello1(HttpSession session) {
        String result = null;
        Object obj = session.getAttribute(Constants.SESSION_USER_KEY);
        if (obj == null) {
            result = "匿名访问";
        } else {
            result = ((UserDto) obj).getUsername() + "访问";
        }
        return result;
    }
}
