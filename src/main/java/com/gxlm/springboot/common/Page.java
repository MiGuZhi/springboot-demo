package com.gxlm.springboot.common;

import java.util.List;

import org.gxlm.core.util.NumberUtil;

/**
 * Description 类描述: 
 * <br/> 分页工具类
 * 
 * @author 立子 E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2017年1月3日 下午12:35:46
 */
public class Page<T> {

	/** 首页 */
	private int firstPage = 1;
	/** 上一页 */
	private int perPage = 1;
	/** 下一页 */
	private int nextPage = 1;
	/** 尾页 */
	private int lastPage = 1;
	/** 当前页 */
	private int pageNo = 1;
	/** 每页显示多少条 */
	private int pageSize = 10;
	/** 总页数 */
	private int pageCount = 1;
	/** 总记录数 */
	private int rowCount = 0;
	/** 分页查询结果集 */
	private List<T> list;
	/** 搜索起始位置 */
	private int startIndex = 1;

	/**
	 * 传入当前页页码
	 * 
	 * @author 立子
	 * @version 日期:2019年1月4日
	 * @param pageNo
	 */
	public Page(Integer pageNo) {
		if (NumberUtil.isPositiveNumber(pageNo))
			this.pageNo = pageNo.intValue();
		startIndex = this.pageSize * (this.pageNo - 1);
	}

	/**
	 * 传入页码和数量
	 * 
	 * @author 立子
	 * @version 日期:2019年1月4日
	 * @param pageNo 当前页页码
	 * @param pageSize 每页显示条数
	 */
	public Page(Integer pageNo, Integer pageSize) {
		if (NumberUtil.isPositiveNumber(pageNo))
			this.pageNo = pageNo.intValue();
		if (NumberUtil.isPositiveNumber(pageSize))
			this.pageSize = pageSize.intValue();
		startIndex = this.pageSize * (this.pageNo - 1);
	}

	/**
	 * 存入结果集
	 * 
	 * @author 立子
	 * @version 日期:2019年1月4日
	 * @param rowCount 结果集总条数
	 * @param list 查询的结果集
	 */
	public void saveResult(int rowCount, List<T> list) {
		setRowCount(rowCount);
		this.list = list;
	}

	public int getFirstPage() {
		return firstPage;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	public int getPerPage() {
		return perPage;
	}

	public void setPerPage(int perPage) {
		this.perPage = perPage;
	}

	public int getNextPage() {
		return nextPage;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageCount() {
		return pageCount;
	}

	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}

	public int getRowCount() {
		return rowCount;
	}

	/**
	 * 设置rowCount并计算其他相关页码数据
	 * 
	 * @author 立子
	 * @version 日期:2018年7月19日
	 * @param rowCount
	 */
	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
		// 计算总页数
		this.pageCount = rowCount / pageSize;
		if (rowCount % pageSize > 0)
			this.pageCount = this.pageCount + 1;
		// 尾页
		lastPage = this.pageCount;
		// 上一页(默认值是1)
		if (pageNo > 1)
			perPage = pageNo - 1;
		// 下一页
		nextPage = pageNo < lastPage ? pageNo + 1 : lastPage;
	}

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}

	public int getStartIndex() {
		return startIndex;
	}

	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}

}
