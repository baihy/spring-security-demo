package com.baihy.service;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 15:03
 */
@Service
public class SpringCustomUserDetailService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        /**
         * 通过内存代替从数据库中，查询到的用户信息
         */
        // 定义用户信息服务
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        // 配置用户的用户名和密码
        manager.createUser(User.withUsername("zhangsan").password("123").authorities("p1").build());
        manager.createUser(User.withUsername("lisi").password("456").authorities("p2").build());
        // 把UserDetailsService放入spring容器，这里获取的就是用户数据库中的用户名或密码
        return manager.loadUserByUsername(username);
    }
}
