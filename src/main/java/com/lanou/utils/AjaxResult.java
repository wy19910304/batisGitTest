package com.lanou.utils;

public class AjaxResult {
	
	private String msg;
	private String errorCode;
	private Object obj;
	
	public static AjaxResult ajaxResult(String msg, String errorCode, Object obj) {
		
		AjaxResult ajaxResult = new AjaxResult();
		ajaxResult.setErrorCode(errorCode);
		ajaxResult.setMsg(msg);
		ajaxResult.setObj(obj);
		return ajaxResult;		
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public Object getObj() {
		return obj;
	}

	public void setObj(Object obj) {
		this.obj = obj;
	}
	
	
	

}
