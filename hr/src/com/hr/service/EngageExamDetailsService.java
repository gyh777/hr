package com.hr.service;

import java.util.List;

import com.hr.pojo.EngageExamDetails;

public interface EngageExamDetailsService {
	public List<EngageExamDetails> listAll();
	public Boolean save(EngageExamDetails engageExamDetails);
	public Boolean update(EngageExamDetails engageExamDetails);
	public Boolean remove(int exd_id);
}
