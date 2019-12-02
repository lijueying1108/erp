package org.kor.mv.modules.empManage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.kor.mv.dto.BaseResponseMessage;
import org.kor.mv.dto.ResponseErrorMessage;
import org.kor.mv.dto.ResponseSuccessMessage;
import org.kor.mv.modules.empManage.dto.EmpManageDTO;
import org.kor.mv.modules.empManage.service.EmpManageService;
import org.kor.mv.modules.empManage.vo.EmpManageVO;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.kor.mv.util.ResponseCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("employee")
@RequiresAuthentication
public class EmpManageController {

	@Autowired
	private EmpManageService empManageService;
	
	private Logger logger = LogManager.getLogger();
	
	@RequestMapping(value="/query",method=RequestMethod.POST)
	@ResponseBody
	public BaseResponseMessage queryEmployee(@RequestParam ("name") String name) {
		
		EmpManageVO  empManageVO = new EmpManageVO();
		Map<Object,Object> map = new HashMap<Object,Object>();
		//System.out.print(name);
		List<Object> list = new ArrayList<Object>();
		try {
			empManageVO = empManageService.selectEmployeeInfoByName(name);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (empManageVO != null) {
			ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
			responseSuccessMessage.setSuccessMsg("success");
			list.add(empManageVO);
			map.put("이각영", empManageVO);
			responseSuccessMessage.setData(list);
			return responseSuccessMessage;
		} else {
			ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
			responseErrorMessage.setErrCode(ResponseCodeUtil.NULL_OBJ.getCode());
			responseErrorMessage.setErrMsg("찾으신 "+name+" 직원분이 없습니다.다시 확인하여 주십오");
			return responseErrorMessage;
		}						
	}

	@RequestMapping(value="/query/empNameList",method=RequestMethod.GET)
	@ResponseBody
	public BaseResponseMessage queryEmployeeNameList() {
		ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
		ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
		try {
				List<Object> list =empManageService.queryEmployeeNameList();
				responseSuccessMessage.setSuccessMsg("empNameList success");
				responseSuccessMessage.setData(list);
				return responseSuccessMessage;					
			}catch(Exception e) {
				e.printStackTrace();
				responseErrorMessage.setErrCode(ResponseCodeUtil.ERROR_EXCEPTION.getCode());
				responseErrorMessage.setErrMsg("오류 발생했습니다.");
				return responseErrorMessage;}
			
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	//@RequiresPermissions("employee:create")
	public BaseResponseMessage createEmployee(@RequestBody EmpManageDTO employeeDTO) {
		
		ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
		ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
		logger.debug(employeeDTO.getId());
		if (empManageService.selectEmpManageDAOByPrimaryKey(employeeDTO.getId()) >0) {
			EmployeeDAO employeeDAO = new EmployeeDAO();
			employeeDAO.setId(employeeDTO.getId());
			employeeDAO.setName(employeeDTO.getName());
			employeeDAO.setResidRegistrNum(employeeDTO.getResidRegistrNum());
			employeeDAO.setEmailAddress(employeeDTO.getEmailAddress());
			employeeDAO.setMobileNum(employeeDTO.getMobileNum());
			employeeDAO.setCertification(employeeDTO.getCertification());
			employeeDAO.setSpecialNote(employeeDTO.getSpecialNote());
			employeeDAO.setHiredate(employeeDTO.getHiredate());
			employeeDAO.setDepart(employeeDTO.getDepart());
			employeeDAO.setPosition(employeeDTO.getPosition());
			employeeDAO.setLevel(employeeDTO.getLevel());
			employeeDAO.setResignationDate(employeeDTO.getResignationDate());
			employeeDAO.setOfficeStatus(employeeDTO.getOfficeStatus());
			employeeDAO.setDeletestatus((byte)0);

			int tmp = empManageService.insertEmpManageDAO(employeeDAO);
			if (tmp<1) {
				responseErrorMessage.setErrCode(ResponseCodeUtil.ERROR_EXCEPTION.getCode());
				responseErrorMessage.setErrMsg("오류 발생했습니다.");
				return responseErrorMessage;

			}else {
				responseSuccessMessage.setSuccessMsg("success");
				return responseSuccessMessage;
			}
		} else {
			responseErrorMessage.setErrCode(ResponseCodeUtil.ERROR_INSERT_EXIST.getCode());
			responseErrorMessage.setErrMsg(employeeDTO+" 직원 ID 이미 사용하고 있습니다.");
			return responseErrorMessage;
		}
		
	}
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	@ResponseBody
	//@RequiresPermissions("employee:modify")
	public BaseResponseMessage modifyEmployee(@RequestBody EmpManageDTO employeeDTO) {
		ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
		ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
		logger.debug(employeeDTO.getId());
		String str ="";
		try {
			str=empManageService.updateByPrimaryKey(employeeDTO);					
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (str.equals("success")) {
			responseSuccessMessage.setSuccessMsg("success");
			return responseSuccessMessage;
		} else {
			responseErrorMessage.setErrCode(ResponseCodeUtil.ERROR_EXCEPTION.getCode());
			responseErrorMessage.setErrMsg("오류 발생했습니다.");
			return responseErrorMessage;
			}		
	}

}
