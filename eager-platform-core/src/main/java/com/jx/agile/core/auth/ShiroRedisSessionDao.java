package com.jx.agile.core.auth;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

/**
 * session
 * @author ly-jiangxh
 * @date 2021/03/29 08:47
 **/
@Slf4j
@Service
public class ShiroRedisSessionDao {
//        extends AbstractSessionDAO {
//    // Session超时时间，单位为毫秒
//    private long expireTime = 120000;
//
//    @Autowired
//    private RedisTemplate redisTemplate;
//
//    public ShiroRedisSessionDao() {
//        super();
//    }
//
//    public ShiroRedisSessionDao(long expireTime, RedisTemplate redisTemplate) {
//        super();
//        this.expireTime = expireTime;
//        this.redisTemplate = redisTemplate;
//    }
//
//    @Override // 更新session
//    public void update(Session session) throws UnknownSessionException {
//        log.info("===============update session================");
//        if (session == null || session.getId() == null) {
//            return;
//        }
//        session.setTimeout(expireTime);
//        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
//    }
//
//    @Override // 删除session
//    public void delete(Session session) {
//        log.info("===============delete  session================");
//        if (null == session) {
//            return;
//        }
//        redisTemplate.opsForValue().getOperations().delete(session.getId());
//    }
//
//    @Override
//    public Collection<Session> getActiveSessions() {
//        return null;
//    }
//
//    @Override
//    protected Serializable doCreate(Session session) {
//        log.info("===============doCreate session================");
//        Serializable sessionId = this.generateSessionId(session);
//        this.assignSessionId(session, sessionId);
//
//        redisTemplate.opsForValue().set(session.getId(), session, expireTime, TimeUnit.MILLISECONDS);
//        return sessionId;
//    }
//
//    @Override
//    protected Session doReadSession(Serializable sessionId) {
//        log.info("==============doReadSession Session=================");
//        if (sessionId == null) {
//            return null;
//        }
//        return (Session) redisTemplate.opsForValue().get(sessionId);
//    }
//
//    public long getExpireTime() {
//        return expireTime;
//    }
//
//    public void setExpireTime(long expireTime) {
//        this.expireTime = expireTime;
//    }
//
//    public RedisTemplate getRedisTemplate() {
//        return redisTemplate;
//    }
//
//    public void setRedisTemplate(RedisTemplate redisTemplate) {
//        this.redisTemplate = redisTemplate;
//
//    }
}
