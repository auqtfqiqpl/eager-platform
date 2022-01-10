package com.jx.agile.core.auth;

import org.apache.shiro.authc.UsernamePasswordToken;

import com.jx.agile.core.model.Account;

import lombok.Data;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/25/9:54
 * @Description:
 */
@Data
public class AccountToken extends UsernamePasswordToken {

    private Account account;

    public AccountToken(String username, char[] password, boolean rememberMe, String host, Account account) {
        super(username, password, rememberMe, host);
        this.account = account;
    }

    public AccountToken(String username, String password, Account account) {
        super(username, password);
        this.account = account;
    }

}
