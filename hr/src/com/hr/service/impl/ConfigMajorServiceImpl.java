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

	@Override
	public List<String> selectAllConfigMajorName(String major_kind_name) {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajorName(major_kind_name);
	}

	@Override
	public String selectConfigMajorIdByName(String major_name) {
		// TODO Auto-generated method stub
		return mapper.selectConfigMajorIdByName(major_name);
	}

}
