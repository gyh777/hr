package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigMajor;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigMajorService {
    public List<ConfigMajor> selectAllConfigMajor();
    public List<TwoStringValue> selectAllConfigMajorIdAndName(String major_kind_name);
    public String selectConfigMajorIdByName(String major_name);
    public boolean deleteConfigMajor(String major_name);
	public boolean addConfigMajor(ConfigMajor cm);
	
	public ConfigMajor getByMajorName(String major_name);
}
