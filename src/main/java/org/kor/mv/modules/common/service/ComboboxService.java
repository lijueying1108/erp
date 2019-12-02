package org.kor.mv.modules.common.service;

import java.util.List;

import org.kor.mv.modules.common.dto.ComboboxDTO;

public interface ComboboxService {

	public List<ComboboxDTO> selectDepartComboboxData();
	
	public List<ComboboxDTO> selectLevelComboboxData();
	
	public List<ComboboxDTO> selectPositionComboboxData();
	
	public List<ComboboxDTO> selectOfficeStatusComboboxData();
}
