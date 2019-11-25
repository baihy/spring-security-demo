package com.baihy.config;

import com.baihy.Interceptor.SimpleAuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.*;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 15:17
 */
@Configuration
@ComponentScan(basePackages = {"com.baihy"}, includeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
        value = Controller.class)})
@EnableWebMvc
public class ServletMvcConfig implements WebMvcConfigurer {

    // 扫描除了@Controller注解。这个类相当于是spring中，servlet-mvc.xml文件


    @Autowired
    private SimpleAuthenticationInterceptor simpleAuthenticationInterceptor;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配置请求地址不经过定义的controller方法，直接跳转到指定的页面
        registry.addViewController("/").setViewName("login");
    }


    @Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        // 配置视图解析
        registry.jsp("/WEB-INF/jsp/", ".jsp");
    }

    // 配置视图解析器
   /* @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }*/


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注意：这里注入的是对象
        registry.addInterceptor(simpleAuthenticationInterceptor);
    }
}
