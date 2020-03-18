package com.hr.mapper;

import java.util.List;

import com.hr.pojo.Bonus;
import com.hr.pojo.HumanFileDig;
import com.hr.pojo.HumanFileDig;

public interface HumanFileDigMapper {
	public boolean addHumanFileDigDig(HumanFileDig hfd);
    public boolean removeHumanFileDig(String name);
    public boolean updateHumanFileDig(HumanFileDig hfd);
    public HumanFileDig queryHumanFileDigByName(String name);
    public List<HumanFileDig> queryAllHumanFileDig();
    public HumanFileDig queryHumanFileDigByHfd_id(int hfd_id);
}
