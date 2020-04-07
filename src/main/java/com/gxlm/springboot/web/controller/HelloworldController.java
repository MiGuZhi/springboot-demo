package com.gxlm.springboot.web.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description 类描述: <br/>
 * SpringBoot入门 -Hello World
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年11月26日 下午5:58:58
 */
@RestController
public class HelloworldController {

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String helloworld() {
		return "Hello World";
	}

	@RequestMapping(value = "/chinese", method = RequestMethod.GET)
	public String chinese() {
		return "你好,SpringBoot";
	}

}
