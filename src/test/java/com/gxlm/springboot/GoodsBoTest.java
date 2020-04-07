package com.gxlm.springboot;

import org.gxlm.core.util.DateUtil;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.gxlm.springboot.bo.goods.GoodsBo;

/**
 * Description 类描述:
 * <br/>点赞小demo(位图)
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年2月22日 下午1:55:04
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GoodsBoTest {
	@Autowired
	private GoodsBo goodsBoImpl;
	
	private String queryDate;
	private long baseUserId;
	
	@Before
	public void setup() {
		queryDate = DateUtil.getCurrentTime("yyyyMMdd");
		baseUserId = 10000L;
	}
	
	/**
	 * 点赞查询
	 * 
	 * @author 立子
	 * @version 日期:2020年2月29日
	 */
	@Test
	public void testQueryGoods() {
		long userId = 10002L;
		long userIdIndex = userId - baseUserId;
		boolean isGood = goodsBoImpl.hasGoods(queryDate, userIdIndex);
		if(isGood)
			System.out.println("用户id为[" + userId + "]当日已点过赞");
		else
			System.out.println("用户id为[" + userId + "]当日未点过赞");
	}
	
	/**
	 * 点赞操作
	 * 
	 * @author 立子
	 * @version 日期:2020年2月29日
	 */
	@Test
	public void testOperateGoods() {
		boolean operateGoods = true;
		long userId = 10002L;
		long userIdIndex = userId - baseUserId;
		boolean isGood = goodsBoImpl.hasGoods(queryDate, userIdIndex);
		if(operateGoods == isGood) {
			if(isGood)
				System.out.println("用户id为[" + userId + "]当日已点过赞,不能重复点赞");
			else
				System.out.println("用户id为[" + userId + "]当日未点过赞,不能执行取消点赞操作");
			return;
		}
		goodsBoImpl.goods(queryDate, userIdIndex, operateGoods);
	}
	
	/**
	 * 统计点赞人数
	 * 
	 * @author 立子
	 * @version 日期:2020年2月29日
	 */
	@Test
	public void testCountGoods() {
		int countGoods = goodsBoImpl.countGoods(queryDate);
		System.out.println("当日点赞数:" + countGoods);
	}
	

}

