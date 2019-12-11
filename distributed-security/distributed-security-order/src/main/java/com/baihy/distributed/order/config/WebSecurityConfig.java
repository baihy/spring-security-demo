package com.baihy.distributed.order.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.order.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/12/11 19:08
 */
@EnableOAuth2Sso
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 定义用户的安全拦截机制（就是用户的拦截器---最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // 禁用csrf跨域调用
                .authorizeRequests() // 指定所有的请求必须认真通过
                .anyRequest()
                .permitAll(); // 允许表单登录
    }

}
