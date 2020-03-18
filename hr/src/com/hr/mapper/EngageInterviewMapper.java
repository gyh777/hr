package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageInterview;

public interface EngageInterviewMapper {
	public List<EngageInterview> select();
	public EngageInterview selectByEinId(int ein_id);
	public EngageInterview selectByResumeId(int ein_id);
	public int insert(EngageInterview engageInterview);
	public int update(EngageInterview engageInterview);
	public int delete(int ein_id);
}
