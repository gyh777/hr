package com.hr.mapper;

import java.util.List;

import com.hr.pojo.HumanFile;

public interface HumanFileMapper {
	public boolean addHumanFile(HumanFile huf);
    public boolean removeHumanFile(int hufId);
    public boolean updateHumanFile(HumanFile huf);
    public HumanFile queryHumanFileById(int hufId);
    public List<HumanFile> queryAllHumanFile();
}
