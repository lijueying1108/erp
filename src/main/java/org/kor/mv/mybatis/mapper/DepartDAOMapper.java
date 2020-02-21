package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.mybatis.pojo.DepartDAO;

public interface DepartDAOMapper {
    int deleteByPrimaryKey(String 부서명);

	int insert(DepartDAO record);

	int insertSelective(DepartDAO record);

	DepartDAO selectByPrimaryKey(String 부서명);

	int updateByPrimaryKeySelective(DepartDAO record);

	int updateByPrimaryKey(DepartDAO record);

    
    List<ComboboxDTO> selectDepartNameList();
    
    List<ComboboxDTO> selectBusinessDepartTeamsList();
}