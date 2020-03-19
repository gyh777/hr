package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigMajorKindMapper;
import com.hr.pojo.ConfigMajorKind;
import com.hr.service.ConfigMajorKindService;
import com.hr.web.controller.requestparamtype.TwoStringValue;

@Service
public class ConfigMajorKindServiceImpl implements ConfigMajorKindService{
	@Autowired
	ConfigMajorKindMapper mapper = null;

	@Override
	public List<ConfigMajorKind> selectAllConfigMajorKind() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajorKind();
	}

	@Override
	public boolean deleteConfigMajorKind(String major_kind_name) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigMajorKind(major_kind_name);
	}

	@Override
	public boolean addConfigMajorKind(ConfigMajorKind cmk) {
		// TODO Auto-generated method stub
		return mapper.addConfigMajorKind(cmk);
	}

	@Override
	public List<TwoStringValue> selectAllConfigMajorKindIdAndName() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajorKindIdAndName();
	}

	@Override
	public String selectConfigMajorKindIdByName(String major_kind_name) {
		// TODO Auto-generated method stub
		return mapper.selectConfigMajorKindIdByName(major_kind_name);
	}

}
