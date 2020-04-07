package com.gxlm.springboot.web.controller.prop.configprop.bean;


/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年10月10日 上午11:48:47
 */
public class FcmAppInfo {
    
    private String appName;
    private String credentClassPath;
    private String databaseUrl;
    
    public String getAppName() {
        return appName;
    }
    public void setAppName(String appName) {
        this.appName = appName;
    }
    public String getCredentClassPath() {
        return credentClassPath;
    }
    public void setCredentClassPath(String credentClassPath) {
        this.credentClassPath = credentClassPath;
    }
    public String getDatabaseUrl() {
        return databaseUrl;
    }
    public void setDatabaseUrl(String databaseUrl) {
        this.databaseUrl = databaseUrl;
    }

}

