package com.baihy.dao;

import com.baihy.domain.User;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 11:05
 */
public interface UserDao {


    User findUserByUserName(String username);

}
