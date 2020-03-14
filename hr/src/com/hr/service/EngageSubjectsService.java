package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.EngageSubjects;

public interface EngageSubjectsService {
	public Boolean save(EngageSubjects engageSubjects);
	public Boolean update(EngageSubjects engageSubjects);
	public List<EngageSubjects> listEngageSubjects(String firstKindName, String keyWord, String start, String end);
}
