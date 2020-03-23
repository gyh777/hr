package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.dto.AnswerDetailsDto;
import com.hr.pojo.EngageAnswerDetails;

public interface EngageAnswerDetailsService {
	public List<EngageAnswerDetails> listAll();
	public Boolean save(EngageAnswerDetails engageAnswerDetails);
	public Boolean update(EngageAnswerDetails engageAnswerDetails);
	public Boolean remove(int and_id);
	public List<EngageAnswerDetails> listByAnswerNumber(String answer_number);
	public List<AnswerDetailsDto> listByAnswerNumberMap(String answer_number);
}
