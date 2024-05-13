package com.example.venuebookingserver.Interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /***
     * 在请求处理之前进行调用(Controller方法调用之前)
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //根据session中是否存在用户信息进行 拦截
//        if (request.getSession().getAttribute("accountInfo") == null) {
//            log.debug("未登录请求:" + request.getRequestURI());
//            //未登录  则进行重定向
//            response.sendRedirect(request.getContextPath() + "/login");
//            return false;
//        }
        log.debug("放行请求:" + request.getRequestURI());
        return true;
    }

}
