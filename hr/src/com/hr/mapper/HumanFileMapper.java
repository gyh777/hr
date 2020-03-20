package com.hr.mapper;

import java.util.List;

import com.hr.pojo.HumanFile;
import com.hr.web.controller.requestparamtype.HunanFileHumanIdAndName;

public interface HumanFileMapper {
	public boolean addHumanFile(HumanFile huf);
    public boolean removeHumanFile(String name);
    public boolean updateHumanFile(HumanFile huf);
    public HumanFile queryHumanFileByName(String name);
    public List<HumanFile> queryAllHumanFile();
    public List<HumanFile> queryAllHumanFileByStatus(int status);
    public HumanFile queryHumanFileByHuf_id(int huf_id);
    public int queryIdByName(String huf_id);
    
    //向宇加===========
    public List<HunanFileHumanIdAndName> queryHumanFileByKindIdOne(String first_kind_id);
    public List<HunanFileHumanIdAndName> queryHumanFileByKindIdtwo(String first_kind_id,String second_kind_id);
    public List<HunanFileHumanIdAndName> queryHumanFileByKindIdThree(String first_kind_id,String second_kind_id,String third_kind_id);
    //===============
}
