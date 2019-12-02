package org.kor.mv.dto;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

public class UserLoginDTO {
	
	@NotEmpty(message="{user.login.id.isNULL}")
	@Length(min=2,max=8,message="{user.login.id.length}")
	private String username;
	
	@NotEmpty(message="{user.login.passwd.isNULL}")
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
