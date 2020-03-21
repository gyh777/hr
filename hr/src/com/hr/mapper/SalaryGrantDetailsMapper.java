package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.SalaryGrantDetails;

public interface SalaryGrantDetailsMapper {
	
	public int insert(SalaryGrantDetails list);
	public List<SalaryGrantDetails> selectBySgrId(String sgrId);
}
