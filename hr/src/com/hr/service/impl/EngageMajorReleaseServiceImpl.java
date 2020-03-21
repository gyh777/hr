package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.EngageMajorReleaseMapper;
import com.hr.pojo.EngageMajorRelease;
import com.hr.service.EngageMajorReleaseService;

@Service
public class EngageMajorReleaseServiceImpl implements EngageMajorReleaseService{
	@Autowired
	EngageMajorReleaseMapper mapper;

	@Override
	public boolean addEngageMajorRelease(EngageMajorRelease emr) {
		// TODO Auto-generated method stub
		return mapper.addEngageMajorRelease(emr);
	}

	@Override
	public List<EngageMajorRelease> selectAllEngageMajorRelease() {
		// TODO Auto-generated method stub
		return mapper.selectAllEngageMajorRelease();
	}

	@Override
	public boolean deleteEngageMajorReleaseById(int mre_id) {
		// TODO Auto-generated method stub
		return mapper.deleteEngageMajorReleaseById(mre_id);
	}

	@Override
	public boolean updateEngageMajorRelease(EngageMajorRelease emr) {
		// TODO Auto-generated method stub
		return mapper.updateEngageMajorRelease(emr);
	}

}
