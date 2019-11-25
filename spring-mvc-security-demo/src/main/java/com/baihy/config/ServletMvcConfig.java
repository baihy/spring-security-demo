package com.baihy.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

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

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        // 配合重定向到默认的登陆页面
        registry.addViewController("/").setViewName("redirect:/login");
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

}
