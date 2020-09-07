package com.nxftl.commonutils.result;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NonNull;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 统一返回对象
 * @author darkltl
 */
@Data
public class Res<T> {
	@ApiModelProperty(value = "是否成功")
	private Boolean success;

	@ApiModelProperty(value = "返回码")
	private Integer code;

	@ApiModelProperty(value = "返回消息")
	private String message;

	@ApiModelProperty(value = "返回数据 Map形式")
	private T data ;

	private Res(){}

	/**
	 * 成功
	 * @return
	 */
	public static Res success(){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(ResultMessage.RETURN_SUCCESS_MESSAGE);
		result.setCode(ResultCode.SUCCESS);
		return result;
	}

	/**
	 * 自定义返回状态码 -> 成功
	 * @param code
	 * @return
	 */
	public static Res success(@NonNull Integer code){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(ResultMessage.RETURN_SUCCESS_MESSAGE);
		result.setCode(code);
		return result;
	}

	/**
	 * 自定义返回信息 -> 成功
	 * @param message
	 * @return
	 */
	public static Res success(@NonNull String message){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(message);
		result.setCode(ResultCode.SUCCESS);
		return result;
	}

	/**
	 * 自定义返回状态码 信息 -> 成功
	 * @param code
	 * @param message
	 * @return
	 */
	public static Res success(@NonNull Integer code,@NonNull String message){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(message);
		result.setCode(code);
		return result;
	}

	/**
	 * 携带数据 -> 成功
	 * @param data
	 * @return
	 */
	public static Res success(Object data){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(ResultMessage.RETURN_SUCCESS_MESSAGE);
		result.setCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	/**
	 * 自定义状态码并携带数据 -> 成功
	 * @param data
	 * @param code
	 * @return
	 */
	public static Res success(Object data,@NonNull Integer code){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(ResultMessage.RETURN_SUCCESS_MESSAGE);
		result.setCode(code);
		result.setData(data);
		return result;
	}

	/**
	 * 自定义响应信息并携带数据 -> 成功
	 * @param data
	 * @param message
	 * @return
	 */
	public static Res success(Object data,@NonNull String message){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(message);
		result.setCode(ResultCode.SUCCESS);
		result.setData(data);
		return result;
	}

	/**
	 * 自定义返回结果并携带数据 -> 成功
	 * @param data
	 * @param message
	 * @param code
	 * @return
	 */
	public static Res success(Object data,@NonNull String message ,@NonNull Integer code){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_SUCCESS);
		result.setMessage(message);
		result.setCode(code);
		result.setData(data);
		return result;
	}

	/**
	 * 错误相应
	 * @return
	 */
	public static Res error(){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_ERROR);
		result.setMessage(ResultMessage.RETURN_ERROR_MESSAGE);
		result.setCode(ResultCode.ERROR);
		return result;
	}

	/**
	 * 自定义返回状态码 -> 失败
	 * @param code
	 * @return
	 */
	public static Res error(@NonNull Integer code){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_ERROR);
		result.setMessage(ResultMessage.RETURN_ERROR_MESSAGE);
		result.setCode(code);
		return result;
	}

	/**
	 * 自定义返回信息 -> 失败
	 * @param message
	 * @return
	 */
	public static Res error(@NonNull String message){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_ERROR);
		result.setMessage(message);
		result.setCode(ResultCode.ERROR);
		return result;
	}

	/**
	 * 自定义返回状态码 信息 -> 失败
	 * @param code
	 * @param message
	 * @return
	 */
	public static Res error(@NonNull Integer code,@NonNull String message){
		Res result = new Res();
		result.setSuccess(ResultMessage.IS_ERROR);
		result.setMessage(message);
		result.setCode(code);
		return result;
	}


}
