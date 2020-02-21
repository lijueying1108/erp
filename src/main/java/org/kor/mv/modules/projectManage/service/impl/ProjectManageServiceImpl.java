package org.kor.mv.modules.projectManage.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.kor.mv.modules.common.dto.TableFiltersDataDTO;
import org.kor.mv.modules.projectManage.dto.ProjectCodeDTO;
import org.kor.mv.modules.projectManage.dto.ProjectCodeListDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableFiltersDTO;
import org.kor.mv.modules.projectManage.service.ProjectManageService;
import org.kor.mv.modules.projectManage.vo.ProjectTableVO;
import org.kor.mv.mybatis.mapper.ProjectDAOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectManageServiceImpl implements ProjectManageService {

	@Autowired
	private ProjectDAOMapper projectDAOMapper;
	
	public List<ProjectTableDTO>  selectProjectTableData(ProjectTableVO projectTableVO) {
		// TODO Auto-generated method stub		
		List<ProjectTableDTO> projectTableDTOList = new ArrayList<ProjectTableDTO>();
		System.out.print(projectTableVO.getSeason());
		projectTableDTOList = projectDAOMapper.selectProjectTableData(projectTableVO);
		return projectTableDTOList;
	}

	public ProjectTableFiltersDTO selectProjectTableFiltersData(ProjectTableVO projectTableVO) {
		// TODO Auto-generated method stub
		ProjectTableFiltersDTO projectTableFiltersDTO = new ProjectTableFiltersDTO();
		
		//year filters data
		List<String> yearFiltersList = new ArrayList<String>();
		List<TableFiltersDataDTO> yearFilters = new ArrayList<TableFiltersDataDTO>();
		
		yearFiltersList = projectDAOMapper.selectProjectTableYearFiltersData(projectTableVO);
		for(String str:yearFiltersList) {
			TableFiltersDataDTO tableFiltersDataDTO = new TableFiltersDataDTO();
			tableFiltersDataDTO.setText(str);
			tableFiltersDataDTO.setValue(str);
			yearFilters.add(tableFiltersDataDTO);
		}
		//season filters data
		List<String> seasonFiltersList = new ArrayList<String>();
		List<TableFiltersDataDTO> seasonFilters = new ArrayList<TableFiltersDataDTO>();
		seasonFiltersList = projectDAOMapper.selectProjectTableSeasonFiltersData(projectTableVO);
		for(String str:seasonFiltersList) {
			TableFiltersDataDTO tableFiltersDataDTO = new TableFiltersDataDTO();
			tableFiltersDataDTO.setText(str);
			tableFiltersDataDTO.setValue(str);
			seasonFilters.add(tableFiltersDataDTO);
		}
		//winStatus filters data
		List<String> winStatusFiltersList = new ArrayList<String>();
		List<TableFiltersDataDTO> winStatusFilters = new ArrayList<TableFiltersDataDTO>();

		winStatusFiltersList = projectDAOMapper.selectProjectTableWinStatusFiltersData(projectTableVO);
		for(String str:winStatusFiltersList) {
			TableFiltersDataDTO tableFiltersDataDTO = new TableFiltersDataDTO();
			tableFiltersDataDTO.setText(str);
			tableFiltersDataDTO.setValue(str);
			winStatusFilters.add(tableFiltersDataDTO);
		}
		//gender filters data
		List<String> genderFiltersList = new ArrayList<String>();
		List<TableFiltersDataDTO> genderFilters = new ArrayList<TableFiltersDataDTO>();
		genderFiltersList = projectDAOMapper.selectProjectTableGenderFiltersData(projectTableVO);
		for(String str:genderFiltersList) {
			TableFiltersDataDTO tableFiltersDataDTO = new TableFiltersDataDTO();
			tableFiltersDataDTO.setText(str);
			tableFiltersDataDTO.setValue(str);
			genderFilters.add(tableFiltersDataDTO);
		}
		//goodsType filters data
		List<String> goodsTypeFiltersList = new ArrayList<String>();
		List<TableFiltersDataDTO> goodsTypeFilters = new ArrayList<TableFiltersDataDTO>();
		goodsTypeFiltersList = projectDAOMapper.selectProjectTableGoodsTypeFiltersData(projectTableVO);
		for(String str:goodsTypeFiltersList) {
			TableFiltersDataDTO tableFiltersDataDTO = new TableFiltersDataDTO();
			tableFiltersDataDTO.setText(str);
			tableFiltersDataDTO.setValue(str);
			goodsTypeFilters.add(tableFiltersDataDTO);
		}
		//customerCompany filters data
		List<String> customerCompanyFiltersList = new ArrayList<String>();
		List<TableFiltersDataDTO> customerCompanyFilters = new ArrayList<TableFiltersDataDTO>();
		customerCompanyFiltersList = projectDAOMapper.selectProjectTableCustomerCompanyFiltersData(projectTableVO);
		for(String str:customerCompanyFiltersList) {
			TableFiltersDataDTO tableFiltersDataDTO = new TableFiltersDataDTO();
			tableFiltersDataDTO.setText(str);
			tableFiltersDataDTO.setValue(str);
			customerCompanyFilters.add(tableFiltersDataDTO);
		}
		projectTableFiltersDTO.setCustomerCompanyFilters(customerCompanyFilters);
		projectTableFiltersDTO.setGenderFilters(genderFilters);
		projectTableFiltersDTO.setGoodsTypeFilters(goodsTypeFilters);
		projectTableFiltersDTO.setYearFilters(yearFilters);
		projectTableFiltersDTO.setWinStatusFilters(winStatusFilters);
		projectTableFiltersDTO.setSeasonFilters(seasonFilters);
		
		return projectTableFiltersDTO;
	}

	public ProjectCodeListDTO selectProjectCode() {
		// TODO Auto-generated method stub
		ProjectCodeListDTO projectCodeListDTO = new ProjectCodeListDTO();
		List<ProjectCodeDTO> yearcode = projectDAOMapper.selectProjectYearCode();
		List<ProjectCodeDTO> customerClassificationcode = new ArrayList<ProjectCodeDTO>();
		customerClassificationcode = projectDAOMapper.selectProjectCustomerClassificCode();
		List<ProjectCodeDTO> customercode = new ArrayList<ProjectCodeDTO>();
		customercode = projectDAOMapper.selectProjectCustomerCode();
		List<ProjectCodeDTO> gendercode = new ArrayList<ProjectCodeDTO>();
		gendercode = projectDAOMapper.selectProjectGenderCode();
		List<ProjectCodeDTO> seasoncode = new ArrayList<ProjectCodeDTO>();
		seasoncode = projectDAOMapper.selectProjectSeasonCode();
		List<ProjectCodeDTO> goodsTypecode = new ArrayList<ProjectCodeDTO>();
		goodsTypecode = projectDAOMapper.selectProjectGoodsTypeCode();
		List<ProjectCodeDTO> winStatuscode = new ArrayList<ProjectCodeDTO>();
		winStatuscode = projectDAOMapper.selectProjectWinStatusCode();
		projectCodeListDTO.setCustomerClassificationcode(customerClassificationcode);
		projectCodeListDTO.setSeasoncode(seasoncode);
		projectCodeListDTO.setGendercode(gendercode);
		projectCodeListDTO.setYearcode(yearcode);
		projectCodeListDTO.setWinStatuscode(winStatuscode);
		projectCodeListDTO.setCustomercode(customercode);
		projectCodeListDTO.setGoodsTypecode(goodsTypecode);
		return projectCodeListDTO;
	}
	
	
	
}
