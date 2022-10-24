package com.yang.absence.interceptor;

import com.yang.absence.entity.common.LoginUser;
import com.yang.absence.utils.LoginUserThreadLocal;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/23 23:36
 */
@Slf4j
@Component
public class GeneralAuthInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginUser loginUser = new LoginUser("1", "1", "1", "1");
        log.info("获取登录用户信息：{}，线程id：{}", loginUser, Thread.currentThread().getId());
        LoginUserThreadLocal.setLoginUser(loginUser);
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginUser loginUser = LoginUserThreadLocal.getLoginUser();
        log.info("移除登录用户信息：{}，线程id：{}", loginUser, Thread.currentThread().getId());
        LoginUserThreadLocal.removeLoginUser();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }
}
