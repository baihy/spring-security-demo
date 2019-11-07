package com.baihy.init;

import com.baihy.config.ApplictionConfig;
import com.baihy.config.ServletMvcConfig;
import com.baihy.config.WebSecurityConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.init
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:21
 */
public class ApplicationInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    // 这个文件，就相当于是web.xml文件

    @Override
    protected Class<?>[] getRootConfigClasses() {
        // 加入spring的配置类，即：ApplicationConfig，相当于在web.xml中，读取applicationContxt.xml
        return new Class[]{ApplictionConfig.class, WebSecurityConfig.class};
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        // 加入spring mvc的配置类，即：ServletMvcConfig，相当于在web.xml中，读取servlet-mvc.xml
        return new Class[]{ServletMvcConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        // 这个是：DispatcherServlet拦截的请求地址。一般配置成"/"斜杆
        return new String[]{"/"};
    }
}
