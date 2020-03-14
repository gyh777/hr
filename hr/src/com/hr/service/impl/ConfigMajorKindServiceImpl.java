package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.hr.mapper.ConfigMajorKindMapper;
import com.hr.pojo.ConfigMajorKind;
import com.hr.service.ConfigMajorKindService;

public class ConfigMajorKindServiceImpl implements ConfigMajorKindService{
	@Autowired
	ConfigMajorKindMapper mapper = null;

	@Override
	public List<ConfigMajorKind> selectAllConfigMajorKind() {
		// TODO Auto-generated method stub
		return mapper.selectAllConfigMajorKind();
	}

	@Override
	public boolean deleteConfigMajorKind(int mfkId) {
		// TODO Auto-generated method stub
		return mapper.deleteConfigMajorKind(mfkId);
	}

	@Override
	public boolean addConfigMajorKind(ConfigMajorKind ck) {
		// TODO Auto-generated method stub
		return mapper.addConfigMajorKind(ck);
	}

}
