package com.jx.agile.core.utils;

import com.jx.agile.core.constant.ResultStatusConstant;
import com.jx.agile.core.enums.ResultEnum;
import com.jx.agile.core.web.Result;

public class ResultUtils<T> {

    public  static Result fail(String message){
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(ResultStatusConstant.FAIL);
        return result;
    }

    public  static Result fail(String message,Integer status){
        Result result = new Result();
        result.setMessage(message);
        result.setStatus(status);
        return result;
    }

    public  static<T> Result<T> fail(String message,T data){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setStatus(500);
        result.setData(data);
        return result;
    }

    public  static Result fail(String message,String exception){
        Result result = new Result();
        result.setMessage(message);
        result.setException(exception);
        result.setStatus(500);
        return result;
    }

    public  static<T> Result<T> fail(T data,String message,String exception){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setException(exception);
        result.setStatus(ResultStatusConstant.FAIL);
        result.setData(data);
        return result;
    }

    public  static Result fail(String message,String exception,Object bizInfo){
        Result result = new Result();
        result.setMessage(message);
        result.setException(exception);
        result.setStatus(ResultStatusConstant.FAIL);
        result.setBizInfo(bizInfo);
        return result;
    }

    public  static<T> Result<T> fail(T data,String message,String exception,Object bizInfo){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setException(exception);
        result.setStatus(ResultStatusConstant.FAIL);
        result.setBizInfo(bizInfo);
        result.setData(data);
        return result;
    }

    public  static Result fail(ResultEnum failEnum,String exception,Object bizInfo){
        Result result = new Result();
        result.setMessage(failEnum.getMessage());
        result.setException(exception);
        result.setStatus(failEnum.getStatus());
        result.setBizInfo(bizInfo);
        return result;
    }

    public  static<T> Result<T> fail(ResultEnum failEnum,T data,String exception,Object bizInfo){
        Result<T> result = new Result<T>();
        result.setMessage(failEnum.getMessage());
        result.setException(exception);
        result.setStatus(failEnum.getStatus());
        result.setBizInfo(bizInfo);
        result.setData(data);

        return result;
    }

    public static<T> Result<T> success(String message, T data){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        result.setData(data);
        return result;
    }

    public static<T> Result<T> success(String message){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        return result;
    }

    public static<T> Result<T> success(T data){
        Result<T> result = new Result<T>();
        result.setData(data);
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        return result;
    }


    public static<T> Result<T> success(String message, T data,Object bizInfo){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        result.setData(data);
        result.setBizInfo(bizInfo);
        return result;
    }

    public static<T> Result<T> success(int state,String message, T data,Object bizInfo){
        Result<T> result = new Result<T>();
        result.setMessage(message);
        result.setStatus(state);
        result.setData(data);
        result.setBizInfo(bizInfo);
        return result;
    }

    public static<T> Result<T> success(ResultEnum resultEnum, T data,Object bizInfo){
        Result<T> result = new Result<T>();
        result.setMessage(resultEnum.getMessage());
        result.setStatus(resultEnum.getStatus());
        result.setData(data);
        result.setBizInfo(bizInfo);
        return result;
    }

    public static Result success(){
        Result result = new Result();
        result.setMessage(ResultEnum.SUCCESS.getMessage());
        result.setStatus(ResultEnum.SUCCESS.getStatus());
        return result;
    }


}
