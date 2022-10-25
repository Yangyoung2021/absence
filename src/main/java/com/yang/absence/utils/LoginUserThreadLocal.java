package com.yang.absence.utils;

import com.yang.absence.entity.common.LoginUser;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/23 23:40
 */
public class LoginUserThreadLocal {
    private LoginUserThreadLocal() { }

    private static final ThreadLocal<LoginUser> LOGIN_USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser) {
        LOGIN_USER_THREAD_LOCAL.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return LOGIN_USER_THREAD_LOCAL.get();
    }

    public static void removeLoginUser() {
        LOGIN_USER_THREAD_LOCAL.remove();
    }
}
