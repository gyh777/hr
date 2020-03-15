package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigMajorKind;

public interface ConfigMajorKindService {
    public List<ConfigMajorKind> selectAllConfigMajorKind();
    public boolean deleteConfigMajorKind(String major_kind_name);
	public boolean addConfigMajorKind(ConfigMajorKind ck);
}
