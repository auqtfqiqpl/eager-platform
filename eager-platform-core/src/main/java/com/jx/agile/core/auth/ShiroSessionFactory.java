package com.jx.agile.core.auth;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SessionContext;
import org.apache.shiro.session.mgt.SessionFactory;

/**
 * 自定义SESSION
 * @author ly-jiangxh
 * @date 2021/03/29 09:40
 **/
public class ShiroSessionFactory implements SessionFactory {
    @Override
    public Session createSession(SessionContext initData) {
        return null;
    }
}
