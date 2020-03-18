package com.hr.service;

import java.util.List;

import com.hr.pojo.EngageInterview;

public interface EngageInterviewService {
	public List<EngageInterview> listAll();
	public EngageInterview getByEinId(int ein_id);
	public List<EngageInterview> listForResult();
	public EngageInterview getByResumeId(int resume_id);
	public Boolean save(EngageInterview engageInterview);
	public Boolean update(EngageInterview engageInterview);
	public Boolean updateForResult(String result, String ein_id);
	public Boolean remove(int ein_id);
}
