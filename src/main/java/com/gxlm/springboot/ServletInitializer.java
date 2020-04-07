package com.gxlm.springboot;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Description 类描述: <br/>
 * 如果要将SpringBoot Web打包成war包需要继承SpringBootServletInitializer类并重写configure方法.
 * (1)如果当前类不是SpringBoot启动类,就不需要写SpringbootDemoApplication的那个main方法(本例就是分开了的)
 * (2)如果当前类是SpringBoot的启动类,重写configure方法,同时需要写SpringbootDemoApplication的那个main方法,
 * 而且sources方法的参数是当前类
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月27日 下午8:08:54
 */
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		//sources方法的参数是SpringBoot启动类
		return application.sources(SpringBootDemoApplication.class);
	}

}
