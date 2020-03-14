package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigMajor;

public interface ConfigMajorMapper {
    public List<ConfigMajor> selectAllConfigMajor();
    public boolean deleteConfigMajor(int makId);
	public boolean addConfigMajor(ConfigMajor cm);
}
