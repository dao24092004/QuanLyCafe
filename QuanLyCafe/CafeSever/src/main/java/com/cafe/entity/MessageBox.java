package com.cafe.entity;

public class MessageBox {
	private int code;
	private String msg;

	public MessageBox() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MessageBox(int code, String msg) {
		super();
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
