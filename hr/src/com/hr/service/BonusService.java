package com.hr.service;

import java.util.List;

import com.hr.pojo.Bonus;

public interface BonusService {
	public boolean saveBonus(Bonus bonus);
	public List<Bonus> selectAllBonus();
	public Bonus selectBonusByBon_id(int bon_id);
	public boolean deleteStudentByBon_id(int bon_id);
	public boolean updateBonus(Bonus bonus);
}
