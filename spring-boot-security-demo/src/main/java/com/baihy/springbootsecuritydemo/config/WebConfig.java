package com.baihy.springbootsecuritydemo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.springbootsecuritydemo.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/25 10:28
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // login页面是什么页面？
        registry.addViewController("/").setViewName("redirect:/login");
    }
}
