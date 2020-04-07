package com.gxlm.springboot.web.controller.prop.staticprop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description 类描述: <br/>
 * 静态属性注入
 * 静态属性的注入只能在其非静态setter方法上注入(注意是非静态的,不然肯定会失败的)
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:43:52
 */
@Component
public class StaticRandomProp {
	public static Integer num;

	public static Integer num1;

	public static String str;

	public static String uuid;

	@Value("${staticRandomProp.num}")
	public void setNum(Integer num) {
		StaticRandomProp.num = num;
	}

	@Value("${staticRandomProp.num1}")
	public void setNum1(Integer num1) {
		StaticRandomProp.num1 = num1;
	}

	@Value("${staticRandomProp.str}")
	public void setStr(String str) {
		StaticRandomProp.str = str;
	}

	@Value("${staticRandomProp.uuid}")
	public void setUuid(String uuid) {
		StaticRandomProp.uuid = uuid;
	}

	public Integer getNum() {
		return num;
	}

	public Integer getNum1() {
		return num1;
	}

	public String getStr() {
		return str;
	}

	public String getUuid() {
		return uuid;
	}
}