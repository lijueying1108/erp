package org.kor.mv.exception;

public class PageInterviewException extends Exception {

	private String message;
	
	public PageInterviewException(String message) {
		super(message);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
