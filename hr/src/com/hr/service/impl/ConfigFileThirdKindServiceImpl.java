package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigFileThirdKindMapper;
import com.hr.pojo.ConfigFileThirdKind;
import com.hr.service.ConfigFileThirdKindService;
import com.hr.web.controller.requestparamtype.TwoStringValue;

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

	@Override
	public String queryIdByName(String third_kind_name) {
		// TODO Auto-generated method stub
		return mapper.queryIdByName(third_kind_name);
	}

	@Override
	public List<TwoStringValue> queryKindIdAndName(
			String first_kind_name,String second_kind_name) {
		// TODO Auto-generated method stub
		return mapper.queryKindIdAndName(first_kind_name, second_kind_name);
	}

}
