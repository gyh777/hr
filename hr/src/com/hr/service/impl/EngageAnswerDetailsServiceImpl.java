package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.dto.AnswerDetailsDto;
import com.hr.mapper.EngageAnswerDetailsMapper;
import com.hr.pojo.EngageAnswerDetails;
import com.hr.service.EngageAnswerDetailsService;

@Service
public class EngageAnswerDetailsServiceImpl implements EngageAnswerDetailsService {
	@Autowired
	EngageAnswerDetailsMapper engageAnswerDetailsMapper;
	
	@Override
	public List<EngageAnswerDetails> listAll() {
		return engageAnswerDetailsMapper.select();
	}

	@Override
	public Boolean save(EngageAnswerDetails engageAnswerDetails) {
		if(engageAnswerDetailsMapper.insert(engageAnswerDetails) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean update(EngageAnswerDetails engageAnswerDetails) {
		if(engageAnswerDetailsMapper.update(engageAnswerDetails) > 0)
			return true;
		return false;
	}

	@Override
	public Boolean remove(int and_id) {
		if(engageAnswerDetailsMapper.delete(and_id) > 0)
			return true;
		return false;
	}
	
	@Override
	public List<EngageAnswerDetails> listByAnswerNumber(String answer_number) {
		return engageAnswerDetailsMapper.selectByAnswerNumber(answer_number);
	}

	@Override
	public List<AnswerDetailsDto> listByAnswerNumberMap(String answer_number) {
		return engageAnswerDetailsMapper.selectByAnswerNumberMap(answer_number);
	}

}
