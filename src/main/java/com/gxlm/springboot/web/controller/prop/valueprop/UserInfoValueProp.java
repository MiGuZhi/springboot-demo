package com.gxlm.springboot.web.controller.prop.valueprop;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:03:52
 */
@Component
public class UserInfoValueProp {
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
     * List集合
     */
    private List<Integer> list;
    
    /**
     * map集合属性注入
     */
    private Map<String,String> map;
    
    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSex() {
        return sex;
    }
    
    public List<Integer> getList() {
    	return list;
    }
    
    public Map<String, String> getMap() {
		return map;
	}

	@Value("${userInfoValueProp.age}")
    public void setAge(Integer age) {
        this.age = age;
    }

    @Value("${userInfoValueProp.name}")
    public void setName(String name) {
        this.name = name;
    }

    @Value("${userInfoValueProp.sex}")
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * 如果List集合元素是以"-"分隔,就像这样:
     * list:
     * 	- 1
     * 	- 2
     * 	- 3
     * 则@Value注解可直接配置成"${userInfoValueProp.list}",只是分隔符是",",所以需要指定分隔符
     * 写成这样"#{'${userInfoValueProp.list}'.split(',')}"
     * 
     * TODO 实测验证:
     * Value注解默认的"-"集合元素格式实测在SpringBoot中行不通,启动报错,原因未知,后面再看是什么情况
     * 
     * @author 立子
     * @version 日期:2020年3月22日
     * @param list
     */
    @Value("#{'${userInfoValueProp.list}'.split(',')}")
	public void setList(List<Integer> list) {
		this.list = list;
	}

	/**
     * 映射集合注入方式
     * 
     * @author 立子
     * @version 日期:2019年12月13日
     * @param map
     */
//    @Value("#{${userInfoValueProp.map}}")
	public void setMap(Map<String, String> map) {
		this.map = map;
	}
    
}