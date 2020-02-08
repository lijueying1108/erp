package org.kor.mv.dto;

public class ResponseErrorMessage extends BaseResponseMessage {

	private String errMsg;
	private String code;
	
	public ResponseErrorMessage() {
		super();
	}	
	public ResponseErrorMessage(String errMsg, String code) {
		super();
		this.errMsg = errMsg;
		this.code = code;
	}
	public String getErrMsg() {
		return errMsg;
	}
	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
