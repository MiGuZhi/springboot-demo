package com.gxlm.springboot.config;

import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.util.IOUtils;

/**
 * Description 类描述:
 * <br/>自定义Redis序列化和反序列化
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月28日 上午10:59:47
 */
public class JsonStringSerializer implements RedisSerializer<Object> {
	
	/**
	 * 序列化成json字符串字节数组
	 * 
	 * @Override
	 * @author 立子
	 * @version 日期:2018年11月28日
	 * @param obj
	 * @return
	 * @throws SerializationException
	 */
	@Override
	public byte[] serialize(Object obj) throws SerializationException {
		if (obj == null)
            return new byte[0];
        try {
        	String jsonString = JSON.toJSONStringWithDateFormat(obj, "yyyy-MM-dd HH:mm:ss");
            return jsonString.getBytes(IOUtils.UTF8);
        } catch (Exception ex) {
            throw new SerializationException("Could not serialize: " + ex.getMessage(), ex);
        }
	}

	/**
	 * 反序列化成json字符串
	 * 
	 * @Override
	 * @author 立子
	 * @version 日期:2018年11月28日
	 * @param bytes
	 * @return
	 * @throws SerializationException
	 */
	@Override
	public Object deserialize(byte[] bytes) throws SerializationException {
		if (bytes == null || bytes.length == 0)
			return null;
		return new String(bytes, IOUtils.UTF8);
	}

}

