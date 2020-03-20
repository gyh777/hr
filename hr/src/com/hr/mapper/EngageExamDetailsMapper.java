package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageExamDetails;

public interface EngageExamDetailsMapper {
	public List<EngageExamDetails> select();
	public int insert(EngageExamDetails engageExamDetails);
	public int update(EngageExamDetails engageExamDetails);
	public int delete(@Param("exd_id") int exd_id);
	public List<EngageExamDetails> selectByExamNumber(@Param("exam_number") String exam_number);
}
