package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.ConfigQuestionSecondKind;

public interface ConfigQuestionSecondKindMapper {
	public List<ConfigQuestionSecondKind> select();
	
	public ConfigQuestionSecondKind selectByQfkId(@Param("qsk_id") String qfkId);
	
	public List<ConfigQuestionSecondKind> selectByFirstKindId(@Param("first_kind_id") String firstKindId);
	
	public int insert(ConfigQuestionSecondKind configQuestionSecondKind);
	
	public int update(ConfigQuestionSecondKind configQuestionSecondKind);
	
	public int delete(@Param("qsk_id") String qfkId);
}
