package com.baihy.distributed.uaa.dao;

import com.baihy.distributed.uaa.domain.User;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.dao
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 17:38
 */
public interface UserDao {

    User loadUserByUsername(String username);

}
