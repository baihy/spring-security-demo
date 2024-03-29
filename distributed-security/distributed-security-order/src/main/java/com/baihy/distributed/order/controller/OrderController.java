package com.baihy.distributed.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.order.controller
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 14:09
 */
@RestController
public class OrderController {

    @GetMapping("/r1")
    @PreAuthorize("hasAuthority('r1')")
    public String getResource1() {
        return "获取订单资源1";
    }

    @GetMapping("/r2")
    public String getResource2() {
        return "获取订单资源2";
    }

    @GetMapping("/r3")
    public String getResource3() {
        return "获取订单资源3";
    }

    @GetMapping("/info")
    @ResponseBody
    public Principal info(Principal principal) {
        return principal;
    }
    @GetMapping("/me")
    @ResponseBody
    public Authentication me(Authentication authentication) {
        return authentication;
    }
}
