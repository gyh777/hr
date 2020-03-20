package com.hr.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageSubjects;

public interface EngageSubjectsMapper {
	public List<EngageSubjects> selectAll();
	public EngageSubjects selectBySubId(String sub_id);
	public int delete(@Param("sub_id") String sub_id);
	public int insert(EngageSubjects engageSubjects);
	public int update(EngageSubjects engageSubjects);
	public List<EngageSubjects> select(@Param("firstKindName") String firstKindName, @Param("keyWord") String keyWord, @Param("start") String start, @Param("end") String end);
	public int selectCount(@Param("first_kind_id") String first_kind_id,@Param("second_kind_id") String second_kind_id);
}
