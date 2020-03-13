package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hr.mapper.ConfigPublicCharMapper;
import com.hr.pojo.ConfigPublicChar;
import com.hr.service.ConfigPublicCharService;

public class ConfigPublicCharServiceImpl implements ConfigPublicCharService{
	@Autowired
	ConfigPublicCharMapper mapper = null;

	@Override
	public List<ConfigPublicChar> selectAllConfigPublicChar() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigPublicChar();
	}

	@Override
	public boolean deleteConfigPublicChar(int pbcId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigPublicChar(pbcId);
	}

	@Override
	public boolean addConfigPublicChar(ConfigPublicChar cpc) {
		// TODO Auto-generated method stub
		return mapper.addConfigPublicChar(cpc);
	}

}
