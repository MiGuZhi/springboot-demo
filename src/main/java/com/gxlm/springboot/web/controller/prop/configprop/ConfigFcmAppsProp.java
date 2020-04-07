package com.gxlm.springboot.web.controller.prop.configprop;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.gxlm.springboot.web.controller.prop.configprop.bean.FcmAppInfo;

/**
 * Description 类描述:
 * <br/>集合对象属性注入
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年10月10日 上午11:49:46
 */
@Component
@ConfigurationProperties(prefix = "config-fcm-apps-prop")
public class ConfigFcmAppsProp {
    
    private List<FcmAppInfo> list;

    public List<FcmAppInfo> getList() {
        return list;
    }

    public void setList(List<FcmAppInfo> list) {
        this.list = list;
    }

}

