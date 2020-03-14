package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigQuestionFirstKind;

public interface ConfigQuestionFirstKindService {
	public List<ConfigQuestionFirstKind> listConfigQuestionFirstKind();
	
	public ConfigQuestionFirstKind getByFirstKindId(String first_kind_id);
	
	public ConfigQuestionFirstKind getConfigQuestionFirstKind(@Param("qfkId") String qfkId);
	
	public Boolean save(ConfigQuestionFirstKind configQuestionFirstKind);
	
	public Boolean update(ConfigQuestionFirstKind configQuestionFirstKind);
	
	public Boolean remove(@Param("qfkId") String qfkId);
}
