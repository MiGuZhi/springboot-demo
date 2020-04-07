package com.gxlm.springboot.web.controller.prop.configprop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description 类描述: <br/>
 * 随机属性注入
 * 对象化的随机属性在初始化时随机分配的,之后不会改变,即随机属性值只体现在对象初始化注入属性的时候
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:38:37
 */
@Component
// @Scope("prototype")
@ConfigurationProperties(prefix = "config-random-prop")
public class ConfigRandomProp {
	private Integer num;

	private Integer num1;

	private String str;

	private String uuid;

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

	public void setNum(Integer num) {
		this.num = num;
	}

	public void setNum1(Integer num1) {
		this.num1 = num1;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}