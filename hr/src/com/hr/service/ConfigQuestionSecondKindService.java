package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigQuestionSecondKind;

public interface ConfigQuestionSecondKindService {
	public List<ConfigQuestionSecondKind> list();
	
	public ConfigQuestionSecondKind getByQfkId(String qfkId);
	
	public List<ConfigQuestionSecondKind> listByFirstKindId(String firstKindId);
	
	public Boolean save(ConfigQuestionSecondKind configQuestionSecondKind);
	
	public Boolean update(ConfigQuestionSecondKind configQuestionSecondKind);
	
	public Boolean remove(String qfkId);
}
