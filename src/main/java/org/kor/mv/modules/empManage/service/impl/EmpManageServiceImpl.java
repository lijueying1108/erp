package org.kor.mv.modules.empManage.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.PrincipalCollection;
import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.modules.empManage.dto.EmpManageDTO;
import org.kor.mv.modules.empManage.service.EmpManageService;
import org.kor.mv.modules.empManage.vo.EmpManageVO;
import org.kor.mv.mybatis.mapper.EmployeeDAOMapper;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpManageServiceImpl implements EmpManageService {

	Logger logger = LogManager.getLogger();
	
	@Autowired
	private EmployeeDAOMapper employeeDAOMapper;
		
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	
	public List<EmpManageVO> selectEmployeeInfoByName(String name) {
		// TODO Auto-generated method stub
		
		
		List<EmpManageVO> empManageVOList = new ArrayList<EmpManageVO>();		
		List<EmployeeDAO> empdaoList = employeeDAOMapper.selectEmployeeInfoByName(name);
		if (empdaoList.size() >0 ) {
			for (EmployeeDAO employeeDAO:empdaoList) {
				EmpManageVO empManageVO = new EmpManageVO();
				empManageVO.setId(employeeDAO.getId());
				empManageVO.setName(employeeDAO.getName());
				empManageVO.setResidRegistrNum(employeeDAO.getResidRegistrNum());
				empManageVO.setEmailAddress(employeeDAO.getEmailAddress());
				empManageVO.setMobileNum(employeeDAO.getMobileNum());
				empManageVO.setCertification(employeeDAO.getCertification());
				empManageVO.setPassword("*****");
				empManageVO.setSpecialNote(employeeDAO.getSpecialNote());
				empManageVO.setHiredate(employeeDAO.getHiredate());
				empManageVO.setDepart(employeeDAO.getDepart());
				empManageVO.setPosition(employeeDAO.getPosition());
				empManageVO.setLevel(employeeDAO.getLevel());
				empManageVO.setResignationDate(employeeDAO.getResignationDate());
				empManageVO.setOfficeStatus(employeeDAO.getOfficeStatus());
				empManageVOList.add(empManageVO);
			}

			//empManageDTOList.add(empManageDTO);
			return empManageVOList;
		} else return null;
	}

	public  int selectEmpManageDAOByPrimaryKey(String id) {
		// TODO Auto-generated method stub
		EmployeeDAO employeeDAO = new EmployeeDAO();
		employeeDAO = employeeDAOMapper.selectByPrimaryKey(id);
		if (employeeDAO !=null) {
		    return 0;
		} else return 1;
	}

	public int insertEmpManageDAO(EmployeeDAO employeeDAO) {
		// TODO Auto-generated method stub
		try {
			logger.debug(employeeDAO);
			employeeDAOMapper.insert(employeeDAO);
			
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

	public String updateByPrimaryKey(EmpManageDTO employeeDTO) {
		// TODO Auto-generated method stub
		
		EmployeeDAO employeeDAO = new EmployeeDAO();
		if (employeeDTO.getOfficeStatus().equals("재직")) {
			employeeDAO.setDeletestatus((byte) 0);
		} else {
			employeeDAO.setDeletestatus((byte) 1);
		}
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
		try {
			employeeDAOMapper.updateByPrimaryKey(employeeDAO);
			return "success";
		}catch(Exception e) {
			logger.debug(e);
			return null;
		}
	}
	
	public List<Object> queryEmployeeNameList() {
		List<String> list = employeeDAOMapper.selectEmployeeNameList();
		
		logger.debug("list:"+list);
		List<Object> userList = new ArrayList<Object>();
		
		
		for(int index=0;index<list.size();index++) {
			ComboboxDTO combobox = new ComboboxDTO();
			combobox.setKey(String.valueOf(index+1));
			combobox.setValue(list.get(index));
			userList.add(combobox);
		}
		return userList;
	} 


}
