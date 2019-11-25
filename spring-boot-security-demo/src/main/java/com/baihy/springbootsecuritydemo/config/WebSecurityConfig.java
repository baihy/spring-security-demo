package com.baihy.springbootsecuritydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {


    // 把UserDetailsService放入spring容器，这里获取的就是用户数据库中的用户名或密码
    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {

        // 查询用户信息

        // 定义用户信息服务
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // 配置用户的用户名和密码
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        return manager;
    }*/

    // 定义密码的编码器（用来指定采用什么样的方式比对密码）
    @Bean
    public PasswordEncoder passwordEncoder() {
        //return NoOpPasswordEncoder.getInstance();
        // 使用BCrypt算法，对密码进行加密
        return new BCryptPasswordEncoder();
    }

    // 定义用户的安全拦截机制（就是用户的拦截器---最重要）
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 指定所有的请求必须认真通过
        http.authorizeRequests()
                .antMatchers("/index/hello1").hasAuthority("p1")
                .antMatchers("/index/hello2").hasAuthority("p2")
                .mvcMatchers("/index/**")  // 匹配请求
                .authenticated() // 匹配到的请求必须要认证通过
                .anyRequest() //除了匹配到请求，
                .permitAll() // 全部放行
                .and()
                .formLogin()// 允许表单登录
                .loginPage("/login-view")  // 指定登录页面跳转的请求
                .loginProcessingUrl("/login")  // 指定处理请求登录提交的请求
                .successForwardUrl("/login-success") // 表单登录成功之后，跳转到那个页面
                .permitAll();
        http.csrf().disable();// 禁用跨域调用
    }
}
