package org.kor.mv.modules.projectManage.dto;

import java.util.ArrayList;
import java.util.List;

public class ProjectCodeListDTO {

	private List<ProjectCodeDTO> yearcode;
	private List<ProjectCodeDTO> customerClassificationcode;
	private List<ProjectCodeDTO> customercode;
	private List<ProjectCodeDTO> gendercode;
	private List<ProjectCodeDTO> seasoncode;
	private List<ProjectCodeDTO> goodsTypecode;
	private List<ProjectCodeDTO> winStatuscode;
	
	public ProjectCodeListDTO() {
		this.yearcode = new ArrayList<ProjectCodeDTO>();
		this.customerClassificationcode = new ArrayList<ProjectCodeDTO>();
		this.customercode = new ArrayList<ProjectCodeDTO>();
		this.gendercode = new ArrayList<ProjectCodeDTO>();
		this.seasoncode = new ArrayList<ProjectCodeDTO>();
		this.goodsTypecode = new ArrayList<ProjectCodeDTO>();
		this.winStatuscode = new ArrayList<ProjectCodeDTO>();
	}
	public List<ProjectCodeDTO> getYearcode() {
		return yearcode;
	}
	public void setYearcode(List<ProjectCodeDTO> yearcode) {
		this.yearcode = yearcode;
	}
	public List<ProjectCodeDTO> getCustomerClassificationcode() {
		return customerClassificationcode;
	}
	public void setCustomerClassificationcode(List<ProjectCodeDTO> customerClassificationcode) {
		this.customerClassificationcode = customerClassificationcode;
	}
	public List<ProjectCodeDTO> getCustomercode() {
		return customercode;
	}
	public void setCustomercode(List<ProjectCodeDTO> customercode) {
		this.customercode = customercode;
	}
	public List<ProjectCodeDTO> getGendercode() {
		return gendercode;
	}
	public void setGendercode(List<ProjectCodeDTO> gendercode) {
		this.gendercode = gendercode;
	}
	public List<ProjectCodeDTO> getSeasoncode() {
		return seasoncode;
	}
	public void setSeasoncode(List<ProjectCodeDTO> seasoncode) {
		this.seasoncode = seasoncode;
	}
	public List<ProjectCodeDTO> getGoodsTypecode() {
		return goodsTypecode;
	}
	public void setGoodsTypecode(List<ProjectCodeDTO> goodsTypecode) {
		this.goodsTypecode = goodsTypecode;
	}
	public List<ProjectCodeDTO> getWinStatuscode() {
		return winStatuscode;
	}
	public void setWinStatuscode(List<ProjectCodeDTO> winStatuscode) {
		this.winStatuscode = winStatuscode;
	}
}
