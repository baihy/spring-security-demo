package com.baihy.distributed.uaa.dao.impl;

import com.baihy.distributed.uaa.dao.UserDao;
import com.baihy.distributed.uaa.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.dao.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 17:38
 */
@Repository
public class UserDaoImpl implements UserDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User loadUserByUsername(String username) {
        String sql = "select * from t_user where username = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, i) -> {
            User user = new User();
            user.setId(rs.getInt("id"));
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setFullName(rs.getString("full_name"));
            user.setMobile(rs.getString("mobile"));
            return user;
        });
    }
}
