package com.jtech.vigcoin.net;

import com.jtech.vigcoin.model.BaseModel;

/**
 * 网络接口响应消息体数据对象
 */
public class ResponseModel<T extends BaseModel> extends BaseModel {
    //事务状态码
    private int code = 0;
    //事务描述
    private String message = "";
    //名称
    private String name = "";
    //消息主体
    private T data;

    public int getCode() {
        return code;
    }

    public ResponseModel<T> setCode(int code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public ResponseModel<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public String getName() {
        return name;
    }

    public ResponseModel<T> setName(String name) {
        this.name = name;
        return this;
    }

    public T getData() {
        return data;
    }

    public ResponseModel<T> setData(T data) {
        this.data = data;
        return this;
    }
}