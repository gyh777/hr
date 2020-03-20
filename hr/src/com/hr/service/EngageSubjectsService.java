package com.hr.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.EngageSubjects;

public interface EngageSubjectsService {
	public List<EngageSubjects> listAll();
	public EngageSubjects getBySubId(String sub_id);
	public Boolean delete(String sub_id);
	public Boolean save(EngageSubjects engageSubjects);
	public Boolean update(EngageSubjects engageSubjects);
	public List<EngageSubjects> listEngageSubjects(String firstKindName, String keyWord, String start, String end);
	public int getCount(String first_kind_id, String second_kind_id);
	public List<EngageSubjects> listByKindId(String first_kind_id, String second_kind_id);
}
