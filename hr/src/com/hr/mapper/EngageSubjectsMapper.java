package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageSubjects;

public interface EngageSubjectsMapper {
	public int insert(EngageSubjects engageSubjects);
	public int update(EngageSubjects engageSubjects);
	public List<EngageSubjects> select(@Param("firstKindName") String firstKindName);
}
