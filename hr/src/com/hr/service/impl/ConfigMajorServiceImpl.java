package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigMajorMapper;
import com.hr.pojo.ConfigMajor;
import com.hr.service.ConfigMajorService;

@Service
public class ConfigMajorServiceImpl implements ConfigMajorService{
	@Autowired
	ConfigMajorMapper mapper;

	@Override
	public List<ConfigMajor> selectAllConfigMajor() {
		return mapper.selectAllConfigMajor();
	}

	@Override
	public boolean deleteConfigMajor(String major_name) {
		return mapper.deleteConfigMajor(major_name);
	}

	@Override
	public boolean addConfigMajor(ConfigMajor cm) {
		return mapper.addConfigMajor(cm);
	}

}
