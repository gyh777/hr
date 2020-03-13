package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hr.mapper.ConfigMajorMapper;
import com.hr.pojo.ConfigMajor;
import com.hr.service.ConfigMajorService;

public class ConfigMajorServiceImpl implements ConfigMajorService{
	@Autowired
	ConfigMajorMapper mapper = null;

	@Override
	public List<ConfigMajor> selectAllConfigMajor() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajor();
	}

	@Override
	public boolean deleteConfigMajor(int makId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigMajor(makId);
	}

	@Override
	public boolean addConfigMajor(ConfigMajor cm) {
		// TODO Auto-generated method stub
		return mapper.addConfigMajor(cm);
	}

}
