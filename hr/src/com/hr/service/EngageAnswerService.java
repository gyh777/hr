package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.EngageAnswer;

public interface EngageAnswerService {
	public List<EngageAnswer> listAll();
	public Boolean save(EngageAnswer engageAnswer);
	public Boolean update(EngageAnswer engageAnswer);
	public Boolean remove(int ans_id);
	public List<EngageAnswer> find(String human_idcard, String keyWord, String start, String end);
	public EngageAnswer getByAnsId(int ans_id);
}
