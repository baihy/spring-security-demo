package com.baihy.config;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import javax.sql.DataSource;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:17
 */
@Configuration
@ComponentScan(basePackages = {"com.baihy"}, excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = Controller.class)})
public class ApplictionConfig {

    // 扫描除了@Controller之外的注解。这个类相当于是spring中，applicationContext.xml文件

    @Bean
    public DataSource dataSource() {
        MysqlDataSource dataSource = new MysqlDataSource();
        dataSource.setURL("jdbc:mysql://127.0.0.1:3308/user_db");
        dataSource.setUser("root");
        dataSource.setPassword("root");
        return dataSource;
    }


    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}
