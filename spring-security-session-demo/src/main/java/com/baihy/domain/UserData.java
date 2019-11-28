package com.baihy.domain;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.domain
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 14:11
 */
@Data
public class UserData {

    private Integer id;

    private String username;

    private String fullName;

    private String mobile;

    private List<Role> roles = new ArrayList<>();

    private List<Premission> premissions = new ArrayList<>();
}
