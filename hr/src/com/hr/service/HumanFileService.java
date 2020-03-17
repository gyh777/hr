package com.hr.service;

import java.util.List;

import com.hr.pojo.HumanFile;

public interface HumanFileService {
	public boolean addHumanFile(HumanFile huf);
    public boolean removeHumanFile(String name);
    public boolean updateHumanFile(HumanFile huf);
    public HumanFile queryHumanFileByName(String name);
    public List<HumanFile> queryAllHumanFile();
}
