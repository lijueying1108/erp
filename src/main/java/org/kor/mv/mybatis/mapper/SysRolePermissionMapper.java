package org.kor.mv.mybatis.mapper;

import org.kor.mv.mybatis.pojo.SysRolePermission;

public interface SysRolePermissionMapper {
    int deleteByPrimaryKey(String id);

	int insert(SysRolePermission record);

	int insertSelective(SysRolePermission record);

	SysRolePermission selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysRolePermission record);

	int updateByPrimaryKey(SysRolePermission record);

}