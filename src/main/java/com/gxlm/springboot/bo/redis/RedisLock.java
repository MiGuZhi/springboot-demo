package com.gxlm.springboot.bo.redis;

import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年3月22日 下午9:12:08
 */
@Component
public class RedisLock {
	
	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	
	/**
	 * 添加锁
	 * 
	 * @author 立子
	 * @version 日期:2020年4月7日
	 * @param lockKey
	 * @param timeout
	 * @param timeUnit
	 * @return
	 */
	public boolean lock(String lockKey, int timeout, TimeUnit timeUnit) {
        String lockValue = String.valueOf(System.currentTimeMillis() + timeUnit.toMillis(timeout));
        if (redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue))
        	return expireLock(lockKey, timeout, timeUnit);
        Object lockValueObj = redisTemplate.opsForValue().get(lockKey);
        //null则再次尝试一下
        if(lockValueObj == null && redisTemplate.opsForValue().setIfAbsent(lockKey, lockValue))
        	return expireLock(lockKey, timeout, timeUnit);
        //缓存过期优化
//        long expireTime = Long.parseLong(lockValueObj.toString());
//        //未过期
//        if(System.currentTimeMillis() < expireTime)
//        	return false;
//        Object lastLockValue = redisTemplate.opsForValue().getAndSet(lockKey, lockValue);
//        /*
//         * 极端问题: 
//         * (1).两个线程同时getSet,两者的lockValue不一样时,失败的肯定会覆写成功的lockValue,两者的lockValue一样则两者都拿到了锁,这不符合锁的原则
//         * (2).通常锁过期,Redis是可以setnx的,另一个线程setnx成功,这里又覆写了人家的lockValue值,如果lockValue值一样则两者都能拿到锁
//         * 所以从逻辑上来讲这里是存在漏洞的
//         */
//        if(lastLockValue != null && expireTime == Long.parseLong(lastLockValue.toString()))
//        	return expireLock(lockKey, timeout, timeUnit);
        return false;
    }
    
	/**
	 * 解锁
	 * 
	 * @author 立子
	 * @version 日期:2020年3月22日
	 * @return
	 */
	public void unlock(String lockKey) {
		redisTemplate.delete(lockKey);
	}

	/**
	 * 给锁加上过期时间
	 * 
	 * @author 立子
	 * @version 日期:2020年3月22日
	 * @param lockKey
	 * @param timeout
	 * @param timeUnit
	 * @return
	 */
	private boolean expireLock(String lockKey, int timeout, TimeUnit timeUnit) {
		int maxFailCount = 3;
		int count = 0;
		while(count < 3) {
			count++;
			try {
				redisTemplate.expire(lockKey, timeout, timeUnit);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
			}
			if(count == maxFailCount) {
				try {
					redisTemplate.delete(lockKey);
				} catch (Exception e) {
					e.printStackTrace();
				}
				return false;
			}
			try {
				Thread.sleep(maxFailCount * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

}