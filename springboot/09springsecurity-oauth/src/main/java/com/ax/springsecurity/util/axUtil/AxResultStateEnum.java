package com.ax.springsecurity.util.axUtil;

import org.springframework.http.HttpStatus;


public enum AxResultStateEnum {

    SUCCESS(HttpStatus.OK.value(), "OK"),

    /**
     * 请求失败
     **/
    FAILURE(HttpStatus.BAD_REQUEST.value(), "请求失败"),
    /**
     * 请求无效
     **/
    INVALID(HttpStatus.BAD_REQUEST.value(), "请求无效"),
    INVALID_METHOD_NOT_FOUND(HttpStatus.NOT_FOUND.value(), "请求path找不到"),
    INVALID_PARAMETER_FORMAT(HttpStatus.INTERNAL_SERVER_ERROR.value(), "请求参数格式错误"),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "Bad Request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"),
    TOKEN_INVALID(HttpStatus.BAD_REQUEST.value(), "token失效"),
    INVALID_LOGIN_PASSWORD_WRONG(HttpStatus.BAD_REQUEST.value(), "验证失败"),
    INVALID_ANONYMOUS_NOT_SECURITY(HttpStatus.BAD_REQUEST.value(), "用来解决匿名用户访问无权限资源时的异常"),
    INVALID_USER_NOT_SECURITY(HttpStatus.BAD_REQUEST.value(), "用来解决认证过的用户访问无权限资源时的异常"),
    INVALID_ACCESS_DENIED(HttpStatus.BAD_REQUEST.value(), "无权限,不允许访问"),


    ;

    /**
     * 业务异常码
     */
    private Integer value;
    /**
     * 业务异常信息描述
     */
    private String reasonPhrase;

    AxResultStateEnum(Integer value, String reasonPhrase) {
        this.value = value;
        this.reasonPhrase = reasonPhrase;
    }

    public Integer value(){
        return value;
    }

    public String reasonPhrase(){
        return reasonPhrase;
    }
}