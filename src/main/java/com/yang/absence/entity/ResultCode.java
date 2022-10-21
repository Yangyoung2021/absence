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
    /**
     * 未认证
     */
    UNAUTHORIZED(403, "未认证"),
    SYS_INTERNAL_ERROR(120000100, "系统错误，请稍后重试"),
    SYS_PARAM_ERROR(120000101, "参数错误"),
    SYS_DATA_ERROR(120000102, "数据错误"),
    SYS_USER_NOT_EXISTS(120000103,"用户不存在"),
    SYS_INVALID_REQUEST(120000104,"非法请求"),
    SYS_BUSY(120000105, "当前系统繁忙，请稍后重试"),
    SYS_PATH_NOT_NULL(120000106,"path路径不能为空"),
    SYS_METHOD_NOT_EXISTS(120000107,"接口未找到该方法"),
    SYS_INTERFACE_NAME_NOT_NULL(120000108,"接口全限定类名不能为空"),
    SYS_DIFF_INACCESSIBLE(120000109,"由于无法访问基础值而无法进行比较"),
    SYS_MAVEN_SETTING(120000110,"maven参数解析错误，请检查maven参数"),
    SYS_JAR_NOT_EXITS(120000111,"当前路径下jar包不存在，请先下载上传maven坐标下载"),
    SYS_METHOD_NAME_NOT_NULL(120000112,"方法名称不能为空"),
    SYS_ENV_NOT_NULL(120000113,"环境不能不能为空"),
    SYS_PARAMETER_TYPE_NOT_NULL(120000114,"入参类型不能为空"),
    SYS_PARAMETERS_NOT_NULL(120000115,"入参不能为空"),
    /**
     * 失败
     */
    ERROR(500, "失败");

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
