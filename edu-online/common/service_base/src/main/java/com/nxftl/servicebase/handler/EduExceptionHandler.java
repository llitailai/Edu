package com.nxftl.servicebase.handler;

import com.nxftl.commonutils.result.Res;
import com.nxftl.servicebase.exception.EduException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author darkltl
 * @Date 2020/8/31 13:18
 */
@ControllerAdvice
public class EduExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(EduExceptionHandler.class);

	/**
	 * 指定异常出现
	 * @param e
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public Res errorException(Exception e){
		e.printStackTrace();
		return Res.error();
	}

	/**
	 * 自定义异常处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(EduException.class)
	@ResponseBody
	public Res otherException(EduException ex){
		ex.printStackTrace();
		return Res.error();
	}

}
