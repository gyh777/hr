package com.hr.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageMajorReleaseMapper;
import com.hr.pojo.EngageMajorRelease;
import com.hr.service.EngageMajorReleaseService;

@Service
public class EngageMajorReleaseServiceImpl implements EngageMajorReleaseService{
	@Autowired
	EngageMajorReleaseMapper engageMajorReleaseMapper;

	@Override
	public boolean addEngageMajorRelease(EngageMajorRelease emr) {
		// TODO Auto-generated method stub
		return engageMajorReleaseMapper.addEngageMajorRelease(emr);
	}

}
