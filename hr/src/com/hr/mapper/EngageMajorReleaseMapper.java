package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.EngageMajorRelease;

public interface EngageMajorReleaseMapper {
	public boolean addEngageMajorRelease(EngageMajorRelease emr);
	public List<EngageMajorRelease> selectAllEngageMajorRelease();
}
