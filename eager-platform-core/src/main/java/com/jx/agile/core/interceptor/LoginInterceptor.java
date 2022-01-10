package com.jx.agile.core.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashSet;
import java.util.Set;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        String basePath = request.getContextPath();
        String path = request.getRequestURI();
        //是否进行登陆拦截
        if(!doLoginInterceptor(path, basePath) ){
            return true;
        }
        //如果登录了，会把用户信息存进session
        HttpSession session = request.getSession();
       //Admin admin = (Admin) session.getAttribute("admin");
        if("admin"==null){
            String requestType = request.getHeader("X-Requested-With");
            // Ajax 请求
            if(requestType!=null && "XMLHttpRequest".equals(requestType)){
                //登录超时
                response.setHeader("sessionstatus","timeout");
                response.getWriter().print("/LoginTimeout");
                return false;
            } else {
                response.sendRedirect(request.getContextPath()+"/login");
            }
            return false;
        }else{
            //存入session
            session.setAttribute("admin","");
        }
//      log.info("用户已登录,userName:"+userInfo.getSysUser().getUserName());
        return true;
    }

    /**
     * 是否进行登陆过滤
     * @param path
     * @param basePath
     * @return
     */
    private boolean doLoginInterceptor(String path,String basePath){
        path = path.substring(basePath.length());
        Set<String> notLoginPaths = new HashSet<>();
        //设置不进行登录拦截的路径：登录注册和验证码
        notLoginPaths.add("/login");
        notLoginPaths.add("/error");

        notLoginPaths.add("/admin/login");
        notLoginPaths.add("/LoginTimeout");//超时页面
        notLoginPaths.add("/defaultKaptcha");//生产验证码
        notLoginPaths.add("/js/**");
        notLoginPaths.add("/layui/**");
        notLoginPaths.add("/jquery-3.2.1/**");

        if(notLoginPaths.contains(path)) {
            return false;
        }
        return true;
    }
}
