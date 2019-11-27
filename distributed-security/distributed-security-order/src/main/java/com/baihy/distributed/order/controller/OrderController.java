package com.baihy.distributed.order.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    @PreAuthorize("hasAuthority('p1')") // 标记用于p1权限，才能访问
    public String getResource1() {
        return "获取订单资源1";
    }

    @GetMapping("/r2")
    @PreAuthorize("hasAuthority('p2')") // 标记用于p2权限，才能访问
    public String getResource2() {
        return "获取订单资源2";
    }

    @GetMapping("/r3")
    @PreAuthorize("hasAuthority('p3')") // 标记用于p2权限，才能访问
    public String getResource3() {
        return "获取订单资源3";
    }
}
