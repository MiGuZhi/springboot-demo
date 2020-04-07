package com.gxlm.springboot.web;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.gxlm.core.util.CollectionUtil;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

/**
 * Description 类描述: <br/>
 * 获取Spring ICO容器实例 针对new 出来的对象想使用IOC管理的对象
 * 
 * 这个工具确实有些矛盾,但可用.
 * 
 * 也可以使用自动装载来装载需要的Spring对象
 * org.springframework.beans.factory.config.AutowireCapableBeanFactory 这个工具类即可
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2017年6月2日 下午2:11:36
 */
@Component
public class SpringUtil implements ApplicationContextAware {

	private static ApplicationContext applicationContext;

	// private static Logger logger = Logger.getLogger(SpringUtil.class);

	private SpringUtil() {}

	/**
	 * 设置容器实例
	 * 
	 * @Override
	 * @author 立子
	 * @version 日期:2017年8月26日
	 * @param appContext
	 * @throws BeansException
	 */
	@Override
	public void setApplicationContext(ApplicationContext appContext) throws BeansException {
		SpringUtil.applicationContext = appContext;
	}

	/**
	 * 获取bean实体类
	 * 
	 * @author 立子
	 * @version 日期:2017年8月26日
	 * @param clazz
	 * @return
	 */
	public static <T> T getBean(Class<T> clazz) {
		return applicationContext.getBean(clazz);
	}

	/**
	 * 获取参数
	 * 
	 * @author 立子
	 * @version 日期:2017年6月5日
	 * @param beanName
	 * @return
	 */
	public static Object getBean(String beanName) {
		return applicationContext.getBean(beanName);
	}

	/**
	 * 根据Class类型在IOC容器中获取对象
	 * 
	 * @param clazz Class类型
	 * @return 对象
	 */
	@SuppressWarnings("unchecked")
	public static <T> List<T> getBeanByType(Class<T> clazz) {
		List<T> list = new ArrayList<T>();
		/* 获取接口的所有实例名 */
		String[] beanNames = applicationContext.getBeanNamesForType(clazz);
		System.out.println("getBeanByType beanNames : " + beanNames == null ? "" : Arrays.toString(beanNames));
		if (beanNames == null || beanNames.length == 0)
			return list;
		T t = null;
		for (String beanName : beanNames) {
			t = (T) applicationContext.getBean(beanName);
			list.add(t);
		}
		return list;
	}

	/**
	 * 获取请求处理方法
	 * 
	 * @author 立子
	 * @version 日期:2019年1月4日
	 * @param handler
	 * @return
	 */
	public static String getHandlerMethod(HandlerMethod handler) {
		StringBuilder builder = new StringBuilder();
		// 类名
		builder.append(handler.getBeanType().getName()).append(".");
		// 方法名
		builder.append(handler.getMethod().getName()).append("(");
		MethodParameter[] params = handler.getMethodParameters();
		for (MethodParameter par : params) {
			builder.append(par.getParameterType().getSimpleName()).append(" ");
			builder.append(par.getParameterName()).append(", ");
		}
		if (CollectionUtil.isEmpty(params))
			return builder + ")";
		String res = new String(builder);
		res = res.substring(0, res.length() - 2);
		return res + ")";
	}

}
