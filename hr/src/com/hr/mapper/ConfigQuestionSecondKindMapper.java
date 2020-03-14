package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigQuestionSecondKind;

public interface ConfigQuestionSecondKindMapper {
	public List<ConfigQuestionSecondKind> select();
	
	public ConfigQuestionSecondKind selectByQfkId(String qfkId);
	
	public List<ConfigQuestionSecondKind> selectByFirstKindId(String firstKindId);
	
	public int insert(ConfigQuestionSecondKind configQuestionSecondKind);
	
	public int update(ConfigQuestionSecondKind configQuestionSecondKind);
	
	public int delete(String qfkId);
}
