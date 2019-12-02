package org.kor.mv.mybatis.pojo;

public class SysRolePermission {

	private String id;

	private String sysRoleId;

	private Integer sysPermissionId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id == null ? null : id.trim();
	}

	public String getSysRoleId() {
		return sysRoleId;
	}

	public void setSysRoleId(String sysRoleId) {
		this.sysRoleId = sysRoleId == null ? null : sysRoleId.trim();
	}

	public Integer getSysPermissionId() {
		return sysPermissionId;
	}

	public void setSysPermissionId(Integer sysPermissionId) {
		this.sysPermissionId = sysPermissionId;
	}
}