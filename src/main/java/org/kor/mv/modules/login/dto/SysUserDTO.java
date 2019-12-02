package org.kor.mv.modules.login.dto;

import org.kor.mv.mybatis.pojo.SysUser;

public class SysUserDTO extends SysUser{
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
