package com.hr.service;

import java.util.List;

import com.hr.pojo.EngageMajorRelease;

public interface EngageMajorReleaseService {
	public boolean addEngageMajorRelease(EngageMajorRelease emr);
	public List<EngageMajorRelease> selectAllEngageMajorRelease();
	public boolean deleteEngageMajorReleaseById(int mre_id);
}
