package org.kor.mv.modules.projectManage.dto;

import java.util.ArrayList;
import java.util.List;

import org.kor.mv.modules.common.dto.TableFiltersDataDTO;

public class ProjectTableFiltersDTO {
	
	private List<TableFiltersDataDTO> yearFilters;
	private List<TableFiltersDataDTO> goodsTypeFilters;
	private List<TableFiltersDataDTO> genderFilters;
	private List<TableFiltersDataDTO> winStatusFilters;
	private List<TableFiltersDataDTO> seasonFilters;
	private List<TableFiltersDataDTO> customerCompanyFilters;
	
	public ProjectTableFiltersDTO() {
		this.yearFilters = new ArrayList<TableFiltersDataDTO>();
		this.goodsTypeFilters = new ArrayList<TableFiltersDataDTO>();
		this.genderFilters = new ArrayList<TableFiltersDataDTO>();
		this.winStatusFilters = new ArrayList<TableFiltersDataDTO>();
		this.seasonFilters = new ArrayList<TableFiltersDataDTO>();
		this.customerCompanyFilters = new ArrayList<TableFiltersDataDTO>();
	}

	public List<TableFiltersDataDTO> getYearFilters() {
		return yearFilters;
	}

	public void setYearFilters(List<TableFiltersDataDTO> yearFilters) {
		this.yearFilters = yearFilters;
	}

	public List<TableFiltersDataDTO> getGoodsTypeFilters() {
		return goodsTypeFilters;
	}

	public void setGoodsTypeFilters(List<TableFiltersDataDTO> goodsTypeFilters) {
		this.goodsTypeFilters = goodsTypeFilters;
	}

	public List<TableFiltersDataDTO> getGenderFilters() {
		return genderFilters;
	}

	public void setGenderFilters(List<TableFiltersDataDTO> genderFilters) {
		this.genderFilters = genderFilters;
	}

	public List<TableFiltersDataDTO> getWinStatusFilters() {
		return winStatusFilters;
	}

	public void setWinStatusFilters(List<TableFiltersDataDTO> winStatusFilters) {
		this.winStatusFilters = winStatusFilters;
	}

	public List<TableFiltersDataDTO> getSeasonFilters() {
		return seasonFilters;
	}

	public void setSeasonFilters(List<TableFiltersDataDTO> seasonFilters) {
		this.seasonFilters = seasonFilters;
	}

	public List<TableFiltersDataDTO> getCustomerCompanyFilters() {
		return customerCompanyFilters;
	}

	public void setCustomerCompanyFilters(List<TableFiltersDataDTO> customerCompanyFilters) {
		this.customerCompanyFilters = customerCompanyFilters;
	}
}
