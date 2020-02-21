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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectDepartComboboxData());
		return respBean;
	}
	
	@RequestMapping("/queryPositionsList")
	@ResponseBody
	public ResponseBean queryPositionsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectPositionComboboxData());
		return respBean;	
	}
	
	
	@RequestMapping("/queryLevelsList")
	@ResponseBody
	public ResponseBean queryLevelsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectDepartComboboxData());
		return respBean;
	}
	
	@RequestMapping("/queryOfficeStatusList")
	@ResponseBody
	public ResponseBean queryOfficeStatusList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectOfficeStatusComboboxData());
		return respBean;
	}
	
	@RequestMapping("/queryBusiDepartTeamsList")
	@ResponseBody
	public ResponseBean queryBusiDepartTeamsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectBusiDepartTeamsComboboxData());
		return respBean;
	}

	@RequestMapping("/queryProjectYearsList")
	@ResponseBody
	public ResponseBean queryProjectYearsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectProjectYearsComboboxData());
		return respBean;
	}
	
	@RequestMapping("/queryProjectSeasonsList")
	@ResponseBody
	public ResponseBean queryProjectSeasonsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectProjectSeasonsComboboxData());
		return respBean;
	}
	
	@RequestMapping("/queryProjectCustomersList")
	@ResponseBody
	public ResponseBean queryProjectCustomersList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectProjectCustomersComboboxData());
		return respBean;
	}
	
	@RequestMapping(value="/queryEmpListByDepartName",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean queryProjectWinStatusList(@RequestParam ("departName") String departName) {
		ResponseBean respBean = new ResponseBean("20000",comboboxService.selectEmpComboboxData(departName));
		return respBean;
	}
}
