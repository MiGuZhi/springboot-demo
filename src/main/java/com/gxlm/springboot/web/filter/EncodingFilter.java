package com.gxlm.springboot.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.gxlm.springboot.common.constant.Consts;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2020年3月22日 下午5:40:18
 */
@Component
@WebFilter(urlPatterns = "/", filterName = "EncodingFilter")
public class EncodingFilter implements Filter {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		Filter.super.init(filterConfig);
	}
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
	        throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest)req;
	    HttpServletResponse response = (HttpServletResponse)res;
	    //设置全局字符
	    request.setCharacterEncoding(Consts.DEFAULT_ENCODING);
	    response.setCharacterEncoding(Consts.DEFAULT_ENCODING);
	    //基础目录, 如果是单ip,那么只需要获取一次就够了.多ip时可以这样写
	    String basePath = getBasePath(request);
	    String viewPath = getViewPath(request);
	    request.setAttribute("basePath", basePath);
	    request.setAttribute("viewPath", viewPath);
	    // 打印Cookie
	    logger.info("【EncodingFilter】TS 当前正在请求的URI:" + request.getRequestURI());
		chain.doFilter(request, response);
	}
	
	/**
	   * 获取项目根目录
	   * 
	   * @author 立子
	   * @version 日期:2017年4月24日
	   * @param request
	   * @return
	   */
	  private String getBasePath(HttpServletRequest request) {
	    StringBuilder path = new StringBuilder();
	    String scheme = request.getScheme(); // 协议
	    String serverName = request.getServerName(); // 主机名或域名
	    int serverPort = request.getServerPort(); // 端口号
	    String contextPath = request.getContextPath(); // 项目名称
	    path.append(scheme);
	    path.append("://");
	    path.append(serverName);
	    path.append(":");
	    path.append(serverPort);
	    path.append(contextPath);
	    path.append("/");
	    return path.toString();
	  }
	  
	  /**
	   * 获取真实访问路径
	   * 
	   * @author 立子
	   * @version 日期:2017年5月18日
	   * @param request
	   * @return
	   */
	  private String getViewPath(HttpServletRequest request) {
	    //工程名称字符(包括斜杠)长度
	    int projectNameLength = request.getContextPath().length() + 1;
	    //去除公共访问路径后剩余的访问路径
	    String viewPath = request.getRequestURI().substring(projectNameLength);
	    return viewPath;
	  }

}

