package org.kor.mv.modules.projectManage.service;

import java.util.List;

import org.kor.mv.modules.projectManage.dto.ProjectCodeListDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableFiltersDTO;
import org.kor.mv.modules.projectManage.vo.ProjectTableVO;

public interface ProjectManageService {
	List<ProjectTableDTO>  selectProjectTableData(ProjectTableVO projectTableVO);
	ProjectTableFiltersDTO selectProjectTableFiltersData(ProjectTableVO projectTableVO);
	ProjectCodeListDTO selectProjectCode();
}
