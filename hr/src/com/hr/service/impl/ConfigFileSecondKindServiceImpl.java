package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigFileSecondKindMapper;
import com.hr.pojo.ConfigFileSecondKind;
import com.hr.service.ConfigFileSecondKindService;

@Service
public class ConfigFileSecondKindServiceImpl implements ConfigFileSecondKindService{
	@Autowired
	ConfigFileSecondKindMapper mapper = null;
	
	@Override
	public boolean addConfigFileSecondKind(ConfigFileSecondKind ffk) {
		// TODO Auto-generated method stub
		return mapper.addConfigFileSecondKind(ffk);
	}

	@Override
	public boolean removeConfigFileSecondKind(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.removeConfigFileSecondKind(ffkId);
	}

	@Override
	public boolean updateConfigFileSecondKind(ConfigFileSecondKind ffk) {
		// TODO Auto-generated method stub
		return mapper.updateConfigFileSecondKind(ffk);
	}

	@Override
	public ConfigFileSecondKind queryConfigFileSecondKindById(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.queryConfigFileSecondKindById(ffkId);
	}

	@Override
	public List<ConfigFileSecondKind> queryAllConfigFileSecondKind() {
		// TODO Auto-generated method stub
		return mapper.queryAllConfigFileSecondKind();
	}

}
