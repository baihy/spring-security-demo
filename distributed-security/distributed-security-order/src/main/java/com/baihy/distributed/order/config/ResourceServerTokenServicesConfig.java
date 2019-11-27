package com.baihy.distributed.order.config;

import org.springframework.context.annotation.Configuration;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.order.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/27 15:19
 */
@Configuration
public class ResourceServerTokenServicesConfig {

   /* @Bean
    public ResourceServerTokenServices resourceServerTokenServices() {
        //使用远程服务请求授权服务器校验token,必须指定校验token 的url、client_id，client_secret
        RemoteTokenServices service = new RemoteTokenServices();
        service.setCheckTokenEndpointUrl("http://127.0.0.1:9090/uaa/oauth/check_token");
        service.setClientId("c1");
        service.setClientSecret("secret");
        return service;
    }*/


}
