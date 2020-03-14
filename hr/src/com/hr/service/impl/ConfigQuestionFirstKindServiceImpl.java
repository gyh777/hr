package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigQuestionFirstKindMapper;
import com.hr.pojo.ConfigQuestionFirstKind;
import com.hr.service.ConfigFileFirstKindService;
import com.hr.service.ConfigQuestionFirstKindService;

@Service
public class ConfigQuestionFirstKindServiceImpl implements ConfigQuestionFirstKindService {
	@Autowired
	ConfigQuestionFirstKindMapper configQuestionFirstKindMapper;

	@Override
	public List<ConfigQuestionFirstKind> listConfigQuestionFirstKind() {
		return configQuestionFirstKindMapper.select();
	}

	@Override
	public ConfigQuestionFirstKind getConfigQuestionFirstKind(String qfkId) {
		return configQuestionFirstKindMapper.selectByQfkId(qfkId);
	}

	@Override
	public Boolean save(ConfigQuestionFirstKind configQuestionFirstKind) {
		if(configQuestionFirstKindMapper.insert(configQuestionFirstKind) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(ConfigQuestionFirstKind configQuestionFirstKind) {
		if(configQuestionFirstKindMapper.update(configQuestionFirstKind) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(String qfkId) {
		if(configQuestionFirstKindMapper.delete(qfkId) > 0)
			return true;
		return false;
	}
	
}
