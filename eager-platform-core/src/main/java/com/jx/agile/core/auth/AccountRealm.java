package com.jx.agile.core.auth;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/25/9:13
 * @Description:
 */
public class AccountRealm extends AuthorizingRealm {

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        AccountToken jwtToken = (AccountToken) principals.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.addStringPermission("zdyl:test:1");
        return authorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        AccountToken accountToken = (AccountToken) token;
        //accountToken.setUsername("1");
       // String token = jwtToken.getToken();
        // 第二步：根据用户输入的userCode从数据库查询
        // ....
        // 如果查询不到返回null
        //数据库中用户账号是zhangsansan
        /*if(!userCode.equals("zhangsansan")){//
            return null;
        }*/
        // 模拟从数据库查询到密码
        String password = "111112";
        // 如果查询到返回认证信息AuthenticationInfo
        com.jx.agile.core.model.Account account = new com.jx.agile.core.model.Account();
        account.setPassword("111");
        account.setUsername("root");

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                account, accountToken.getPassword(), this.getName());
        return simpleAuthenticationInfo;
    }
}
