package com.gxlm.springboot.web.controller.prop.configprop;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Description 类描述:
 * <br/>嵌套对象(对象包含另一个对象)属性注入
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:03:59
 */
@Component
@ConfigurationProperties(prefix="config-student-prop")
public class ConfigStudentProp {
    /**
     * 班级名称
     */
    private String className;
    
    /**
     * 学号
     */
    private Long cno;
    
    /**
     * 用户基本信息
     */
    private ConfigUserInfoProp userInfo;

    public String getClassName() {
        return className;
    }

    public Long getCno() {
        return cno;
    }

    public ConfigUserInfoProp getUserInfo() {
        return userInfo;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setCno(Long cno) {
        this.cno = cno;
    }

    public void setUserInfo(ConfigUserInfoProp userInfo) {
        this.userInfo = userInfo;
    }
}