package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageExam;

public interface EngageExamMapper {
	public List<EngageExam> select();
	public int selectCount(@Param("major_kind_id") String major_kind_id,@Param("major_id") String major_id);
	public int insert(EngageExam engageExam);
	public int update(EngageExam engageExam);
	public int delete(int exa_id);
}
