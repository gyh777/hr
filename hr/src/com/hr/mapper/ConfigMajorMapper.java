package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigMajor;

public interface ConfigMajorMapper {
    public List<ConfigMajor> selectAllConfigMajor();
    public boolean deleteConfigMajor(String major_name);
	public boolean addConfigMajor(ConfigMajor cm);
}
