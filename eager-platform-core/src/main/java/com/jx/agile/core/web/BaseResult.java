package com.jx.agile.core.web;/**
 * @Auther: ly-jiangxh
 * @Date: 2021/08/09/19:18
 * @Description:
 */

import lombok.Data;

/**
 * 基础结果对像
 * @author ly-jiangxh
 * @date 2021/08/09 19:18
 **/
@Data
public class BaseResult {

    /** 结果编码. */
    private int code;

    /** 提示信息. */
    private String msg;

    public BaseResult(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public BaseResult(String msg) {
        this.msg = msg;
    }
}
