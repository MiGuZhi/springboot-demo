package com.gxlm.springboot.web.controller.prop.valueprop;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:38:37
 */
@Component
public class RandomValueProp {
    @Value("${randomValueProp.num}")
    private Integer num;
    
    @Value("${randomValueProp.num1}")
    private Integer num1;
    
    @Value("${randomValueProp.str}")
    private String str;
    
    @Value("${randomValueProp.uuid}")
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