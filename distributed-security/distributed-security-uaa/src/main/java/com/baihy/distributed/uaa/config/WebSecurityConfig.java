package com.baihy.distributed.uaa.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 17:50
 */
//@EnableWebSecurity // 这个注解包含了@Configuration，所以，不用加@Configuration
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    // 配置认证管理
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * 配置认证管理器
     */


    // 定义密码的编码器（用来指定采用什么样的方式比对密码）
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用BCrypt算法，对密码进行加密
        return new BCryptPasswordEncoder();
    }

    // 定义用户的安全拦截机制（就是用户的拦截器---最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable() // 禁用csrf跨域调用
                .authorizeRequests() // 指定所有的请求必须认真通过
                .antMatchers("/index/hello1").hasAuthority("p1")
                .antMatchers("/login*").permitAll() // 全部放行
                .and()
                .formLogin(); // 允许表单登录
    }
}
