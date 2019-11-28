package com.baihy.dao;

import com.baihy.domain.Role;

import java.util.List;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.dao
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 13:48
 */
public interface RoleDao {

    List<Role> findRoleByUserId(Integer userId);

}
