package com.gxlm.springboot.common.enums;

/**
 * Description 类描述:
 * <br/> 状态枚举类
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年6月25日 下午2:37:56
 */
public enum State {
	
	/*
	 * 具体码均有范围: 异常种类范围可以值从20~50
	 *  
	 * (1)正常数据
	 * 1000  泛指状态码:泛指业务正常码
	 * 1001 ~ 1999
	 * 
	 * (2)客户端异常 
	 * 2000 泛指状态码:泛指客户端出现的异常码
	 * 2001 ~ 2999
	 * 
	 * (3)服务端异常
	 * 3000 泛指状态码:泛指服务端出现的逻辑码
	 * 3001 ~ 3999
	 * 
	 * (4)逻辑异常
	 * 逻辑异常指的是客户端请求,服务端处理均正常,但用户本身逻辑问题
	 * 比如session失效,未登录等等
	 * 
	 * 4000 泛指状态码:泛指业务逻辑异常码
	 * 4001 ~ 4999
	 * 
	 */
	 
	/*#############################正常代码#############################*/
	/**
	 * 正常,操作成功
	 */
	OK(1000, "ok"),
	/**
	 * 没有数据
	 */
	Empty(1002, "没有数据"),
	/**
	 * 数据不存在-过期数据
	 */
	EXPIRE_DATA(1003, "数据不存在"),
	/**
	 * 操作失败
	 */
	OPERATE_FAIL(1004, "操作失败"),

	/*#############################客户端异常#############################*/
	/**
	 * 客户端异常
	 */
	WARNING(2000, "客户端请求不合理!"),
	/*--------- 2001 ~ 2020 参数方面的异常----------*/
	/**
	 * 空参异常
	 */
	NULL_PARAMS(2002, "空参异常!"),
	/**
	 * 非法参数 - 参数范围,类型错误
	 */
	ILLEGAL_PARAMS(2003, "参数不符合要求!"),
	/**
	 * 内容长度超出要求
	 */
	OVERFLOW(2004, "内容长度溢出"),
	/**
	 * 验证码错误
	 */
	VERIFY_CODE_ERR(2021, "验证码错误"),
	/*#############################服务端异常#############################*/
	/**
	 * 服务端异常
	 */
	ERROR(3000, "服务器异常"),
	/*--------- 3001 ~ 3020 数据异常----------*/

	/*###############################业务逻辑异常###########################*/
	/**
	 * 业务逻辑错误
	 */
	BUSINESS_ERROR(4000, "业务逻辑错误!"),
	/*--------- 4001 ~ 4020 用户逻辑异常----------*/
	/**
	 * 不可用
	 */
	UNAVAILABLE(4002, "账号不可用!"),
	/**
	 * 密码错误
	 */
	PASSWORD_ERROR(4003, "密码错误!"),
	/**
	 * 离线或未登录
	 */
	OFF_LINE(4004, "离线或未登录!"),
	/**
	 * 账户不存在
	 */
	NOT_EXISTS_ACCOUNT(4005, "账号不存在!"),
	/**
	 * 用户没有权限
	 */
	NO_PERMISSION(4006, "权限不足,无权操作!"),
	/**
	 * 用户重复操作
	 */
	REPEAT_OPERATE(4007, "重复操作"),
	/**
	 * 系统不支持
	 */
	OS_NOT_SUPPORT(4008, "系统不支持"),
	/**
	 * 校验失败
	 */
	VERIFY_FAIL(4009, "校验失败"),
	/**
	 * 
	 */
	NO_REGISTER(4010, "未注册");

	/**
	 * 状态码
	 */
	private int code;

	/**
	 * 默认提示信息
	 */
	private String info;

	private State(int code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getInfo() {
		return info;
	}

	public int getCode() {
		return code;
	}
  
}