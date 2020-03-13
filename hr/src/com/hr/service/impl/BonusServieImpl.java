package com.hr.service.impl;

import java.util.List;

import com.hr.mapper.BonusMapper;
import com.hr.pojo.Bonus;
import com.hr.service.BonusService;

public class BonusServieImpl implements BonusService {
    BonusMapper bonusMapper = null;

	@Override
	public boolean saveBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		return bonusMapper.saveBonus(bonus);
	}

	@Override
	public List<Bonus> selectAllBonus() {
		// TODO Auto-generated method stub
		return bonusMapper.selectAllBonus();
	}

	@Override
	public Bonus selectBonusByBon_id(int bon_id) {
		// TODO Auto-generated method stub
		return bonusMapper.selectBonusByBon_id(bon_id);
	}

	@Override
	public boolean deleteStudentByBon_id(int bon_id) {
		// TODO Auto-generated method stub
		return bonusMapper.deleteStudentByBon_id(bon_id);
	}

	@Override
	public boolean updateBonus(Bonus bonus) {
		// TODO Auto-generated method stub
		return bonusMapper.updateBonus(bonus);
	}
}
