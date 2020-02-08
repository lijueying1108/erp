package org.kor.mv.modules.empManage.service;

import java.util.List;

import org.kor.mv.modules.empManage.dto.EmpManageDTO;
import org.kor.mv.modules.empManage.vo.EmpManageVO;
import org.kor.mv.mybatis.pojo.EmployeeDAO;

public interface EmpManageService {

	List<EmpManageVO> selectEmployeeInfoByName(String id);
	
	int selectEmpManageDAOByPrimaryKey(String id);
	
	int insertEmpManageDAO(EmployeeDAO employeeDAO);

	String updateByPrimaryKey(EmpManageDTO empManageDTO);
	
	List<Object> queryEmployeeNameList();
}
