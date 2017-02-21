package com.xinlee.demo.interceptor;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by xin.lee on 2017/2/20.
 * 登录拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("LoginInterceptor...preHandle");
        String url = request.getRequestURI();                                   // 获取请求的URL
        if(StringUtils.containsIgnoreCase(url, "login")) {                      // 如果请求是登录请求，则放行
            return true;
        }
        HttpSession session = request.getSession();                             // 获取Session会话对象
        String username = (String) session.getAttribute("username");            // 获取会话中的username
        if(null != username) {                                                  // 如果用户已登录，则放行
            return true;
        }
        // 如果用户没有登录，则转发到登录页面
        request.getRequestDispatcher("/user/gotoLogin").forward(request, response);
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor...postHandle");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("LoginInterceptor...afterCompletion");
    }
}
