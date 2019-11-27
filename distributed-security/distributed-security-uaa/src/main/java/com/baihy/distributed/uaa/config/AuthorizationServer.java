package com.baihy.distributed.uaa.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.code.AuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy.distributed.uaa.config
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/26 16:06
 */
@Configuration
@EnableAuthorizationServer  // 标识该服务是一个授权服务
public class AuthorizationServer extends AuthorizationServerConfigurerAdapter {

    /**
     * 授权服务的配置
     */


    /**
     * 1.配置客户端详情信息
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        //clients客户端的信息
        // clients.withClientDetails(clientDetailsService);  // 基于查询数据库的操作
        clients.inMemory()// 使用in-memory存储，最终会放入数据库中
                .withClient("c1")// client_id 客户端的id
                .secret(new BCryptPasswordEncoder().encode("secret"))  // 客户端的秘钥
                // 上面客户端申请令牌，所携带的id和秘钥
                .resourceIds("res1")   // 客户端可以访问那些资源服务列表，客户端可以访问的资源服务
                .authorizedGrantTypes("authorization_code", "password", "client_credentials", "implicit",
                        "refresh_token")
                // 该client允许的五种授权类型authorization_code,password,refresh_token,implicit,client_credentials
                .scopes("all") // 允许的授权范围，客户端的权限，就是允许客户端可以访问那些微服务
                // .authorities("")  // 此客户端可以使用的权限
                .autoApprove(false) //false 申请令牌时使用授权码模式，则会跳转到授权的页面，如果是true的话，直接发放令牌。
                .redirectUris("http://www.baidu.com");//加上验证回调地址
    }

    /****2.配置令牌访问端点****/
    @Autowired
    private AuthenticationManager authenticationManager;   // 认证管理器,所以，我们需要引入WebSecurityConfig类，配置认证管理器



    @Autowired
    private AuthorizationServerTokenServices authorizationServerTokenServices;  // token管理服务


    @Autowired
    private AuthorizationCodeServices authorizationCodeServices;  // 授权码服务
    /**
     * 管理令牌访问端点
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
        endpoints.authenticationManager(authenticationManager) // 密码模式
                .authorizationCodeServices(authorizationCodeServices)  // 授权码模式
                .tokenServices(authorizationServerTokenServices)   // 令牌管理服务
                .allowedTokenEndpointRequestMethods(HttpMethod.POST);  // 允许post请求的方式访问令牌
    }

    /**
     * 3.令牌访问的安全策略
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) {
        security.tokenKeyAccess("permitAll()")  // 表示/oauth/token_key这个url是公开的，就是不用认证就能访问/oauth/token_key这个url
                .checkTokenAccess("permitAll()") // 表示/oauth/check_token这个url是公开的，就是不用认证就能访问/oauth/check_token这个url
                .allowFormAuthenticationForClients(); // 允许表单认证（就是通过表单申请令牌）
    }
}
