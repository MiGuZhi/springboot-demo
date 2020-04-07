package com.gxlm.springboot.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.gxlm.module.servlet.WebUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.gxlm.springboot.common.Result;
import com.gxlm.springboot.common.constant.Consts;
import com.gxlm.springboot.common.enums.State;

/**
 * Description 类描述:
 * <br/> 统一异常处理
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年6月21日 下午5:00:34
 */
//@Component
public class ExceptionHandler implements HandlerExceptionResolver {
  
  private Logger logger = LoggerFactory.getLogger(getClass());

  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
    // 打印日志信息,在处理异常
    StringBuilder builder = new StringBuilder("【统一异常】请求信息: \n");
    String requestPath = WebUtil.getRequestPath(request);
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
    builder.append("------------------异常信息--------------------");
    logger.warn(new String(builder), ex);
    Result result = new Result(State.ERROR);
    try {
		WebUtil.responseToJson(response, JSON.toJSONString(result));
	} catch (IOException e) {
		e.printStackTrace();
	}
    return null;
  }

}

