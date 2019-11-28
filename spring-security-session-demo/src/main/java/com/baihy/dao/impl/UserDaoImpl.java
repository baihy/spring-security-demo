package com.baihy.dao.impl;

import com.baihy.dao.UserDao;
import com.baihy.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.dao.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 11:05
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public User findUserByUserName(String username) {
        String sql = "select * from t_user where username=?";
        return this.jdbcTemplate.queryForObject(sql, new Object[]{username}, (rs, i) ->
                new User(rs.getInt("id"), rs.getString("username"), rs.getString("password"), rs.getString(
                        "full_name"), rs.getString("mobile"))
        );
    }
}
