package org.kor.mv.modules.projectManage.dto;

import java.util.Date;

import org.kor.mv.modules.projectManage.Entity.ProjectNameEntity;
import org.springframework.format.annotation.DateTimeFormat;

public class ProjectNewGenerDTO extends ProjectNameEntity{
	
	private String businEmp;
	private String businDepartTeam;
	private String designEmp;
	private String productEmp;
	private String distrEmp;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date takeProjectStateDate;
	@DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date goodsEvaluStartDate;
	
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
	public Date getTakeProjectStateDate() {
		return takeProjectStateDate;
	}
	public void setTakeProjectStateDate(Date takeProjectStateDate) {
		this.takeProjectStateDate = takeProjectStateDate;
	}
	public Date getGoodsEvaluStartDate() {
		return goodsEvaluStartDate;
	}
	public void setGoodsEvaluStartDate(Date goodsEvaluStartDate) {
		this.goodsEvaluStartDate = goodsEvaluStartDate;
	}
}
