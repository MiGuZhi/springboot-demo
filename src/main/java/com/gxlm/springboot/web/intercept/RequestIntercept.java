package com.gxlm.springboot.web.intercept;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gxlm.module.servlet.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.gxlm.springboot.common.constant.Consts;
import com.gxlm.springboot.web.SpringUtil;

/**
 * Description 类描述:
 * <br/> 请求拦截器
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年5月14日 下午6:38:38
 */
public class RequestIntercept implements HandlerInterceptor {
//	@Autowired
//	private SysPermissionBo sysPermissionBoImpl;
	private Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 输出请求信息
	 * 
	 * @author 立子
	 * @version 日期:2018年6月6日
	 * @param request
	 * @param response
	 * @param handler
	 */
	private void printRequestInfo(HttpServletRequest request, HttpServletResponse response, Object handler) {
		// 打印日志信息,在处理异常
	    StringBuilder builder = new StringBuilder("【请求拦截器】请求信息: \n");
	    String requestPath = request.getAttribute(Consts.REQUIRE_PATH).toString();
	    builder.append("请求地址：").append(requestPath).append("\n");
	    // 获取请求处理方法相关信息
	    if (handler != null && handler instanceof HandlerMethod) {
	      HandlerMethod handlerMethod = (HandlerMethod)handler;
	      String methodMsg = SpringUtil.getHandlerMethod(handlerMethod);
	      builder.append("请求处理方法：").append(methodMsg).append("\n");
	    }
	    builder.append("请求参数：").append(WebUtil.getRequestParam(request)).append("\n");
	    // 拿不到就是故意隐藏
	    builder.append("请求ip：").append(WebUtil.getRequestIp(request)).append("\n");
	    // 可能为空,通常不为空
	    builder.append("userAgent：").append(request.getHeader("user-agent")).append("\n");
	    // accept 可能为空
	    builder.append("accept：").append(request.getHeader("accept")).append("\n");
	    // content-type 可能为空
	    builder.append("contentType：").append(request.getHeader("content-type")).append("\n");
	    //获取用户信息
	    Object obj = WebUtil.getSessionAttribute(request, Consts.USER_INFO_SESSION);
	    if (obj != null)
	    	builder.append("请求用户id：").append(obj).append("\n");
	    logger.info(builder.toString());
	}
	
	/**
	 * 后台请求管理
	 * 
	 * @author 立子
	 * @version 日期:2018年7月20日
	 * @param basePath
	 * @param request
	 * @param response
	 * @return
	 * @throws IOException
	 */
//	private boolean adminIntercept(String viewPath, String basePath, HttpServletRequest request, HttpServletResponse response) throws IOException {
//		Object obj = WebUtil.getSessionAttribute(request, Consts.ADMIN_MANAGE_USER_SESSION);
//		//未登录
//		if (obj == null) {
//			if (WebUtil.isAjaxRequest(request))
//				WebUtil.responseToJson(response, JSON.toJSONString(new Result(State.OFF_LINE, "用户未登录,请登录!"))); // 提示未登录
//			else
//				response.sendRedirect(StringUtil.join(basePath, "index.jsp")); // 重定向到首页
//			logger.debug(StringUtil.join("【RequestIntercept】请求地址:", viewPath, "[未登录]用户未登录,已拦截..."));
//			return false;
//		}
//		//管理页面不接受ajax类的请求
//		if (viewPath.endsWith("sys/manage.do")) {
//			if (WebUtil.isAjaxRequest(request)) {
//				WebUtil.responseToJson(response, JSON.toJSONString(new Result(State.WARNING, "请使用浏览器打开"))); //页面请求
//				logger.debug(StringUtil.join("【RequestIntercept】请求地址:", viewPath, "[客户端错误]用户没有使用浏览器打开,已拦截..."));
//				return false;
//			}
//			return true;
//		}
//		//登录放开的公共页面请求
//		if (viewPath.endsWith("sys/noPermission.do"))
//			return true;
//		SysUserInfoBean requestUser =  (SysUserInfoBean)obj;
//		//超级管理员权限放开,不做校验
//		if (requestUser.getRoleType().intValue() == 0)
//			return true;
//		//权限校验
//		Set<Long> permissions = requestUser.getPremissionIds();
//		if (CollectionUtil.isEmpty(permissions)) {
//			if (WebUtil.isAjaxRequest(request))
//				WebUtil.responseToJson(response, JSON.toJSONString(new Result(State.NO_PERMISSION, "用户没有权限!"))); // 无权限
//			else
//				response.sendRedirect(StringUtil.join(basePath, "sys/noPermission.do")); // 重定向无权限
//			logger.debug(StringUtil.join("【RequestIntercept】请求地址:", viewPath, "[无权限]用户没有权限,已拦截..."));
//			return false;
//		}
//		PermissionBean permission = sysPermissionBoImpl.getPermissionByUri(viewPath);
//		if (permissions.contains(permission.getId()))
//			return true;
//		if (CollectionUtil.isEmpty(permissions)) {
//			if (WebUtil.isAjaxRequest(request))
//				WebUtil.responseToJson(response, JSON.toJSONString(new Result(State.NO_PERMISSION, "权限不足,请联系管理员分配权限!"))); // 无权限
//			else
//				response.sendRedirect(StringUtil.join(basePath, "WEB-INF/pages/sys/pression/no_permission.jsp")); // 重定向无权限
//			logger.debug(StringUtil.join("【RequestIntercept】请求地址:", viewPath, "[权限不足]用户没有这个权限,已拦截..."));
//			return false;
//		}
//		return true;
//	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		String basePath = WebUtil.getBasePath(request);
		String viewPath = WebUtil.getRequestPath(request);
		request.setAttribute(Consts.BASE_PATH, basePath);
		request.setAttribute(Consts.REQUIRE_PATH, viewPath);
		//输出打印请求信息
		printRequestInfo(request, response, handler);
		return true;
//		return adminIntercept(viewPath, basePath, request, response);
	}
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView model)
			throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception e)
			throws Exception {
	}

}

