package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.dto.AnswerDetailsDto;
import com.hr.pojo.EngageAnswerDetails;

public interface EngageAnswerDetailsMapper {
	public List<EngageAnswerDetails> select();
	public int insert(EngageAnswerDetails engageAnswerDetails);
	public int update(EngageAnswerDetails engageAnswerDetails);
	public int delete(@Param("and_id") int and_id);
	public List<EngageAnswerDetails> selectByAnswerNumber(@Param("answer_number") String answer_number);
	public List<AnswerDetailsDto> selectByAnswerNumberMap(@Param("answer_number") String answer_number);
}
