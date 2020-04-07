package com.gxlm.springboot.bo.goods.impl;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.gxlm.springboot.bo.goods.GoodsBo;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年2月22日 下午1:29:26
 */
@Service
public class GoodsBoImpl implements GoodsBo {
	
//	@Autowired
//    private StringRedisTemplate stringRedisTemplate;
//	@Autowired
//	private RedisTemplate<String,String> jacksonRedisTemplate;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	
	private static final String USER_KEY_PREFIX = "unique:user";
	
	@Override
	public int countGoods(String date) {
		final String key = USER_KEY_PREFIX + date;
		return redisTemplate.execute(new RedisCallback<Long>() {
			
			@Override
			public Long doInRedis(RedisConnection connection) throws DataAccessException {
				return connection.bitCount(key.getBytes(StandardCharsets.UTF_8));
			}
			
		}).intValue();
	}

	@Override
	public void goods(String date, long userIdIndex, boolean isGoods) {
		String key = USER_KEY_PREFIX + date;
		redisTemplate.opsForValue().setBit(key, userIdIndex, isGoods);
	}

	@Override
	public boolean hasGoods(String date, long userIdIndex) {
		String key = USER_KEY_PREFIX + date;
		return redisTemplate.opsForValue().getBit(key, userIdIndex);
	}

}

