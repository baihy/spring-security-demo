package com.baihy.controller;

import com.baihy.domain.AuthenticationRequest;
import com.baihy.domain.UserDto;
import com.baihy.service.AuthenticationService;
import com.baihy.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:55
 */
@RestController
public class LoginController {


    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login", produces = "text/plain;charset=UTF-8")
    public String login(AuthenticationRequest param, HttpSession session) {
        UserDto userDto = authenticationService.login(param);
        session.setAttribute(Constants.SESSION_USER_KEY, userDto);
        return userDto.getUsername() + "登录成功！！";
    }




    @RequestMapping(value = "logout", produces = "text/plain;charset=UTF-8")
    public String logout(HttpSession session) {
        // 设置session失效
        session.invalidate();
        return "退出登录成功！！！";
    }

}
