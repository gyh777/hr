package com.hr.mapper;

import java.util.List;

import com.hr.pojo.HumanFile;

public interface HumanFileMapper {
	public boolean addHumanFile(HumanFile huf);
    public boolean removeHumanFile(String name);
    public boolean updateHumanFile(HumanFile huf);
    public HumanFile queryHumanFileByName(String name);
    public List<HumanFile> queryAllHumanFile();
    public List<HumanFile> queryAllHumanFileByStatus(int status);
    public HumanFile queryHumanFileByHuf_id(int huf_id);
    public int queryIdByName(String huf_id);
}
