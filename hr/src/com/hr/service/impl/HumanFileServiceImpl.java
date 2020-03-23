package com.hr.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hr.mapper.HumanFileMapper;
import com.hr.pojo.HumanFile;
import com.hr.service.HumanFileService;
import com.hr.web.controller.requestparamtype.HumanFileSomeValue;
import com.hr.web.controller.requestparamtype.HunanFileHumanIdAndName;

@Service
public class HumanFileServiceImpl implements HumanFileService {
    @Autowired
    HumanFileMapper humanFileMapper;
    List<HunanFileHumanIdAndName> queryHumanFileByKindId_list = null;
	
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
	
	//向宇加的--通过所属机构查询部门人员id和name
	public List<HunanFileHumanIdAndName> queryHumanFileByKindId(String first_kind_id,String second_kind_id,String third_kind_id){
		if(second_kind_id==null||second_kind_id==""){
			//说明只有一级机构
			queryHumanFileByKindId_list = humanFileMapper.queryHumanFileByKindIdOne(first_kind_id);
		}else if(third_kind_id==null||third_kind_id==""){
			//说明只有一二级机构
			queryHumanFileByKindId_list = humanFileMapper.queryHumanFileByKindIdtwo(first_kind_id,second_kind_id);
		}else if(third_kind_id!=null){
			//说明一二三级机构
			queryHumanFileByKindId_list = humanFileMapper.queryHumanFileByKindIdThree(first_kind_id,second_kind_id,third_kind_id);
		}else{
			queryHumanFileByKindId_list=null;
			}
		return queryHumanFileByKindId_list;
		
	}

	@Override
	public List<HumanFileSomeValue> queryNormalHumanFileSomeValue() {
		// TODO Auto-generated method stub
		return humanFileMapper.queryNormalHumanFileSomeValue();
	}

	@Override
	public boolean updateHumanFileStatus(String huf_id,String human_file_status) {
		// TODO Auto-generated method stub
		return humanFileMapper.updateHumanFileStatus(huf_id,human_file_status);
	}

	@Override
	public boolean updateStatus(HumanFile hf) {
		// TODO Auto-generated method stub
		return humanFileMapper.updateStatus(hf);
	}

}
