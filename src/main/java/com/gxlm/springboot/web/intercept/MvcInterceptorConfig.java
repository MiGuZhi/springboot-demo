package com.gxlm.springboot.web.intercept;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年3月22日 下午5:43:54
 */
//@Configuration
public class MvcInterceptorConfig extends WebMvcConfigurationSupport {
	
	@Bean
	public RequestIntercept requestIntercept() {
		return new RequestIntercept();
	}
	
	/**
	 * 配置静态资源白名单
	 * 
	 * @Override
	 * @author 立子
	 * @version 日期:2020年3月22日
	 * @param returnValueHandlers
	 */
	@Override
	protected void addReturnValueHandlers(List<HandlerMethodReturnValueHandler> returnValueHandlers) {
		// TODO Auto-generated method stub
		super.addReturnValueHandlers(returnValueHandlers);
	}

	/**
	 * 配置拦截器链
	 * 
	 * @Override
	 * @author 立子
	 * @version 日期:2020年3月22日
	 * @param registry
	 */
	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		// 多个拦截器组成一个拦截器链
        // addPathPatterns 用于添加拦截规则，/**表示拦截所有请求
        // excludePathPatterns 用户排除拦截
        registry.addInterceptor(requestIntercept()).addPathPatterns("/**")
        .excludePathPatterns("/stuInfo/getAllStuInfoA","/account/register");    
        super.addInterceptors(registry);
	}
	
	

}

