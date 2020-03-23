package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageAnswerMapper;
import com.hr.pojo.EngageAnswer;
import com.hr.service.EngageAnswerService;

@Service
public class EngageAnswerServiceImpl implements EngageAnswerService{
	@Autowired
	EngageAnswerMapper engageAnswerMapper;
	
	@Override
	public List<EngageAnswer> listAll() {
		return engageAnswerMapper.select();
	}

	@Override
	public Boolean save(EngageAnswer engageAnswer) {
		if(engageAnswerMapper.insert(engageAnswer) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(EngageAnswer engageAnswer) {
		if(engageAnswerMapper.update(engageAnswer) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(int ans_id) {
		if(engageAnswerMapper.delete(ans_id) > 0)
			return true;
		return false;
	}

	@Override
	public List<EngageAnswer> find(String human_idcard, String keyWord,
			String start, String end) {
		return engageAnswerMapper.find(human_idcard, keyWord, start, end);
	}

	@Override
	public EngageAnswer getByAnsId(int ans_id) {
		return engageAnswerMapper.selectByAnsId(ans_id);
	}
	
}
