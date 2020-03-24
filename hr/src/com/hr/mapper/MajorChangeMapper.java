package com.hr.mapper;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.Bonus;
import com.hr.pojo.MajorChange;

public interface MajorChangeMapper {
	public boolean addMajorChange(MajorChange mc);
	public List<MajorChange> selectAllNotCheckMajorChange();
	public List<MajorChange> selectAllMajorChange();
	public boolean deleteMajorChangeByMchId(Short mch_id);
	public boolean updateCheckStatus(
			@Param("mch_id")Short mch_id,@Param("check_status")Short check_status);
	public boolean updateCheckResult(@Param("mch_id")Short mch_id,
			@Param("checker")String checker,@Param("check_status")String check_status,
			@Param("check_time")Date check_time,@Param("check_reason")String check_reason);
}
