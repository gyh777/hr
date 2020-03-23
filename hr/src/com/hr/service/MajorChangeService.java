package com.hr.service;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.MajorChange;

public interface MajorChangeService {
	public boolean addMajorChange(MajorChange mc);
	public List<MajorChange> selectAllNotCheckMajorChange();
	public List<MajorChange> selectAllMajorChange();
	public boolean deleteMajorChangeByMchId(Short mch_id);
	public boolean updateCheckStatus(Short mch_id,String check_status);
	public boolean updateCheckResult(Short mch_id,String checker,String check_status,
											Date check_time,String check_reason);
}
