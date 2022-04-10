package com.ahong.enums;

public enum ResponseEnum {
    //每一个枚举相当于一个实例
    SUCCESS(0,"执行成功"),
    FAIL(1,"执行失败");

    private Integer code;

    private String message;

    ResponseEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
