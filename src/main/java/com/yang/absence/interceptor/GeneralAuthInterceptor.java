package com.yang.absence.interceptor;

import com.yang.absence.entity.LoginUser;
import com.yang.absence.utils.LoginUserThreadLocal;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/23 23:36
 */
@Component
public class GeneralAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginUserThreadLocal.setLoginUser(new LoginUser("1", "1", "1", "1"));
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUserThreadLocal.removeLoginUser();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
