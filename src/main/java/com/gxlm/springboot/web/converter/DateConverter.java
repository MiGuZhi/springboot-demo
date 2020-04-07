package com.gxlm.springboot.web.converter;

import java.util.Date;

import org.gxlm.core.common.enums.FormatDate;
import org.gxlm.core.util.DateUtil;
import org.gxlm.core.util.StringUtil;
import org.springframework.core.convert.converter.Converter;

/**
 * Description 类描述:
 * <br/> 日期转换器
 * 
 * @author 立子  E-mail: lingxiao.6540@foxmail.com
 * @version 创建时间：2017年8月23日 下午12:55:22
 */
public class DateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		String dateStr = StringUtil.trim(source);
		if (StringUtil.isBlank(dateStr))
			return null;
		if (dateStr.matches("^\\d{4}-\\d{1,2}$"))
			return DateUtil.toDate(dateStr, FormatDate.MONTH);
		else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2}$"))
			return DateUtil.toDate(dateStr, FormatDate.DAY);
		else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}$"))
			return DateUtil.toDate(dateStr, FormatDate.MINUTE);
		else if (dateStr.matches("^\\d{4}-\\d{1,2}-\\d{1,2} {1}\\d{1,2}:\\d{1,2}:\\d{1,2}$"))
			return DateUtil.toDate(dateStr, FormatDate.SECOND);
		else
			throw new IllegalArgumentException("Invalid boolean value '" + source + "'");
	}

}
