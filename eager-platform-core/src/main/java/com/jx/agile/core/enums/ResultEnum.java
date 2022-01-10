package com.jx.agile.core.enums;

public enum ResultEnum {

    SUCCESS(200,"操作成功"),
    FAIL(500,"系统错误，联系管理员");

    private int status;
    private String message;

    ResultEnum(Integer status, String message) {
        this.status = status;
        this.message = message;
    }

    public int getStatus() {
        return this.status;
    }

    public String getMessage() {
        return this.message;
    }
}
