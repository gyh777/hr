package com.hr.service;

import java.util.List;

import com.hr.pojo.HumanFile;
import com.hr.web.controller.requestparamtype.HumanFileSomeValue;

public interface HumanFileService {
	public boolean addHumanFile(HumanFile huf);
    public boolean removeHumanFile(String name);
    public boolean updateHumanFile(HumanFile huf);
    public HumanFile queryHumanFileByName(String name);
    public List<HumanFile> queryAllHumanFile();
    public List<HumanFile> queryAllHumanFileByStatus(int status);
    public HumanFile queryHumanFileByHuf_id(int huf_id);
    public List<HumanFileSomeValue> queryNormalHumanFileSomeValue();
    public boolean updateHumanFileStatus(String huf_id,String human_file_status);
    public boolean updateStatus(HumanFile hf);
    public List<HumanFile> queryFileByCheckstatus(Short s);
}
