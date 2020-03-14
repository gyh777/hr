package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.ConfigQuestionSecondKindMapper;
import com.hr.pojo.ConfigQuestionSecondKind;
import com.hr.service.ConfigQuestionSecondKindService;

@Service
public class ConfigQuestionSecondKindServiceImpl implements ConfigQuestionSecondKindService {
	@Autowired
	ConfigQuestionSecondKindMapper configQuestionSecondKindMapper;

	@Override
	public List<ConfigQuestionSecondKind> list() {	
		return configQuestionSecondKindMapper.select();
	}

	@Override
	public ConfigQuestionSecondKind getByQfkId(String qfkId) {
		return configQuestionSecondKindMapper.selectByQfkId(qfkId);
	}

	@Override
	public List<ConfigQuestionSecondKind> listByFirstKindId(String firstKindId) {
		return configQuestionSecondKindMapper.selectByFirstKindId(firstKindId);
	}

	@Override
	public Boolean save(ConfigQuestionSecondKind configQuestionSecondKind) {
		if(configQuestionSecondKindMapper.insert(configQuestionSecondKind) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(ConfigQuestionSecondKind configQuestionSecondKind) {
		if(configQuestionSecondKindMapper.update(configQuestionSecondKind) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(String qfkId) {
		if(configQuestionSecondKindMapper.delete(qfkId) > 0)
			return true;
		return false;
	}
	
}
