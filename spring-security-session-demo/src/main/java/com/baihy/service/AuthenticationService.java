package com.baihy.service;

import com.baihy.domain.AuthenticationRequest;
import com.baihy.domain.UserData;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.service
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:09
 */
public interface AuthenticationService {

    UserData login(AuthenticationRequest param);

}
