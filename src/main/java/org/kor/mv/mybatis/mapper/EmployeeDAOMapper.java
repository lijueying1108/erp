package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.mybatis.pojo.EmployeeDAO;
import org.kor.mv.mybatis.pojo.LevelDAO;

public interface EmployeeDAOMapper {

	int insert(@Param("record")EmployeeDAO record);

    int insertSelective(EmployeeDAO record);
    
    List<EmployeeDAO> selectEmployeeInfoByName(@Param("name")String name); 
    
    EmployeeDAO selectByPrimaryKey(@Param("id") String id);
    
    int updateByPrimaryKey(@Param("record")EmployeeDAO record);
    
    List<String> selectEmployeeNameList();
    
    List<ComboboxDTO> selectEmployeeNameListGroupByDepart(@Param("departName")String departName);
}