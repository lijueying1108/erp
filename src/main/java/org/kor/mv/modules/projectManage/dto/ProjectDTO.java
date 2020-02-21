package org.kor.mv.modules.projectManage.dto;

import java.util.Date;
import java.util.List;

import org.kor.mv.modules.projectManage.Entity.ProjectItemsInfoEntity;
import org.kor.mv.modules.projectManage.Entity.ProjectNameEntity;
import org.springframework.format.annotation.DateTimeFormat;

public class ProjectDTO {
	
	private String projectNameCode;
	private ProjectNameEntity projectName;
	private String businEmp;
	private String businDepartTeam;
	private String designEmp;
	private String productEmp;
	private String distrEmp;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date takeProjectStateDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date goodsEvaluStartDate;
	private List<ProjectItemsInfoEntity> projectItemList;
	
	public String getProjectNameCode() {
		return projectNameCode;
	}
	public void setProjectNameCode(String projectNameCode) {
		this.projectNameCode = projectNameCode;
	}
	public ProjectNameEntity getProjectName() {
		return projectName;
	}
	public void setProjectName(ProjectNameEntity projectName) {
		this.projectName = projectName;
	}
	public String getBusinEmp() {
		return businEmp;
	}
	public void setBusinEmp(String businEmp) {
		this.businEmp = businEmp;
	}
	public String getBusinDepartTeam() {
		return businDepartTeam;
	}
	public void setBusinDepartTeam(String businDepartTeam) {
		this.businDepartTeam = businDepartTeam;
	}
	public String getDesignEmp() {
		return designEmp;
	}
	public void setDesignEmp(String designEmp) {
		this.designEmp = designEmp;
	}
	public String getProductEmp() {
		return productEmp;
	}
	public void setProductEmp(String productEmp) {
		this.productEmp = productEmp;
	}
	public String getDistrEmp() {
		return distrEmp;
	}
	public void setDistrEmp(String distrEmp) {
		this.distrEmp = distrEmp;
	}
	public List<ProjectItemsInfoEntity> getProjectItemList() {
		return projectItemList;
	}
	public void setProjectItemList(List<ProjectItemsInfoEntity> projectItemList) {
		this.projectItemList = projectItemList;
	} 
}
