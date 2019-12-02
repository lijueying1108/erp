package org.kor.mv.dto;

import java.util.List;

import org.kor.mv.mybatis.pojo.SysPermission;

public class ActiveUser implements java.io.Serializable{

	private String id;
	private String usercode;
	private String username;
	
	private List<SysPermission> menus;	
	private List<SysPermission> permissions;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsercode() {
		return usercode;
	}
	public void setUsercode(String usercode) {
		this.usercode = usercode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<SysPermission> getMenus() {
		return menus;
	}
	public void setMenus(List<SysPermission> menus) {
		this.menus = menus;
	}
	public List<SysPermission> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<SysPermission> permissions) {
		this.permissions = permissions;
	}
}
