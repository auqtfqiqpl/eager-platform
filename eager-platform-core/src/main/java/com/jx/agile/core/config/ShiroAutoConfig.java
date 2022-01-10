package com.jx.agile.core.config;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.mgt.SessionsSecurityManager;
import org.apache.shiro.session.SessionListener;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.session.mgt.eis.JavaUuidSessionIdGenerator;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.Cookie;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jx.agile.core.auth.AccountRealm;
import com.jx.agile.core.auth.AccoutSessionManager;
import com.jx.agile.core.listener.ShiroSessionListener;
import com.jx.agile.core.properties.RedisProperties;

import redis.clients.jedis.JedisPoolConfig;

/**
 * @Auther: auqtfqiqpl
 * @Date: 2021/02/25/9:20
 * @Description:
 */
@Configuration
@EnableConfigurationProperties(RedisProperties.class)
public class ShiroAutoConfig {

    private static final int HASH_ITERATIONS = 2;
    private static final String HASH_ALGORITHMNAME = "md5";
    private static final int SESSION_EXPIRETIME_SECOND = 60 * 60 * 24;

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置SecuritManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 拦截器
        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<String, String>();
        // 配置退出过滤器,其中的具体代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");

        //过滤链定义，从上向下顺序执行，一般将 /**放在最为下边
        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问

        filterChainDefinitionMap.put("/access/doLogin", "anon"); 	   //不拦截登录请求
        filterChainDefinitionMap.put("/access/login", "anon"); 	   //不拦截登录请求

        filterChainDefinitionMap.put("/script/**", "anon");    //不拦截js
        filterChainDefinitionMap.put("/css/**", "anon");       //不拦截css
        filterChainDefinitionMap.put("/js/**", "anon");        //不拦截js
        filterChainDefinitionMap.put("/img/**", "anon");       //不拦截图片
        filterChainDefinitionMap.put("/img2/**", "anon");      //不拦截图片
        filterChainDefinitionMap.put("/public/**", "anon");    //不拦截公共资源
        //filterChainDefinitionMap.put("/index", "roles[ADMIN]"); //设置特定角色访问
        filterChainDefinitionMap.put("/**", "authc");

        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("http://localhost:8080/auth/web/access/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/index");
        // 未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;

    }



    /**
     * 凭证匹配器
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //散列算法，这里使用md5
        matcher.setHashAlgorithmName(HASH_ALGORITHMNAME);
        //散列次数，这里散列2次
        matcher.setHashIterations(HASH_ITERATIONS);
        return matcher;
    }

    /**
     * 将自定义Realm设置为Bean，使用自定义凭证匹配值
     */
    @Bean
    @ConditionalOnMissingBean(AccountRealm.class)
    public AccountRealm accountRealm() throws Exception{
        AccountRealm accountRealm = new AccountRealm();
        accountRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return accountRealm;
    }

    /**
     * 配置shiro redis管理器，自动使用shiro-redis开源插件
     */
    @Bean
    public RedisManager redisManager(RedisProperties redisProperties) throws Exception {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(redisProperties.getHost()+":"+redisProperties.getPort());
        redisManager.setPassword(redisProperties.getPassword());
        redisManager.setJedisPoolConfig(jedisPoolConfig());

        return redisManager;
    }

    @Bean
    public JedisPoolConfig jedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig=new JedisPoolConfig();
        jedisPoolConfig.setMaxWaitMillis(3000);
        jedisPoolConfig.setMaxTotal(1000);
        jedisPoolConfig.setMaxIdle(500);
        return  jedisPoolConfig;
    }

    /**
     * sessionId生成器
     */
    @Bean
    public JavaUuidSessionIdGenerator sessionIdGenerator() throws Exception {
        return new JavaUuidSessionIdGenerator();
    }

    /**
     * 配置redis session DAO，为其配置redisManager和session生成器以及过期时间
     */
    @Bean
    public RedisSessionDAO redisSessionDAO(RedisProperties redisProperties)  throws Exception {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager(redisProperties));
        redisSessionDAO.setSessionIdGenerator(sessionIdGenerator());
        //session在redis中的保存时间，单位：秒
        redisSessionDAO.setExpire(SESSION_EXPIRETIME_SECOND);
        return redisSessionDAO;
    }

    /**
     * 配置session管理器，使用redis session DAO
     */
    @Bean
    public SessionManager sessionManager(RedisProperties redisProperties) throws Exception {
        AccoutSessionManager sessionManager = new AccoutSessionManager();

        Collection<SessionListener> listeners = new ArrayList<>();
        listeners.add(new ShiroSessionListener());

        //设置session超时时间为1小时(单位毫秒)
        sessionManager.setGlobalSessionTimeout(3600000);
        //设置redisSessionDao
        sessionManager.setSessionDAO(redisSessionDAO(redisProperties));
        //这个配置很重要，防止登录返回相同sessionId
        sessionManager.setSessionIdCookieEnabled(true);
        sessionManager.setDeleteInvalidSessions(true);
        sessionManager.setSessionIdCookie(getSessionIdCookie());
        return sessionManager;
    }

    @Bean(name="sessionIdCookie")
    public Cookie getSessionIdCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("token");
        simpleCookie.setHttpOnly(true);
        //simpleCookie.setMaxAge(1000000);
        //simpleCookie.setPath("/");
        return simpleCookie;
    }

    /**
     * 配置redis缓存管理器
     */
    @Bean
    public RedisCacheManager redisCacheManager(RedisProperties redisProperties) throws Exception {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager(redisProperties));
        //设置缓存类对象的主键字段
        redisCacheManager.setPrincipalIdFieldName("id");
        //设置访问缓存时间，单位：秒
        redisCacheManager.setExpire(SESSION_EXPIRETIME_SECOND);
        return redisCacheManager;
    }

    /**
     * 配置安全管理器
     */
    @Bean
    public SessionsSecurityManager securityManager(RedisProperties redisProperties) throws Exception {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //使用自定义Realm
        securityManager.setRealm(new AccountRealm());
        //使用自定义session管理器
        securityManager.setSessionManager(sessionManager(redisProperties));
        //使用自定义缓存管理器
        securityManager.setCacheManager(redisCacheManager(redisProperties));
        return securityManager;
    }

}
