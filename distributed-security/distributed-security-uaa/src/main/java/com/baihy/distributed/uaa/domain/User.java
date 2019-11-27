package com.baihy.distributed.uaa.domain;

import lombok.Data;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.domain
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 17:36
 */
@Data
public class User {


    private Integer id;

    private String username;

    private String password;

    private String fullName;

    private String mobile;
}
