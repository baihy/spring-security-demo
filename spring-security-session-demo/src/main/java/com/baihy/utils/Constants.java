package com.baihy.utils;

import com.baihy.domain.UserDto;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.utils
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:12
 */
public class Constants {

    public static List<UserDto> USERS = new ArrayList<>();

    static {
        USERS.add(new UserDto("11111111", "zhangsan", "123456", 18));
        USERS.add(new UserDto("22222222", "lisi", "123456", 18));
        USERS.add(new UserDto("33333333", "wangwu", "123456", 18));
    }


    public static String SESSION_USER_KEY = "_user";

}
