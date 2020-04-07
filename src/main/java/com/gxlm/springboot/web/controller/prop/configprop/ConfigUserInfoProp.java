package com.gxlm.springboot.web.controller.prop.configprop;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description 类描述:
 * <br/>属性注入
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:03:52
 */
@Component
@ConfigurationProperties(prefix="user-info")
public class ConfigUserInfoProp {
    /**
     * 年龄
     */
    private Integer age;
    
    /**
     * 姓名
     */
    private String name;
    
    /**
     * 性别:男,女
     */
    private String sex;
    
    /**
     * 成人
     */
    private boolean adult;
    
    /**
     * List集合
     */
    private List<String> list;
    
    /**
     * map集合
     */
    private Map<String, String> map;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

	public boolean isAdult() {
		return adult;
	}

	public void setAdult(boolean adult) {
		this.adult = adult;
	}

	public List<String> getList() {
		return list;
	}

	public void setList(List<String> list) {
		this.list = list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public void setMap(Map<String, String> map) {
		this.map = map;
	}
    
}