package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageExamDetailsMapper;
import com.hr.pojo.EngageExamDetails;
import com.hr.service.EngageExamDetailsService;

@Service
public class EngageExamDetailsServiceImpl implements EngageExamDetailsService{
	@Autowired
	EngageExamDetailsMapper engageExamDetailsMapper;
	
	@Override
	public List<EngageExamDetails> listAll() {
		return engageExamDetailsMapper.select();
	}

	@Override
	public Boolean save(EngageExamDetails engageExamDetails) {
		if(engageExamDetailsMapper.insert(engageExamDetails) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(EngageExamDetails engageExamDetails) {
		if(engageExamDetailsMapper.update(engageExamDetails) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(int exd_id) {
		if(engageExamDetailsMapper.delete(exd_id) > 0)
			return true;
		return false;
	}

}
