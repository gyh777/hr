package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigFileFirstKind;

public interface ConfigFileFirstKindMapper {
	public boolean addConfigFileFirstKind(ConfigFileFirstKind ffk);
    public boolean removeConfigFileFirstKind(@Param("first_kind_id") String ffkId);
    public boolean updateConfigFileFirstKind(ConfigFileFirstKind ffk);
    public ConfigFileFirstKind queryConfigFileFirstKindById(@Param("first_kind_id") String ffkId);
    public List<ConfigFileFirstKind> queryAllConfigFileFirstKind();
}
