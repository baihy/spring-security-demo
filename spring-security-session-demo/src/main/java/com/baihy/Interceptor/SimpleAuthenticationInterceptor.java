package com.baihy.Interceptor;

import com.baihy.domain.UserDto;
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

/**
 * @projectName: spring-security-demo
 * @packageName: com.baihy
 * @description:
 * @author: huayang.bai
 * @date: 2019/11/7 16:53
 */
@Component
public class SimpleAuthenticationInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        List<String> anonList = Arrays.asList("/login", "/");
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
        UserDto userDto = (UserDto) obj;
        if ("/hello1".equals(request.getRequestURI()) && userDto.getPermissions().contains("p1")) {
            return true;
        }
        if ("/hello2".equals(request.getRequestURI()) && userDto.getPermissions().contains("p2")) {
            return true;
        }
        this.writerContent(response, userDto.getUsername() + "权限不足，拒绝访问！！！");
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
