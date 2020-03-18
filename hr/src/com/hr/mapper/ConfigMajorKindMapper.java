package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigMajorKind;

public interface ConfigMajorKindMapper {
    public List<ConfigMajorKind> selectAllConfigMajorKind();
    public List<String> selectAllConfigMajorKindName();
    public String selectConfigMajorKindIdByName(@Param("major_kind_name")String major_kind_name);
    public boolean deleteConfigMajorKind(@Param("major_kind_name")String major_kind_name);
	public boolean addConfigMajorKind(ConfigMajorKind cmk);
}
