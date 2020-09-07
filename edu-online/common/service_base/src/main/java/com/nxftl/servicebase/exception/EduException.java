package com.nxftl.servicebase.exception;

/**
 * @author darkltl
 * @Date 2020/8/31 13:25
 */
public class EduException extends RuntimeException{

	public EduException() {
		super();
	}

	public EduException(String message) {
		super(message);
	}

	public EduException(String message, Throwable cause) {
		super(message, cause);
	}

	public EduException(Throwable cause) {
		super(cause);
	}

	protected EduException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
