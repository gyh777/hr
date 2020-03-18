package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.HumanFileMapper;
import com.hr.pojo.HumanFile;
import com.hr.service.HumanFileService;

@Service
public class HumanFileServiceImpl implements HumanFileService {
    @Autowired
    HumanFileMapper humanFileMapper;
	
	@Override
	public boolean addHumanFile(HumanFile huf) {
		// TODO Auto-generated method stub
		return humanFileMapper.addHumanFile(huf);
	}

	@Override
	public boolean removeHumanFile(String name) {
		// TODO Auto-generated method stub
		return humanFileMapper.removeHumanFile(name);
	}

	@Override
	public boolean updateHumanFile(HumanFile huf) {
		// TODO Auto-generated method stub
		return humanFileMapper.updateHumanFile(huf);
	}

	@Override
	public HumanFile queryHumanFileByName(String name) {
		// TODO Auto-generated method stub
		return humanFileMapper.queryHumanFileByName(name);
	}

	@Override
	public List<HumanFile> queryAllHumanFile() {
		// TODO Auto-generated method stub
		return humanFileMapper.queryAllHumanFile();
	}

	@Override
	public List<HumanFile> queryAllHumanFileByStatus(int status) {
		// TODO Auto-generated method stub
		return humanFileMapper.queryAllHumanFileByStatus(status);
	}

	@Override
	public HumanFile queryHumanFileByHuf_id(int huf_id) {
		// TODO Auto-generated method stub
		return humanFileMapper.queryHumanFileByHuf_id(huf_id);
	}

}
