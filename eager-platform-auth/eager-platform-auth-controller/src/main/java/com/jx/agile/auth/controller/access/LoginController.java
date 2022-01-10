package com.jx.agile.auth.controller.access;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

import com.jx.agile.core.auth.AccountToken;
import com.jx.agile.core.constant.ResultStatusConstant;
import com.jx.agile.core.model.Account;
import com.jx.agile.core.utils.ResultUtils;
import com.jx.agile.core.web.Result;

import lombok.extern.slf4j.Slf4j;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/25/16:02
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/access")
public class LoginController {

    /**
     * 登录系统
     * @param account
     * @return
     */
    @PostMapping("/doLogin")
    public Result doLogin(HttpServletRequest request, HttpServletResponse response,Account account)
    {
//        Cookie[] cookies = request.getCookies();
//
//for(Cookie cookie:cookies) {
//    cookie.setPath("/");
//
//    cookie.setMaxAge(0);
//
//    response.addCookie(cookie);
//
//    request.getSession().invalidate();
//}
        account.setUsername("root");
        account.setPassword("111");
        Result result = ResultUtils.success();
        AccountToken accountToken = new AccountToken(account.getUsername(), account.getPassword(), account);
        try {
            SecurityUtils.getSubject().login(accountToken);
            Subject subject = SecurityUtils.getSubject();
            Account currentUser = (Account) subject.getPrincipal();

            Serializable authToken = subject.getSession().getId();
            subject.getSession().setAttribute("sessionid", authToken);
            result.setData(authToken);
        }catch (Exception exception){
            exception.printStackTrace();
        }

        return result;
    }


    @GetMapping("/index")
    public String index() {
        Subject subject = SecurityUtils.getSubject();
        Account currentUser = (Account) subject.getPrincipal();
        log.info("index");
        return "test";
    }


    /**
     * 处理未登录或未授权的系统
     * @return
     */
    @GetMapping("/login")
    public Result login() {
        return ResultUtils.fail("您还未登录系统，请先登录！", ResultStatusConstant.NOT_LOGIN);
    }


    /**
     * 退出系统
     * @return
     */
    @GetMapping("/logout")
    @ResponseBody
    public Result logout(){
        SecurityUtils.getSubject().logout();
        return ResultUtils.success("成功退出系统");
    }
}
