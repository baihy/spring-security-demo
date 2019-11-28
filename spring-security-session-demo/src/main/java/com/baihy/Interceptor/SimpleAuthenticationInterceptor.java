package com.baihy.Interceptor;

import com.baihy.domain.UserData;
import com.baihy.utils.Constants;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:53
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    /**
     * spring mvc自身的拦截器
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        /**
         * 返回值为true，表示的放过请求，返回false表示的是拦截请求
         */
        List<String> anonList = Arrays.asList("/login", "/", "/loginPage");
        // 放过匿名登录
        if (anonList.contains(request.getRequestURI())) {
            return true;
        }
        // 验证是否登录
        HttpSession session = request.getSession();
        Object obj = session.getAttribute(Constants.SESSION_USER_KEY);
        if (obj == null) {
            this.writerContent(response, "用户未登录，请登录后操作！！！");
            return false;
        }
        // 验证是否有权限
        UserData userData = (UserData) obj;
        List<String> urlList =
                userData.getPremissions().parallelStream().map(premission -> premission.getUrl()).collect(Collectors.toList());
        if (urlList.contains(request.getRequestURI())) {
            return true;
        }
        this.writerContent(response, userData.getUsername() + "权限不足，拒绝访问！！！");
        return false;
    }

    /**
     * 向前端页面响应信息
     *
     * @param response
     * @param msg
     * @throws IOException
     */
    private void writerContent(HttpServletResponse response, String msg) throws IOException {
        response.setContentType("text/plain;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.print(msg);
        writer.flush();
        writer.close();
    }
}
