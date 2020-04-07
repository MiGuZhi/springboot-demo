package com.gxlm.springboot.web.intercept;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Description 类描述:
 * <br/>
 * 同MvcInterceptorConfig一样将拦截器加入到SpringMVC容器中,只是没测试
 * 
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年3月22日 下午5:52:30
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {
	
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
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}
	
	/**
	 * 添加拦截器链
	 * 
	 * @Override
	 * @author 立子
	 * @version 日期:2020年3月22日
	 * @param registry
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
//		/// addPathPatterns("/**") 表示拦截所有的请求，
        // excludePathPatterns("/login", "/register") 表示除了登陆与注册之外，因为登陆注册不需要登陆也可以访问
        registry.addInterceptor(requestIntercept()).addPathPatterns("/**").excludePathPatterns("/login", "/register");
		WebMvcConfigurer.super.addInterceptors(registry);
	}

}

