package com.baihy.utils;

import com.baihy.domain.User;

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

    public static List<User> USERS = new ArrayList<>();

    /*static {
        List<String> p1 = new ArrayList<>();
        p1.add("p1");  // 拥有p1权限
        List<String> p2 = new ArrayList<>();
        p2.add("p2"); // 拥有p2权限
        List<String> p3 = new ArrayList<>();
        USERS.add(new User("11111111", "zhangsan", "123456", 18, p1));
        USERS.add(new User("22222222", "lisi", "123456", 18, p2));
        USERS.add(new User("33333333", "wangwu", "123456", 18, p3));
    }*/


    public static String SESSION_USER_KEY = "_user";

}
