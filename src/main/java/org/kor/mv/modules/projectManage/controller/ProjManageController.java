package org.kor.mv.modules.projectManage.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.kor.mv.exception.dto.ResponseBean;
import org.kor.mv.modules.common.dto.TableDataDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableDTO;
import org.kor.mv.modules.projectManage.dto.ProjectTableFiltersDTO;
import org.kor.mv.modules.projectManage.service.ProjectManageService;
import org.kor.mv.modules.projectManage.vo.ProjectTableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin
@RequestMapping("project")
@RequiresAuthentication
public class ProjManageController {
	
	@Autowired
	private ProjectManageService projectManageService;
	
	@RequestMapping(value="/newProject/generateProjectCode",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean generateProjectCode() {
		ResponseBean responseBean = new ResponseBean("20000",projectManageService.selectProjectCode());
		return responseBean;
	}
	
	@RequestMapping(value="/projectRecord/queryProjects",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean queryProjectTableData(@RequestBody ProjectTableVO projectTableVO) {
		ResponseBean responseBean = new ResponseBean();
		TableDataDTO tableDataDTO = new TableDataDTO();
		
		List<ProjectTableDTO>  projectTableDTOlist = new ArrayList<ProjectTableDTO>();
		ProjectTableFiltersDTO projectTableFiltersDTO = new ProjectTableFiltersDTO();
		try {
			projectTableDTOlist = projectManageService.selectProjectTableData(projectTableVO);
			projectTableFiltersDTO = projectManageService.selectProjectTableFiltersData(projectTableVO);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (projectTableDTOlist != null) {
			responseBean.setCode("20000");
			responseBean.setMsg("success");
			responseBean.setStatus(true);
			tableDataDTO.setDataSource(projectTableDTOlist);
			tableDataDTO.setFiltersData(projectTableFiltersDTO);
			responseBean.setData(tableDataDTO);
			return responseBean;
		} else {
			responseBean.setCode("20000");
			responseBean.setMsg("원하시는 데이터 없습니디.");
			responseBean.setStatus(false);
			return responseBean;
		}						
	}
	
}
