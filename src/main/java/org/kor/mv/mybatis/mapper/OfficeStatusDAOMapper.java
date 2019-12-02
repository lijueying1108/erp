package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.mybatis.pojo.OfficeStatusDAO;

public interface OfficeStatusDAOMapper {
    
    int deleteByPrimaryKey(String name);

	int insert(OfficeStatusDAO record);

	int insertSelective(OfficeStatusDAO record);

	OfficeStatusDAO selectByPrimaryKey(String name);

	int updateByPrimaryKeySelective(OfficeStatusDAO record);

	int updateByPrimaryKey(OfficeStatusDAO record);

	List<ComboboxDTO> selectOfficeStatusList();
}