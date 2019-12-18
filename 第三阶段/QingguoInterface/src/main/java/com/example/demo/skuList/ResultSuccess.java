package com.example.demo.skuList;

import java.util.Map;

/**
 * @author 杨久鹏user
 *
 */
public class ResultSuccess {
	private int code;
	private String message;
	private Object result;


	public Object getresult() {
		return result;
	}

	public void setresult(Object result) {
		this.result = result;
	}

	public int getcode() {
		return code;
	}

	public void setcode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ResultSuccess(int code, String message,Object result) {
		super();
		this.code = code;
		this.message = message;
		this.result = result;
	}
//	public ResultSuccess(int code, String message,Map<Integer,Sku> result) {
//		super();
//		this.code = code;
//		this.message = message;
//		this.goods = result;
//	}
	
	@Override
	public String toString() {
		return "ResultSuccess [code=" + code + ", message=" + message + ", result=" + result + "]";
	}
	
}
