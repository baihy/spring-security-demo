package com.baihy.dao.impl;

import com.baihy.dao.PremissionDao;
import com.baihy.domain.Premission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.dao.impl
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/28 11:35
 */
@Repository
public class PremissionDaoImpl implements PremissionDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<Premission> findPremissionByRoleIds(List<Integer> roleIds) {
        String sql = "select tp.* from t_premission tp left join t_role_permission trp on tp.id = trp.permission_id  " +
                "where trp.role_id in (:roleIds)";
        Map<String, Object> params = new HashMap<>();
        params.put("roleIds", roleIds);
        return new NamedParameterJdbcTemplate(this.jdbcTemplate).query(sql, params,
                ((rs, i) -> new Premission(rs.getInt("id")
                        , rs.getString("code"), rs.getString("description"), rs.getString("url"))));
    }
}
