package org.kor.mv.mybatis.mapper;

import org.kor.mv.mybatis.pojo.SysUserRole;

public interface SysUserRoleMapper {

	int deleteByPrimaryKey(String id);

	int insert(SysUserRole record);

	int insertSelective(SysUserRole record);

	SysUserRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysUserRole record);

	int updateByPrimaryKey(SysUserRole record);

	int deleteByPrimaryKey(Integer id);



	SysUserRole selectByPrimaryKey(Integer id);





}