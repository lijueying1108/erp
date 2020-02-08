package org.kor.mv.modules.empManage.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.kor.mv.dto.BaseResponseMessage;
import org.kor.mv.dto.ResponseErrorMessage;
import org.kor.mv.dto.ResponseSuccessMessage;
import org.kor.mv.exception.dto.ResponseBean;
import org.kor.mv.modules.empManage.dto.EmpManageDTO;
import org.kor.mv.modules.empManage.service.EmpManageService;
import org.kor.mv.modules.empManage.vo.EmpManageVO;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.kor.mv.util.ResponseCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin
@Controller
@RequestMapping("employee")
@RequiresAuthentication
@RequiresRoles(value= {"S"})
public class EmpManageController {

	@Autowired
	private EmpManageService empManageService;
	
	private Logger logger = LogManager.getLogger();
	
	@RequestMapping(value="/query",method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean queryEmployee(@RequestParam ("name") String name) {
		ResponseBean responseBean = new ResponseBean();
		List<EmpManageVO>  empManageVOlist = new ArrayList<EmpManageVO>();
		try {
			empManageVOlist = empManageService.selectEmployeeInfoByName(name);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (empManageVOlist != null) {
			responseBean.setCode("20000");
			responseBean.setMsg("success");
			responseBean.setStatus(true);
			responseBean.setData(empManageVOlist);
			return responseBean;
		} else {
			responseBean.setCode("20000");
			responseBean.setMsg("찾으신 "+name+" 직원분이 없습니다.다시 확인하여 주십오");
			responseBean.setStatus(false);
			return responseBean;
		}						
	}


	@RequestMapping(value="/query/empNameList",method=RequestMethod.GET)
	@ResponseBody
	public BaseResponseMessage queryEmployeeNameList() {
		ResponseSuccessMessage responseSuccessMessage = new ResponseSuccessMessage();
		ResponseErrorMessage responseErrorMessage = new ResponseErrorMessage();
		try {
				List<Object> list =empManageService.queryEmployeeNameList();
				responseSuccessMessage.setCode("20000");
				responseSuccessMessage.setSuccessMsg("empNameList success");
				responseSuccessMessage.setData(list);
				return responseSuccessMessage;					
			}catch(Exception e) {
				e.printStackTrace();
				responseErrorMessage.setCode("20000");
				responseErrorMessage.setErrMsg("오류 발생했습니다.");
				return responseErrorMessage;}
			
	}
	
	@RequestMapping(value="/create",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean createEmployee(@RequestBody EmpManageDTO employeeDTO) {
		
		ResponseBean responseBean = new ResponseBean();
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
			System.out.print("입사일:"+employeeDTO.getHiredate());
			employeeDAO.setDepart(employeeDTO.getDepart());
			employeeDAO.setPosition(employeeDTO.getPosition());
			employeeDAO.setLevel(employeeDTO.getLevel());
			employeeDAO.setResignationDate(employeeDTO.getResignationDate());
			employeeDAO.setOfficeStatus(employeeDTO.getOfficeStatus());
			employeeDAO.setDeletestatus((byte)0);

			int tmp = empManageService.insertEmpManageDAO(employeeDAO);
			if (tmp<1) {
				responseBean.setCode("20000");
				responseBean.setMsg("오류 발생했습니다.");
				responseBean.setStatus(false);
				return responseBean;

			}else {
				responseBean.setCode("20000");
				responseBean.setMsg("신규 등록 완류 되었습니다.");
				responseBean.setStatus(true);
				return responseBean;
			}
		} else {
			responseBean.setCode("20000");
			responseBean.setMsg(employeeDTO.getId()+" 직원 ID 이미 사용하고 있습니다.");
			responseBean.setStatus(false);
			return responseBean;
		}		
	}
	
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean modifyEmployee(@RequestBody EmpManageDTO employeeDTO) {
		ResponseBean responseBean = new ResponseBean();
		logger.debug(employeeDTO.getId());
		String str ="";
		try {
			str=empManageService.updateByPrimaryKey(employeeDTO);					
		}catch(Exception e) {
			e.printStackTrace();
		}
		if (str.equals("success")) {
			responseBean.setCode("20000");
			responseBean.setMsg(employeeDTO.getName()+" 개인정보 갱신 완류 되었습니다.");
			responseBean.setStatus(true);
			return responseBean;
		} else {
			responseBean.setCode("20000");
			responseBean.setMsg("오류 발생했습니다.");
			responseBean.setStatus(false);
			return responseBean;
			}		
	}

}
