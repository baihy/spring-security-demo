package com.baihy.dao;

import com.baihy.domain.Premission;

import java.util.List;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.dao
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 11:35
 */
public interface PremissionDao {

    List<Premission> findPremissionByRoleIds(List<Integer> roleIds);

}
