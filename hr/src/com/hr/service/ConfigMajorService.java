package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigMajor;

public interface ConfigMajorService {
    public List<ConfigMajor> selectAllConfigMajor();
    public boolean deleteConfigMajor(int makId);
	public boolean addConfigMajor(ConfigMajor cm);
}
