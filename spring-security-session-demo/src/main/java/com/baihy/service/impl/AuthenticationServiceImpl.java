package com.baihy.service.impl;

import com.baihy.dao.PremissionDao;
import com.baihy.dao.RoleDao;
import com.baihy.dao.UserDao;
import com.baihy.domain.*;
import com.baihy.service.AuthenticationService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.service.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:10
 */
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private PremissionDao premissionDao;


    @Override
    public UserData login(AuthenticationRequest param) {
        User user = userDao.findUserByUserName(param.getUsername());
        if (user == null) {
            throw new RuntimeException("用户名不存在！！！");
        }
        if (!user.getPassword().equals(param.getPassword())) {
            throw new RuntimeException("用户名或密码错误！！！");
        }
        /**
         * 处理权限信息
         */
        UserData userData = new UserData();
        BeanUtils.copyProperties(user, userData);
        List<Role> roles = this.roleDao.findRoleByUserId(user.getId());
        List<Premission> premissions =
                this.premissionDao.findPremissionByRoleIds(roles.parallelStream().map(role -> role.getId()).collect(Collectors.toList()));
        userData.setRoles(roles);
        userData.setPremissions(premissions);
        return userData;
    }
}
