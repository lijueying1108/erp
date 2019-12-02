package org.kor.mv.modules.common.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.modules.common.service.ComboboxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("combobox")
public class ComboboxController {

	@Autowired 
	private ComboboxService comboboxService;
	
	@RequestMapping(value="/queryDepartmentsList")
	@ResponseBody
	public List<ComboboxDTO> queryDepartmentsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		return comboboxService.selectDepartComboboxData();
	}
	
	@RequestMapping("/queryPositionsList")
	@ResponseBody
	public List<ComboboxDTO> queryPositionsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("POsitionList", comboboxService.selectPositionComboboxData());
		httpRequest.setAttribute("POsitionList", comboboxService.selectPositionComboboxData());
		return comboboxService.selectPositionComboboxData();
		
	}
	
	
	@RequestMapping("/queryLevelsList")
	@ResponseBody
	public List<ComboboxDTO> queryLevelsList(HttpServletRequest httpRequest, HttpSession httpSess) {
		return comboboxService.selectLevelComboboxData();
	}
	
	@RequestMapping("/queryOfficeStatusList")
	@ResponseBody
	public List<ComboboxDTO> queryOfficeStatusList(HttpServletRequest httpRequest, HttpSession httpSess) {
		return comboboxService.selectOfficeStatusComboboxData();
	}
}
