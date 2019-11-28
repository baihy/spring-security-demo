package com.baihy.controller;

import com.baihy.domain.AuthenticationRequest;
import com.baihy.domain.UserData;
import com.baihy.service.AuthenticationService;
import com.baihy.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:55
 */
@Controller
public class LoginController {


    @Autowired
    private AuthenticationService authenticationService;

    @RequestMapping(value = "/login")
    public String login(AuthenticationRequest param, HttpSession session) {
        UserData userData = authenticationService.login(param);
        session.setAttribute(Constants.SESSION_USER_KEY, userData);
        return "redirect:/main";
    }


    @RequestMapping(value = "/main")
    public String main(Model model, HttpSession session) {
        UserData userData = (UserData) session.getAttribute(Constants.SESSION_USER_KEY);
        model.addAttribute("userData", userData);
        return "main";
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session) {
        // 设置session失效
        session.invalidate();
        return "redirect:/loginPage";
    }

}
