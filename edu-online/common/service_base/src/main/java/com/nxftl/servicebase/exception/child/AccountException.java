package com.nxftl.servicebase.exception.child;

import com.nxftl.servicebase.exception.EduException;

import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author darkltl
 * @Date 2020/8/31 13:27
 */
public class AccountException extends EduException {

	public AccountException() {
		super();
	}

	public AccountException(String message) {
		super(message);
	}

	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}

	public AccountException(Throwable cause) {
		super(cause);
	}

	protected AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
