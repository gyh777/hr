package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageResume;

public interface EngageResumeMapper {
	public List<EngageResume> select();
	public EngageResume selectByResId(@Param("res_id") int res_id);
	public int insert(EngageResume engageResume);
	public int update(EngageResume engageResume);
	public int delete(@Param("res_id") int res_id);
	public List<EngageResume> find(@Param("human_major_kind_id") String human_major_kind_id,
			@Param("human_major_id") String human_major_id, @Param("keyWord") String keyWord, 
			@Param("start") String start, @Param("end") String end);
	public List<EngageResume> findForEffective(@Param("human_major_kind_id") String human_major_kind_id,
			@Param("human_major_id") String human_major_id, @Param("keyWord") String keyWord, 
			@Param("start") String start, @Param("end") String end);
	public List<EngageResume> findForQuestion(@Param("human_major_kind_id") String human_major_kind_id,
			@Param("human_major_id") String human_major_id, @Param("human_name") String human_name,
			@Param("human_idcard") String human_idcard);
	public List<EngageResume> selectByInterview(@Param("interview_status") int interview_status);
}
