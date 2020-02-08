package org.kor.mv.modules.common.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.kor.mv.exception.dto.ResponseBean;
import org.kor.mv.modules.common.service.ComboboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("combobox")
@CrossOrigin
@RequiresAuthentication
public class ComboboxController {

	@Autowired 
	private ComboboxService comboboxService;
	
	
	@RequestMapping(value="/queryDepartmentsList")
	@ResponseBody
	public ResponseBean queryDepartmentsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000","success",comboboxService.selectDepartComboboxData());		
		return respBean;
	}
	
	@RequestMapping("/queryPositionsList")
	@ResponseBody
	public ResponseBean queryPositionsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000","success",comboboxService.selectPositionComboboxData());		
		return respBean;		
	}
	
	
	@RequestMapping("/queryLevelsList")
	@ResponseBody
	public ResponseBean queryLevelsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000","success",comboboxService.selectLevelComboboxData());		
		return respBean;
	}
	
	@RequestMapping("/queryOfficeStatusList")
	@ResponseBody
	public ResponseBean queryOfficeStatusList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000","success",comboboxService.selectOfficeStatusComboboxData());		
		return respBean;
	}
}
