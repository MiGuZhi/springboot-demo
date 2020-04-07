package com.gxlm.springboot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年4月7日 下午9:21:01
 */
@Configuration
public class RedisConfig {
	
	/**
	 * JedisConnectionFactory未配置时走的是默认库,也就是0库,所以这里返回的RedisTemplate对象操作的是默认库-0库
	 * 
	 * @author 立子
	 * @version 日期:2020年4月7日
	 * @param connFactory
	 * @return
	 */
	@Bean
    public RedisTemplate<String,Object> redisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
		/*
		 * "RedisConnectionFactory connectionFactory"可替换为具体的连接工厂,
		 * 可以使用jedis连接工厂"JedisConnectionFactory connFactory",
		 * 也能使用lettuce连接工厂"LettuceConnectionFactory lettuceConnectionFactory",
		 * 具体可用哪个,取决于你配置的redis客户端是jedis还是lettuce,这里不管你配置的是哪个,都是
		 * RedisConnectionFactory的子类,所以只要注入RedisConnectionFactory的实例Bean即可
		 */
		redisTemplate.setConnectionFactory(connectionFactory);
		RedisSerializer<?> keySerializer = new StringRedisSerializer();
		//FASTJSON通用序列化
		RedisSerializer<?> defaultSerializer = new GenericFastJsonRedisSerializer();
		//自定义实现的序列化
//		RedisSerializer<?> defaultSerializer = new JsonStringSerializer();
		//JACKSON序列化
//		RedisSerializer<?> defaultSerializer = new GenericJackson2JsonRedisSerializer();
		
		//key 序列化方式
        redisTemplate.setKeySerializer(keySerializer); 
        //如果都"value,hash key,hash value"都使用同一种序列化方式进行序列化,设置默认序列化即可
        redisTemplate.setDefaultSerializer(defaultSerializer);
        /* 分别序列化 */
//        //value序列化方式
//        redisTemplate.setValueSerializer(defaultSerializer); 
//        //hash key 序列化方式
//        redisTemplate.setHashKeySerializer(defaultSerializer); 
//        //hash value 序列化方式
//        redisTemplate.setHashValueSerializer(defaultSerializer); 
        return redisTemplate;
	}
	
	@Bean
	public RedisTemplate<String,Object> jacksonRedisTemplate(RedisConnectionFactory connectionFactory){
		RedisTemplate<String, Object> jacksonRedisTemplate = new RedisTemplate<String, Object>();
		jacksonRedisTemplate.setConnectionFactory(connectionFactory);
		//key的序列化方式
		jacksonRedisTemplate.setKeySerializer(new StringRedisSerializer()); 
		//value,hash key,hash value默认的序列化方式
		jacksonRedisTemplate.setDefaultSerializer(new JsonStringSerializer());
		return jacksonRedisTemplate;
	}
	
}

