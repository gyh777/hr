package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigPublicCharMapper;
import com.hr.pojo.ConfigPublicChar;
import com.hr.service.ConfigPublicCharService;

@Service
public class ConfigPublicCharServiceImpl implements ConfigPublicCharService{
	@Autowired
	ConfigPublicCharMapper mapper = null;

	@Override
	public List<ConfigPublicChar> selectAllConfigPublicChar() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigPublicChar();
	}

	@Override
	public boolean deleteConfigPublicChar(String attribute_kind ,String attribute_name) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigPublicChar(attribute_kind ,attribute_name);
	}

	@Override
	public boolean addConfigPublicChar(ConfigPublicChar cpc) {
		// TODO Auto-generated method stub
		return mapper.addConfigPublicChar(cpc);
	}

}
