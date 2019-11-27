package com.baihy.distributed.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 17:50
 */
// @EnableWebSecurity // 这个注解包含了@Configuration，所以，不用加@Configuration
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 定义用户的安全拦截机制（就是用户的拦截器---最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // 禁用csrf跨域调用
                .authorizeRequests()
                .antMatchers("/**").authenticated()// 指定所有的请求必须认真通过
                .anyRequest().permitAll();
    }
}
