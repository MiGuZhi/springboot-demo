package com.gxlm.springboot;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Description 类描述:
 * <br/> SpringBoot Redis单元测试 
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月28日 上午10:50:09
 */
@SpringBootTest
//使用Junit较原始的的Spring单元测试也可以,不过这里比较推荐使用SpringBoot的专门用于单元测试的注解
//@RunWith(SpringJUnit4ClassRunner.class)
@RunWith(SpringRunner.class)
public class RedisTest {
	
	@Autowired
    private StringRedisTemplate stringRedisTemplate;
	@Autowired
	private RedisTemplate<String,Object> redisTemplate;
	@Autowired
	private RedisTemplate<String,Object> jacksonRedisTemplate;

//	@Test
//	public void contextLoads() {
//	}
	
	/**
	 * 使用Spring data redis 进行保存测试
	 * 
	 * @author 立子
	 * @version 日期:2018年11月28日
	 */
	@Test
	public void testSave() {
		ValueOperations<String, String> opsForValue = stringRedisTemplate.opsForValue();
		opsForValue.set("springBoot", "springBoot 单元测试");
	}
	
	/**
	 * 测试Redis配置是否正常
	 * 
	 * @author 立子
	 * @version 日期:2018年6月21日
	 */
//	@Test
//	public void testRedisConfig() {
//		//value
//		Info info = new Info("张三", 20);
//		redisTemplate.opsForValue().set("info", info, 1, TimeUnit.DAYS);
//		Object obj = redisTemplate.opsForValue().get("info");
//		System.out.println(obj);
//		
//		//hash
//		UserInfo userInfo = new UserInfo("中国移动", 10086, 120);
//		redisTemplate.opsForHash().put("test-userInfo", 10086, userInfo);
//		Object obj2 = redisTemplate.opsForHash().get("test-userInfo", 10086);
//		System.out.println(obj2);
//		
//		Info info1 = JSON.parseObject(obj2.toString(), Info.class);
//		UserInfo userInfo1 = JSON.parseObject(obj.toString(), UserInfo.class);
//		System.out.println("转换测试对比");
//		System.out.println(info);
//		System.out.println(info1);
//		System.out.println("--------------------------------");
//		System.out.println(userInfo);
//		System.out.println(userInfo1);
//		
//		//写入空对象测试
//		Info emptyInfo = new Info();
//		redisTemplate.opsForValue().set("emptyInfo", emptyInfo, 1, TimeUnit.DAYS);
//		System.out.println(redisTemplate.opsForValue().get("emptyInfo"));
//	}
	
	/**
	 * List测试
	 * 
	 * @author 立子
	 * @version 日期:2018年11月28日
	 */
	@Test
	public void testRedisList() {
		ListOperations<String, Object> opsForList = redisTemplate.opsForList();
		String redisKey = "opsForList";
		redisTemplate.delete(redisKey);
		opsForList.leftPush(redisKey, 1033L);
		opsForList.leftPush(redisKey, "一");
		opsForList.leftPush(redisKey, "二");
		opsForList.leftPush(redisKey, "三");
		opsForList.leftPush(redisKey, "四");
		opsForList.leftPush(redisKey, new Date());
		List<Object> list = opsForList.range(redisKey, 0, -1);
		for (Object object : list)
			System.out.println(object);
	}
	
	/**
	 * Jackson序列化方式
	 * 
	 * @author 立子
	 * @version 日期:2018年11月28日
	 */
	@Test
	public void testRedisListByJackson() {
		ListOperations<String, Object> opsForList = jacksonRedisTemplate.opsForList();
		String redisKey = "opsForList";
		redisTemplate.delete(redisKey);
		opsForList.leftPush(redisKey, "一");
		opsForList.leftPush(redisKey, "二");
		opsForList.leftPush(redisKey, "三");
		opsForList.leftPush(redisKey, "四");
		List<Object> list = opsForList.range(redisKey, 0, -1);
		for (Object str : list)
			System.out.println(str);
	}
	
	/**
	 * Set测试
	 * 
	 * @author 立子
	 * @version 日期:2018年7月5日
	 */
	@Test
	public void testRedisSet() {
		SetOperations<String, Object> opsForSet = redisTemplate.opsForSet();
		String redisKey = "opsForSet";
		redisTemplate.delete(redisKey);
		opsForSet.add(redisKey, 1);
		opsForSet.add(redisKey, 2);
		opsForSet.add(redisKey, 3);
		opsForSet.add(redisKey, 4);
		opsForSet.add(redisKey, 5);
		opsForSet.add(redisKey, "一");
		opsForSet.add(redisKey, "二");
		opsForSet.add(redisKey, "三");
		opsForSet.add(redisKey, "四");
		opsForSet.add(redisKey, "五");
		Set<Object> objList = opsForSet.members(redisKey);
		for (Object object : objList)
			System.out.println(object);
	}
	
}
