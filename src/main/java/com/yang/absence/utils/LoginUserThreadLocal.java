package com.yang.absence.utils;

import com.yang.absence.entity.common.LoginUser;

/**
 * @author xiongyangyang
 * @version 0.0.1
 * @date 2022/10/23 23:40
 */
public class LoginUserThreadLocal {
    private LoginUserThreadLocal() { }

    private static final ThreadLocal<LoginUser> loginUserThreadLocal = new ThreadLocal<>();

    public static void setLoginUser(LoginUser loginUser) {
        loginUserThreadLocal.set(loginUser);
    }

    public static LoginUser getLoginUser() {
        return loginUserThreadLocal.get();
    }

    public static void removeLoginUser() {
        loginUserThreadLocal.remove();
    }
}
