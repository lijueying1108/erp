package org.kor.mv.dto;

import java.util.ArrayList;
import java.util.List;

public class ResponseSuccessMessage extends BaseResponseMessage {

	private String code;

	private String successMsg;
	
	private Object data;
	

	public ResponseSuccessMessage() {
		super();
		this.data = new ArrayList<Object>();
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSuccessMsg() {
		return successMsg;
	}

	public void setSuccessMsg(String successMsg) {
		this.successMsg = successMsg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
}
