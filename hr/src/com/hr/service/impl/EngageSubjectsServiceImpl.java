package com.hr.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageSubjectsMapper;
import com.hr.pojo.EngageSubjects;
import com.hr.service.EngageSubjectsService;

@Service
public class EngageSubjectsServiceImpl implements EngageSubjectsService{
	@Autowired
	EngageSubjectsMapper engageSubjectsMapper;
	
	public List<EngageSubjects> listAll(){
		return engageSubjectsMapper.selectAll();
	}
	
	public Boolean save(EngageSubjects engageSubjects){
		if(engageSubjectsMapper.insert(engageSubjects) > 0)
			return true;
		return false;
	}
	public Boolean update(EngageSubjects engageSubjects){
		if(engageSubjectsMapper.update(engageSubjects) > 0)
			return true;
		return false;
	}
	
	public List<EngageSubjects> listEngageSubjects(String firstKindName,
			String keyWord, String start, String end) {
		return engageSubjectsMapper.select(firstKindName, keyWord, start, end);
	}

	@Override
	public EngageSubjects getBySubId(String sub_id) {
		return engageSubjectsMapper.selectBySubId(sub_id);
	}

	@Override
	public Boolean delete(String sub_id) {
		if(engageSubjectsMapper.delete(sub_id) > 0)
			return true;
		return false;
	}

	@Override
	public int getCount(String first_kind_id, String second_kind_id) {
		return engageSubjectsMapper.selectCount(first_kind_id, second_kind_id);
	}

	@Override
	public List<EngageSubjects> listByKindId(String first_kind_id, String second_kind_id) {
		return engageSubjectsMapper.selectByKindId(first_kind_id, second_kind_id);
	}
}
