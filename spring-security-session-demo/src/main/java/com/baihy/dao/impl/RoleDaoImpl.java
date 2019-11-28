package com.baihy.dao.impl;

import com.baihy.dao.RoleDao;
import com.baihy.domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.dao.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 13:48
 */
@Repository
public class RoleDaoImpl implements RoleDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Role> findRoleByUserId(Integer userId) {
        String sql = "select tr.* from t_role tr left join t_user_role tur on tr.id = tur.role_id  where tur.user_id " +
                "= ?";
        return this.jdbcTemplate.query(sql, new Object[]{userId}, (rs, i) -> new Role(rs.getInt("id"), rs.getString(
                "role_name"), rs.getString("description"), rs.getString("status")));
    }
}
