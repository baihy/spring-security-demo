package com.baihy.service.impl;

import com.baihy.domain.AuthenticationRequest;
import com.baihy.domain.UserDto;
import com.baihy.service.AuthenticationService;
import com.baihy.utils.Constants;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:10
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {
    @Override
    public UserDto login(AuthenticationRequest param) {
        UserDto userDto = this.findUserDtoByUserName(param.getUsername());
        if (userDto == null) {
            throw new RuntimeException("用户名不存在！！！");
        }
        if (!userDto.getPassword().equals(param.getPassword())) {
            throw new RuntimeException("用户名或密码错误！！！");
        }
        return userDto;
    }

    @Override
    public UserDto findUserDtoByUserName(String username) {
        Optional<UserDto> optional =
                Constants.USERS.parallelStream().filter(userDto -> userDto.getUsername().equals(username)).findFirst();
        return optional.isPresent() ? optional.get() : null;
    }


}
