package com.hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.MajorChangeMapper;
import com.hr.pojo.MajorChange;
import com.hr.service.MajorChangeService;

@Service
public class MajorChangeServiceImpl implements MajorChangeService{
	@Autowired
	MajorChangeMapper mapper;

	@Override
	public boolean addMajorChange(MajorChange mc) {
		// TODO Auto-generated method stub
		return mapper.addMajorChange(mc);
	}
	
}
