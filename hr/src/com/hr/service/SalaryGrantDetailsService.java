package com.hr.service;

import java.util.List;

import com.hr.pojo.SalaryGrantDetails;

public interface SalaryGrantDetailsService {

	public Boolean save(List<SalaryGrantDetails> list);
	
	public List<SalaryGrantDetails> queryBySgrId(String sgrId);
}
