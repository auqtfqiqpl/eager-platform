package com.jx.agile.core.interceptor;

import com.jx.agile.core.utils.JacksonUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * 请求日志监控
 */
@Slf4j
@Aspect
@Component
public class LogInterceptor {

    long yellowThreshold = 2000;

    long redThreshold = 5000;

    /** 以 controller 包下定义的所有请求为切入点 */
    @Pointcut(value = "execution(public * com.jx.agile.*.controller.*.*.*(..))")
    public void webLog() {}

    /**
     * 在切点之前织入
     * @param joinPoint
     * @throws Throwable
     */
    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) throws Throwable {
        // 开始打印请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Object[] args = joinPoint.getArgs();
        Object[] arguments = new Object[args.length];
        for (int i = 0; i < args.length; i++) {
            if (args[i] instanceof ServletRequest || args[i] instanceof ServletResponse || args[i] instanceof MultipartFile) {
                continue;
            }
            arguments[i] = args[i];
        }
        String paramter = "";
        if (arguments != null) {
            try {
                paramter = JacksonUtil.beanToJson(arguments);
            } catch (Exception e) {
                paramter = arguments.toString();
            }
        }

        // 请求 url
        log.info("URL            : {}", request.getRequestURL().toString());
        // Http method
        log.info("HTTP Method    : {}", request.getMethod());
        // 调用 controller 的全路径以及执行方法
        log.info("Class Method   : {}.{}", joinPoint.getSignature().getDeclaringTypeName(), joinPoint.getSignature().getName());
        // 请求的 IP
        log.info("IP     : {}", request.getRemoteAddr());
        // 请求入参
        log.info("Request Args   : {}", paramter);

    }
    /**
     * 在切点之后织入
     * @throws Throwable
     */
    @After("webLog()")
    public void doAfter() throws Throwable {
    }
    /**
     * 环绕
     * @param proceedingJoinPoint
     * @return
     * @throws Throwable
     */
    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        // 请求日志
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String ip = request.getRemoteAddr();
        String url = request.getRequestURL().toString();

        Object result = proceedingJoinPoint.proceed();

        long totalTime = System.currentTimeMillis()-startTime;

        String viewResult = JacksonUtil.beanToJson(result);

        if(totalTime >= yellowThreshold && totalTime < redThreshold){
            log.warn("IP:{},request-url【{}】,Cost-Time：{},result:{}",ip,url,totalTime,viewResult);
        }else if(totalTime >= redThreshold ){
            log.warn("IP:{},request-url【{}】,Cost-Time：{},result:{}",ip,url,totalTime,viewResult);
        }else{
            log.info("IP:{},request-url【{}】,Cost-Time：{},result:{}",ip,url,totalTime,viewResult);
        }
        return result;
    }
}
