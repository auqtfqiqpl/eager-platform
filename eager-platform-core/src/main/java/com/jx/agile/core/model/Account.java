package com.jx.agile.core.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/25/16:17
 * @Description:
 */
@Data
public class Account implements Serializable {

    private String username;//用户名
    private String password;//密码
    private String salt;//加密盐

    private User user;


}
