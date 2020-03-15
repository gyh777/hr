package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigMajorKind;

public interface ConfigMajorKindMapper {
    public List<ConfigMajorKind> selectAllConfigMajorKind();
    public boolean deleteConfigMajorKind(String major_kind_name);
	public boolean addConfigMajorKind(ConfigMajorKind cmk);
}
