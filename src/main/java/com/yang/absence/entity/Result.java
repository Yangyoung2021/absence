package com.yang.absence.entity;

import lombok.Data;

/**
 * @author xiongyangyang
 * @version 2.1.2.0
 * @date 2022/10/21 14:03
 */
@Data
public class Result {
    private static final long serialVersionUID = -124249374690L;
    private int code;

    private String msg;

    private Object data;

    public Result(){
        this(ResultCode.SUCCESS);
    }

    /**
     * 没有参数需要回显的请求
     *
     * @param resultCode 请求结果
     */
    public Result(ResultCode resultCode){
        this.code = resultCode.getCode();
        this.msg = resultCode.getMsg();
    }

    /**
     * 没有参数需要回显的请求
     *
     * @param msg 返回消息
     */
    public Result(String msg){
        this(ResultCode.SUCCESS.getCode(), msg, null);
    }

    /**
     * 指定状态的返回码和返回数据
     *
     * @param resultCode 返回码信息
     * @param data 返回数据
     */
    public Result(ResultCode resultCode, Object data){
        this(resultCode.getCode(), resultCode.getMsg(), data);
    }

    /**
     * 自定义的返回码和提示信息
     *
     * @param code 返回码
     * @param msg 提示信息
     * @param data 返回数据
     */
    public Result(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 成功且有回显数据的结果
     *
     * @param data 返回数据
     */
    public Result(Object data) {
        this(ResultCode.SUCCESS, data);
    }
}
