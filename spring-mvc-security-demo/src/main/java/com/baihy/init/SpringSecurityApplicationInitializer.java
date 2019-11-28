package com.baihy.init;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.init
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 18:28
 */
public class SpringSecurityApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    /**
     * Servlet容器启动的时候，会调用这个类的onStartup方法
     */

    public SpringSecurityApplicationInitializer() {
        //   如果当前环境是非Spring或springmvc环境时，需要把WebSecurityConfig类通过构造方法传入
        //   super(WebSecurityConfig.class);
    }
}
