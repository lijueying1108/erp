package org.kor.mv.modules.common.service.impl;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;
import org.kor.mv.modules.common.service.ComboboxService;
import org.kor.mv.mybatis.mapper.DepartDAOMapper;
import org.kor.mv.mybatis.mapper.LevelDAOMapper;
import org.kor.mv.mybatis.mapper.OfficeStatusDAOMapper;
import org.kor.mv.mybatis.mapper.PositionDAOMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class ComboboxServiceImpl implements ComboboxService {

	@Autowired
	private DepartDAOMapper departDAOMapper;
	
	@Autowired
	private LevelDAOMapper levelDAOMapper;
	
	@Autowired
	private PositionDAOMapper positionDAOMapper;
	
	@Autowired
	private OfficeStatusDAOMapper officeStatusDAOMapper;


	public List<ComboboxDTO> selectDepartComboboxData() {
		// TODO Auto-generated method stub
		return departDAOMapper.selectDepartNameList();
	}

	public List<ComboboxDTO> selectLevelComboboxData() {
		// TODO Auto-generated method stub
		return levelDAOMapper.selectLevelNameList();
	}

	public List<ComboboxDTO> selectPositionComboboxData() {
		// TODO Auto-generated method stub
		return positionDAOMapper.selectPositionNameList();
	}

	public List<ComboboxDTO> selectOfficeStatusComboboxData() {
		// TODO Auto-generated method stub
		return officeStatusDAOMapper.selectOfficeStatusList();
	}

}
