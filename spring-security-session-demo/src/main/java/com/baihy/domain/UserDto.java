package com.baihy.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.domain
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:03
 */
@Data
@AllArgsConstructor
@Accessors(chain = true)
public class UserDto {

    private String id;

    private String username;

    private String password;

    private Integer age;
}
