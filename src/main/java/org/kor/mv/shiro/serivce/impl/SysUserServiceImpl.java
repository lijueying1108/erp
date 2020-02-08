package org.kor.mv.shiro.serivce.impl;

import java.util.List;

import org.kor.mv.dto.ActiveUser;
import org.kor.mv.modules.empManage.service.EmpManageService;
import org.kor.mv.modules.empManage.vo.EmpManageVO;
import org.kor.mv.mybatis.mapper.EmployeeDAOMapper;
import org.kor.mv.mybatis.mapper.SysPermissionMapper;
import org.kor.mv.mybatis.mapper.SysRoleMapper;
import org.kor.mv.mybatis.mapper.SysUserMapper;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.kor.mv.mybatis.pojo.SysPermission;
import org.kor.mv.mybatis.pojo.SysRole;
import org.kor.mv.mybatis.pojo.SysUser;
import org.kor.mv.shiro.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;
	
	@Autowired 
	private SysPermissionMapper sysPermissionMapper; 
	
	@Autowired 
	private SysRoleMapper sysRoleMapper; 
	
	@Autowired 
	private EmployeeDAOMapper employeeDAOMapper; 
	
	public SysUser findSysUserByUserCode(String usercode) {
		// TODO Auto-generated method stub
		if (usercode != null) {
			return sysUserMapper.findSysUserByUserCode(usercode);
		} else {
			return null;
		}		
	}

	public List<SysPermission> findMenuListByUserCode(String id) {
		// TODO Auto-generated method stub
			// TODO Auto-generated method stub
			if (id != null) {
				return sysPermissionMapper.findMenuListByUserId(id);
			} else {
				return null;
			}		
		}

	public List<SysPermission> findPermissionListByUserCode(String id) {
		// TODO Auto-generated method stub
		if (id != null) {
			return sysPermissionMapper.findPermissionListByUserId(id);
		} else {
			return null;
		}
	}

	public EmployeeDAO selectEmployeeName(String id) {
		// TODO Auto-generated method stub
		if (id != null) {
			return employeeDAOMapper.selectByPrimaryKey(id);
		} else {
			return null;
		}
	}

	public List<SysRole> findRoleByUsername(String username) {
		// TODO Auto-generated method stub
		if (username != null) {
			return sysRoleMapper.findRoleByUsername(username);
		} else {
			return null;
		}
	}

}
