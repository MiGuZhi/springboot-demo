package com.gxlm.springboot.web.controller.prop.valueprop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:03:59
 */
@Component
public class StudentValueProp {
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
    private UserInfoValueProp userInfo;

    /**
     * @Value写在getter方法上,将没法注入到成员变量上
     * 
     * @author 立子
     * @version 日期:2019年7月16日
     * @return
     */
    @Value("${studentValueProp.className}")
    public String getClassName() {
        return className;
    }

    @Value("${studentValueProp.cno}")
    public Long getCno() {
        return cno;
    }

//    @Value("${studentValueProp.userInfo}")
    public UserInfoValueProp getUserInfo() {
        return userInfo;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setCno(Long cno) {
        this.cno = cno;
    }

    /**
     * 不能通过@Value注解注入对象属性
     * 
     * @author 立子
     * @version 日期:2019年7月16日
     * @param userInfo
     */
//    @Value("${studentValueProp.userInfo}")
    public void setUserInfo(UserInfoValueProp userInfo) {
        this.userInfo = userInfo;
    }
}