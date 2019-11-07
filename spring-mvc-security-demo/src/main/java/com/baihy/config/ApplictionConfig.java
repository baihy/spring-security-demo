package com.baihy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

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

}
