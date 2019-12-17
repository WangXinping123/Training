package com.example.demo.skuList;


public class ResultFail {
	private int code;
	private String message;
	
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

	public ResultFail(int code, String message) {
		super();
		this.code = code;
		this.message = message;
	}

	
	public ResultFail() {
		super();
	}

	@Override
	public String toString() {
		return "ResultFail [code=" + code + ", message=" + message + "]";
	}
	
}
