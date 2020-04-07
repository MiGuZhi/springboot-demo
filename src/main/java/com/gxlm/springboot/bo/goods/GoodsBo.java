package com.gxlm.springboot.bo.goods;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年2月22日 下午1:25:19
 */
public interface GoodsBo {
	
	/**
	 * 统计点赞日期
	 * 
	 * @author 立子
	 * @version 日期:2020年2月22日
	 * @param date
	 * @return
	 */
	int countGoods(String date);
	
	/**
	 * 点赞操作
	 * 
	 * @author 立子
	 * @version 日期:2020年2月22日
	 * @param date
	 * @param userIdIndex
	 * @param isGoods true点赞,false取消点赞
	 */
	void goods(String date, long userIdIndex, boolean isGoods);
	
	/**
	 * 查询是否点赞过
	 * 
	 * @author 立子
	 * @version 日期:2020年2月22日
	 * @param date
	 * @param userIdIndex
	 * @return
	 */
	boolean hasGoods(String date, long userIdIndex);
	
	
	

}

