package com.hr.service.impl;

import java.util.Date;
import java.util.List;

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

	@Override
	public List<MajorChange> selectAllNotCheckMajorChange() {
		// TODO Auto-generated method stub
		return mapper.selectAllNotCheckMajorChange();
	}

	@Override
	public List<MajorChange> selectAllMajorChange() {
		// TODO Auto-generated method stub
		return mapper.selectAllMajorChange();
	}

	@Override
	public boolean deleteMajorChangeByMchId(Short mch_id) {
		// TODO Auto-generated method stub
		return mapper.deleteMajorChangeByMchId(mch_id);
	}

	@Override
	public boolean updateCheckStatus(Short mch_id,Short check_status) {
		// TODO Auto-generated method stub
		return mapper.updateCheckStatus(mch_id,check_status);
	}

	@Override
	public boolean updateCheckResult(Short mch_id, String checker,
			String check_status, Date check_time, String check_reason) {
		// TODO Auto-generated method stub
		return mapper.updateCheckResult(mch_id, checker, check_status, check_time, check_reason);
	}
	
}
