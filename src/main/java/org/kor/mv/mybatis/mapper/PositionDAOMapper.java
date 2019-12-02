package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.mybatis.pojo.PositionDAO;

public interface PositionDAOMapper {
    

	int insert(PositionDAO record);

	int insertSelective(PositionDAO record);


	int updateByPrimaryKeySelective(PositionDAO record);

	int updateByPrimaryKey(PositionDAO record);

	List<ComboboxDTO> selectPositionNameList();
}