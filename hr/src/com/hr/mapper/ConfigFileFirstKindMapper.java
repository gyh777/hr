package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigFileFirstKind;

public interface ConfigFileFirstKindMapper {
	public boolean addConfigFileFirstKind(ConfigFileFirstKind ffk);
    public boolean removeConfigFileFirstKind(int ffkId);
    public boolean updateConfigFileFirstKind(ConfigFileFirstKind ffk);
    public ConfigFileFirstKind queryConfigFileFirstKindById(int ffkId);
    public List<ConfigFileFirstKind> queryAllConfigFileFirstKind();
}
