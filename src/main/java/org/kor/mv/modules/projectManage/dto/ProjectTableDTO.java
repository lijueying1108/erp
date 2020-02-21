package org.kor.mv.modules.projectManage.dto;

import org.kor.mv.modules.projectManage.Entity.ProjectNameEntity;

public class ProjectTableDTO extends ProjectNameEntity {
	
	private String key;
	private String busiDepartTeamName;
	
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}

	public String getBusiDepartName() {
		return busiDepartTeamName;
	}
	public void setBusiDepartTeamName(String busiDepartTeamName) {
		this.busiDepartTeamName = busiDepartTeamName;
	}
}
