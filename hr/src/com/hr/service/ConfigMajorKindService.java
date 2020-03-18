package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigMajorKind;

public interface ConfigMajorKindService {
    public List<ConfigMajorKind> selectAllConfigMajorKind();
    public List<String> selectAllConfigMajorKindName();
    public String selectConfigMajorKindIdByName(String major_kind_name);
    public boolean deleteConfigMajorKind(String major_kind_name);
	public boolean addConfigMajorKind(ConfigMajorKind ck);
}
