package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.mybatis.pojo.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(String id);

	int insert(SysRole record);

	int insertSelective(SysRole record);

	SysRole selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysRole record);

	int updateByPrimaryKey(SysRole record);
	
	List<SysRole> findRoleByUsername (String username);
}