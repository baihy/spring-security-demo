package com.baihy.springbootsecuritydemo.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.springbootsecuritydemo
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/25 14:05
 */
@Service
public class SpringCustomUserDetailService implements UserDetailsService {

    /***
     * 自定义UserDetailsService服务，获取数据库中的用户信息
     */

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         *  模拟从数据库中，查询数据
         */
        System.out.println("登录输入的用户名: " + username);
        // 注意：可以在这里动态的配置加密方式：格式是：{加密算法}加密后的密码
        String dbPassword = "{bcrypt}" + BCrypt.hashpw("123", BCrypt.gensalt());
        UserDetails userDetails = User.withUsername("zhangsan").password(dbPassword).authorities("p1").build();
        return userDetails;
    }
}
