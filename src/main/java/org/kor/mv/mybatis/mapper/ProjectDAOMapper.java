package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.modules.projectManage.dto.ProjectCodeDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableDTO;
import org.kor.mv.modules.projectManage.vo.ProjectTableVO;

public interface ProjectDAOMapper {
	List<ComboboxDTO> selectProjectYearslist();
	List<ComboboxDTO> selectProjectSeasonslist();
	List<ComboboxDTO> selectProjectCustomerslist();
	List<ComboboxDTO> selectProjectWinStatuslist();
	List<ProjectTableDTO> selectProjectTableData(ProjectTableVO projectTableVO);
	List<String> selectProjectTableYearFiltersData(ProjectTableVO projectTableVO);
	List<String> selectProjectTableSeasonFiltersData(ProjectTableVO projectTableVO);
	List<String> selectProjectTableGoodsTypeFiltersData(ProjectTableVO projectTableVO);
	List<String> selectProjectTableGenderFiltersData(ProjectTableVO projectTableVO);
	List<String> selectProjectTableWinStatusFiltersData(ProjectTableVO projectTableVO);
	List<String> selectProjectTableCustomerCompanyFiltersData(ProjectTableVO projectTableVO);
	List<ProjectCodeDTO> selectProjectYearCode();
	List<ProjectCodeDTO> selectProjectCustomerClassificCode();
	List<ProjectCodeDTO> selectProjectCustomerCode();
	List<ProjectCodeDTO> selectProjectSeasonCode();
	List<ProjectCodeDTO> selectProjectGoodsTypeCode();
	List<ProjectCodeDTO> selectProjectGenderCode();
	List<ProjectCodeDTO> selectProjectWinStatusCode();
}
