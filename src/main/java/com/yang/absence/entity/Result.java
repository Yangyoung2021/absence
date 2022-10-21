package com.yang.absence.entity;

import lombok.Data;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/21 14:03
 */
@Data
public class Result {

    private int code;

    private String msg;

    public Result(){}

    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    public Result(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


}
