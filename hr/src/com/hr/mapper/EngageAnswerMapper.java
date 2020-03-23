package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageAnswer;

public interface EngageAnswerMapper {
	public List<EngageAnswer> select();
	public int insert(EngageAnswer engageAnswer);
	public int update(EngageAnswer engageAnswer);
	public int delete(@Param("ans_id") int ans_id);
	public List<EngageAnswer> find(@Param("human_idcard")String human_idcard, 
			@Param("keyWord") String keyWord, @Param("start") String start, @Param("end") String end);
	public EngageAnswer selectByAnsId(@Param("ans_id") int ans_id);
}
