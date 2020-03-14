package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigMajorKind;

public interface ConfigMajorKindMapper {
    public List<ConfigMajorKind> selectAllConfigMajorKind();
    public boolean deleteConfigMajorKind(int mfkId);
	public boolean addConfigMajorKind(ConfigMajorKind cmk);
}
