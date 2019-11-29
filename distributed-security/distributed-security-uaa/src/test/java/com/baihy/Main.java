package com.baihy;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/29 14:25
 */
public class Main {

    public static void main(String[] args){

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String secret = bCryptPasswordEncoder.encode("secret");
        System.out.println(secret);
    }

}
