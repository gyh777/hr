package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageResumeMapper;
import com.hr.pojo.EngageResume;
import com.hr.service.EngageResumeService;

@Service
public class EngageResumeServiceImpl implements EngageResumeService{
	@Autowired
	EngageResumeMapper engageResumeMapper;
	
	@Override
	public List<EngageResume> listAll() {
		return engageResumeMapper.select();
	}

	@Override
	public EngageResume getByResId(int res_id) {
		return engageResumeMapper.selectByResId(res_id);
	}

	@Override
	public Boolean save(EngageResume engageResume) {
		if(engageResumeMapper.insert(engageResume) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(EngageResume engageResume) {
		if(engageResumeMapper.update(engageResume) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(int res_id) {
		if(engageResumeMapper.delete(res_id) > 0)
			return true;
		return false;
	}
	
}
