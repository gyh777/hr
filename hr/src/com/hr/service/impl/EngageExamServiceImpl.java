package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageExamMapper;
import com.hr.pojo.EngageExam;
import com.hr.service.EngageExamService;

@Service
public class EngageExamServiceImpl implements EngageExamService{
	@Autowired
	EngageExamMapper engageExamMapper;
	
	@Override
	public List<EngageExam> listAll() {
		return engageExamMapper.select();
	}

	@Override
	public int getCount(String major_kind_id, String major_id) {
		return engageExamMapper.selectCount(major_kind_id, major_id);
	}

	@Override
	public Boolean save(EngageExam engageExam) {
		if(engageExamMapper.insert(engageExam) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(EngageExam engageExam) {
		if(engageExamMapper.update(engageExam) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(int exa_id) {
		if(engageExamMapper.delete(exa_id) > 0)
			return true;
		return false;
	}
	
}
