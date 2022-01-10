package com.jx.agile.core.web;


import lombok.Data;

@Data
public class Result<T> {

    /**
     * 状态码
     */
    public int status;

    /**
     * 展示信息
     */
    public String message;
    /**
     * 数据集
     */
    public T data;

    /**
     * 异常信息
     */
    public String exception;

    /**
     * 业务信息
     */
    public Object bizInfo;

    public Result addBizInfo(Object bizInfo) {
        this.bizInfo =bizInfo;
        return this;
    }

    public Result(Integer status, String message){
        this.status = status;
        this.message = message;
    }

    public Result(Integer status,String message,String exception){
        this.status = status;
        this.message = message;
        this.exception = exception;
    }

    public Result() {
    }

    public boolean  isFail(){
        if(200 != status ){
            return true;
        }
        return false;
    }


    public boolean  isSuccess(){
        if(200 == status ){
            return true;
        }
        return false;
    }
}
