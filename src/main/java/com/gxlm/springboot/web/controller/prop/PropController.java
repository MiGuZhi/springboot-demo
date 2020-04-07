package com.gxlm.springboot.web.controller.prop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gxlm.springboot.web.controller.prop.configprop.ConfigFcmAppsProp;
import com.gxlm.springboot.web.controller.prop.configprop.ConfigRandomProp;
import com.gxlm.springboot.web.controller.prop.configprop.ConfigStudentProp;
import com.gxlm.springboot.web.controller.prop.configprop.ConfigUserInfoProp;
import com.gxlm.springboot.web.controller.prop.staticprop.StaticRandomProp;
import com.gxlm.springboot.web.controller.prop.valueprop.RandomValueProp;
import com.gxlm.springboot.web.controller.prop.valueprop.StudentValueProp;
import com.gxlm.springboot.web.controller.prop.valueprop.UserInfoValueProp;

/**
 * Description 类描述: <br/>
 * 属性注入测试:
 * 1.SpringBoot的@ConfigurationProperties注解对象属性注入(com.gxlm.springboot.controller.prop.configprop包)
 * 2.Spring的@Value注解属性注入
 * 	(1).静态属性注入(com.gxlm.springboot.controller.prop.staticprop包)
 * 	(2).实例属性注入(com.gxlm.springboot.controller.prop.valueprop包)
 * 
 * 测试:
 * http://127.0.0.1:8080/config/fcmApps
 * http://127.0.0.1:8080/config/random
 * http://127.0.0.1:8080/config/student
 * http://127.0.0.1:8080/config/userInfo
 * http://127.0.0.1:8080/static/random
 * http://127.0.0.1:8080/value/random
 * http://127.0.0.1:8080/value/student
 * http://127.0.0.1:8080/value/userInfo
 * 
 * 1.关于SpringBoot提供的随机属性函数的随机性时机
 * 	需要说明的是SpringBoot的随机属性是在注入对象属性时按属性文件配置的随机属性要求随机分配值,
 * 即在Bean注入Spring容器时随机分配属性值,后面该对象的属性值就固定下来,除非将该类的设置为多例,
 * 那么在每次新获取这个Bean对象的值时,随机值才会不一样.也就固定下来了
 * 
 * 2.为何将Bean对象设置为多例(加@Scope("prototype")注解),在获取对象时属性值时仍然不改变?
 * 	将Bean对象设置为单例还不够,你还需要将调用该对象的Bean也设置为多例,否则调用该对象的Bean的引用的对象将固定不变
 * 自然获取的随机属性值也固定下来
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2019年7月16日 下午5:02:43
 */
@RestController
// @Scope("prototype")
public class PropController {
	@Autowired
	private ConfigFcmAppsProp configFcmAppsProp;
	@Autowired
	private ConfigRandomProp configRandomProp;
	@Autowired
	private ConfigStudentProp configStudentProp;
	@Autowired
	private ConfigUserInfoProp configUserInfoProp;
	@Autowired
	private StaticRandomProp staticRandomProp;
	@Autowired
	private RandomValueProp randomValueProp;
	@Autowired
	private StudentValueProp studentValueProp;
	@Autowired
	private UserInfoValueProp userInfoValueProp;

	/**
	 * ConfigurationProperties注解-集合对象属性注入
	 * 
	 * @author 立子
	 * @version 日期:2020年3月22日
	 * @return
	 */
	@RequestMapping(value = "config/fcmApps", method = RequestMethod.GET)
	public ConfigFcmAppsProp getFcmAppsProp() {
		return configFcmAppsProp;
	}
	
	/**
	 * ConfigurationProperties注解-随机对象属性注入
	 * 
	 * 随机属性注入测试
	 * 随机属性的值在初始化的时候载入,即只有Controller和属性注入类都是多例的情况下,每次的请求结果才是变化的
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "config/random", method = RequestMethod.GET)
	public ConfigRandomProp getConfigRandomProp() {
		return configRandomProp;
	}

	/**
	 * ConfigurationProperties注解-嵌套对象属性注入
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "config/student", method = RequestMethod.GET)
	public ConfigStudentProp getConfigStudentProp() {
		return configStudentProp;
	}

	/**
	 * ConfigurationProperties注解-POJO对象属性注入
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "config/userInfo", method = RequestMethod.GET)
	public ConfigUserInfoProp getConfigUserInfoProp() {
		return configUserInfoProp;
	}

	/**
	 * Value注解-随机静态属性注入
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "static/random", method = RequestMethod.GET)
	public StaticRandomProp getStaticRandomProp() {
		return staticRandomProp;
	}

	/**
	 * Value注解-随机实例属性注入
	 * ~"@Vlaue"注解配置在成员变量上 => 有效
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "value/random", method = RequestMethod.GET)
	public RandomValueProp getRandomValueProp() {
		return randomValueProp;
	}

	/**
	 * Value注解-嵌套实例属性注入
	 * ~"@Vlaue"注解配置在成员变量对应的getter方法上 => 无效,注入失败
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "value/student", method = RequestMethod.GET)
	public StudentValueProp getStudentValueProp() {
		return studentValueProp;
	}

	/**
	 * Value注解-POJO实例属性注入
	 * ~"@Vlaue"注解配置在成员变量对应的setter方法上 => 有效
	 * 
	 * @author 立子
	 * @version 日期:2019年12月13日
	 * @return
	 */
	@RequestMapping(value = "value/userInfo", method = RequestMethod.GET)
	public UserInfoValueProp getUserInfoValueProp() {
		return userInfoValueProp;
	}
	
}