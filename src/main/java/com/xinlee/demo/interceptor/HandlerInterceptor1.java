package com.xinlee.demo.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by xin.lee on 2017/2/20.
 * 自定义拦截器
 */
public class HandlerInterceptor1 implements HandlerInterceptor {

    // 进入Handler方法之前执行
    // 应用场景：身份认证、身份授权（例如身份认证：如果认证通过表示当前用户没有登录，需要此方法拦截不再向下执行）
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("HandlerInterceptor1...preHandle");
        // false：拦截，不向下执行
        // true：放行
        return true;
    }

    // 进入Handler方法之后执行
    // 应用场景：从ModelAndView出发，将公用的模型数据（比如菜单导航）在这里传到视图，也可以在这里统一指定视图
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("HandlerInterceptor1...postHandle");
    }

    // Handler方法执行完之后执行
    // 应用场景：统一异常处理，统一日志处理
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("HandlerInterceptor1...afterCompletion");
    }
}
