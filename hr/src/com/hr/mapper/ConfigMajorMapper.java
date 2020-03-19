package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigMajor;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigMajorMapper {
    public List<ConfigMajor> selectAllConfigMajor();
	public List<TwoStringValue> selectAllConfigMajorIdAndName(
			@Param("major_kind_name")String major_kind_name);
    public String selectConfigMajorIdByName(@Param("major_name")String major_name);
    public boolean deleteConfigMajor(@Param("major_name")String major_name);
	public boolean addConfigMajor(ConfigMajor cm);
}
