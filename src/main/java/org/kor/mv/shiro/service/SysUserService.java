package org.kor.mv.shiro.service;

import java.util.List;

import org.kor.mv.modules.empManage.vo.EmpManageVO;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.kor.mv.mybatis.pojo.SysPermission;
import org.kor.mv.mybatis.pojo.SysRole;
import org.kor.mv.mybatis.pojo.SysUser;

public interface SysUserService {

	SysUser findSysUserByUserCode(String usercode);
	
	List<SysPermission>  findMenuListByUserCode(String id);
	
	List<SysPermission>  findPermissionListByUserCode(String id);
	
	List<SysRole> findRoleByUsername (String username);
	
	EmployeeDAO selectEmployeeName(String id);
}
