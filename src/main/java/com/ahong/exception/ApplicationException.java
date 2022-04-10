package com.ahong.exception;

/**
 * 编译时异常与运行时异常，自定义异常类实现运行时异常
 * catch后不使用e.printStackTrace()而使用logger
 */

public class ApplicationException extends RuntimeException {

	private Integer code;

	private String message;

	public ApplicationException(Integer code,String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	@Override
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}