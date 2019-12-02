package org.kor.mv.util;

public enum ResponseCodeUtil {
	
	NULL_OBJ("search001","Object is null"),
	
	ERROR_ADD("err001","Failed to add"),
	
	ERROR_EXCEPTION("err002","Exception"),
	
	ERROR_INSERT_EXIST("err003","Inserting Object exists"),
	
	ERROR_FORM("err004","FOMR IS EMPTY"),
	
	SUCCESS("succ888","Success");
	
	private String code;
    private String message;
    
    private ResponseCodeUtil(String code, String message) {
    	this.code = code;
    	this.message = message;
    }
    
    public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
