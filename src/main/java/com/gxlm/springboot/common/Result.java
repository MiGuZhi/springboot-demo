package com.gxlm.springboot.common;

import java.util.HashMap;
import java.util.Map;

import org.gxlm.core.util.CollectionUtil;

import com.gxlm.springboot.common.enums.State;

/**
 * Description 类描述:
 * <br/>
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2018年6月21日 下午3:57:11
 */
public class Result {

	private int code;

	private String info;

	private Object result;
	
	public Result() {}
	
	public Result(State state) {
		this.code = state.getCode();
		this.info = state.getInfo();
	}
	
	public Result(State state, String info) {
		this.code = state.getCode();
		this.info = info;
	}
	
	public Result(Object obj, State state) {
		this(state);
		this.result = obj;
	}
	
	public Result(Object obj, State state, String info) {
		this(state, info);
		this.result = obj;
	}
	
	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	
	public void addStringKeyValue(Object... objs) {
		if (CollectionUtil.isEmpty(objs))
			return;
		Map<String, Object> res = new HashMap<>();
		for (int i = 1; i < objs.length;) {
			Object obj = objs[i -1];
			if (obj == null) {
				i += 2;
				continue;
			}
			res.put(obj.toString(), objs[i]);
			i += 2;
		}
		this.result = res;
	}
	
}

