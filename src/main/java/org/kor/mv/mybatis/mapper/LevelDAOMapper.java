package org.kor.mv.mybatis.mapper;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.mybatis.pojo.LevelDAO;

public interface LevelDAOMapper {


	int insert(LevelDAO record);

	int insertSelective(LevelDAO record);

	int updateByPrimaryKeySelective(LevelDAO record);

	int updateByPrimaryKey(LevelDAO record);

	List<ComboboxDTO> selectLevelNameList();
}