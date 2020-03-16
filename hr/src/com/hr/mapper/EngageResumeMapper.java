package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageResume;

public interface EngageResumeMapper {
	public List<EngageResume> select();
	public EngageResume selectByResId(int res_id);
	public int insert(EngageResume engageResume);
	public int update(EngageResume engageResume);
	public int delete(int res_id);
}
