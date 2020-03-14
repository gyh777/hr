package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigQuestionFirstKind;

public interface ConfigQuestionFirstKindMapper {
	public List<ConfigQuestionFirstKind> select();
	
	public ConfigQuestionFirstKind selectByQfkId(@Param("qfk_id") String qfkId);
	
	public int insert(ConfigQuestionFirstKind configQuestionFirstKind);
	
	public int update(ConfigQuestionFirstKind configQuestionFirstKind);
	
	public int delete(@Param("qfk_id") String qfkId);
}
