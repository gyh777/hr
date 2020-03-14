package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigFileThirdKindMapper;
import com.hr.pojo.ConfigFileThirdKind;
import com.hr.service.ConfigFileThirdKindService;

@Service
public class ConfigFileThirdKindServiceImpl implements ConfigFileThirdKindService{
	@Autowired
	ConfigFileThirdKindMapper mapper = null;
	
	@Override
	public boolean addConfigFileThirdKind(ConfigFileThirdKind ffk) {
		// TODO Auto-generated method stub
		return mapper.addConfigFileThirdKind(ffk);
	}

	@Override
	public boolean removeConfigFileThirdKind(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.removeConfigFileThirdKind(ffkId);
	}

	@Override
	public boolean updateConfigFileThirdKind(ConfigFileThirdKind ffk) {
		// TODO Auto-generated method stub
		return mapper.updateConfigFileThirdKind(ffk);
	}

	@Override
	public ConfigFileThirdKind queryConfigFileThirdKindById(int ffkId) {
		// TODO Auto-generated method stub
		return mapper.queryConfigFileThirdKindById(ffkId);
	}

	@Override
	public List<ConfigFileThirdKind> queryAllConfigFileThirdKind() {
		// TODO Auto-generated method stub
		return mapper.queryAllConfigFileThirdKind();
	}

}
