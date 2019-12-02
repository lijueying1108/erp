package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.mybatis.pojo.SysPermission;

public interface SysPermissionMapper {
    int deleteByPrimaryKey(String id);

	int insert(SysPermission record);

	int insertSelective(SysPermission record);

	SysPermission selectByPrimaryKey(String id);

	int updateByPrimaryKeySelective(SysPermission record);

	int updateByPrimaryKey(SysPermission record);

	int deleteByPrimaryKey(Integer id);

	SysPermission selectByPrimaryKey(Integer id);
   
    List<SysPermission> findMenuListByUserId(String id);

    List<SysPermission> findPermissionListByUserId(String id);
}