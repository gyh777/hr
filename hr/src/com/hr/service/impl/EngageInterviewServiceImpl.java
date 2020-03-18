package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageInterviewMapper;
import com.hr.pojo.EngageInterview;
import com.hr.service.EngageInterviewService;

@Service
public class EngageInterviewServiceImpl implements EngageInterviewService{
	@Autowired
	EngageInterviewMapper engageInterviewMapper;
	
	@Override
	public List<EngageInterview> listAll() {
		return engageInterviewMapper.select();
	}

	@Override
	public EngageInterview getByEinId(int ein_id) {
		return engageInterviewMapper.selectByEinId(ein_id);
	}

	@Override
	public Boolean save(EngageInterview engageInterview) {
		if(engageInterviewMapper.insert(engageInterview) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(EngageInterview engageInterview) {
		if(engageInterviewMapper.update(engageInterview) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(int ein_id) {
		if(engageInterviewMapper.delete(ein_id) > 0)
			return true;
		return false;
	}

	@Override
	public EngageInterview getByResumeId(int resume_id) {
		return engageInterviewMapper.selectByResumeId(resume_id);
	}

}
