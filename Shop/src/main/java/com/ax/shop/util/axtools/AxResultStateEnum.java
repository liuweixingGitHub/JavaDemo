package com.ax.shop.util.axtools;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
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

    BAD_REQUEST(HttpStatus.BAD_REQUEST.value(), "Bad Request"),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error"),
    TOKEN_INVALID(HttpStatus.BAD_REQUEST.value(), "token失效"),
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