package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigFileFirstKindMapper;
import com.hr.pojo.ConfigFileFirstKind;
import com.hr.service.ConfigFileFirstKindService;

@Service
public class ConfigFileFirstKindServiceImpl implements ConfigFileFirstKindService{
	@Autowired
	ConfigFileFirstKindMapper mapper = null;
	
	@Override
	public boolean addConfigFileFirstKind(ConfigFileFirstKind ffk) {
		// TODO Auto-generated method stub
		return mapper.addConfigFileFirstKind(ffk);
	}

	@Override
	public boolean removeConfigFileFirstKind(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.removeConfigFileFirstKind(ffkId);
	}

	@Override
	public boolean updateConfigFileFirstKind(ConfigFileFirstKind ffk) {
		// TODO Auto-generated method stub
		return mapper.updateConfigFileFirstKind(ffk);
	}

	@Override
	public ConfigFileFirstKind queryConfigFileFirstKindById(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.queryConfigFileFirstKindById(ffkId);
	}

	@Override
	public List<ConfigFileFirstKind> queryAllConfigFileFirstKind() {
		// TODO Auto-generated method stub
		return mapper.queryAllConfigFileFirstKind();
	}

}
