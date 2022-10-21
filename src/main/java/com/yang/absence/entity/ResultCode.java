package com.yang.absence.entity;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/21 14:04
 */
public enum ResultCode {
    /**
     * 成功
     */
    SUCCESS(200, "成功"),
    ;

    private final int code;
    private final String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultCode(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
