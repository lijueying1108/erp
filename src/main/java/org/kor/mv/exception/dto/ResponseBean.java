package org.kor.mv.exception.dto;

public class ResponseBean {

	private String code;
	
	private String msg;
	
	private Object data;

	private boolean status;
	
	public ResponseBean() {}
	
	public ResponseBean(String code, String msg, Object data, boolean status) {
		this.code = code;
		this.msg = msg;
		this.data = data;
		this.status = status;
	}
	
	public ResponseBean(String code, String msg, boolean status) {
		this.code = code;
		this.msg = msg;
		this.status = status;
	}
	
	public ResponseBean(String code, Object data) {
		this.code = code;
		if(data != null) {
			this.msg = "sucess";
			this.status = true;
		} else {
			this.msg = "failed";
			this.status = false;
		}		
		this.data = data;
	}
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	
}
