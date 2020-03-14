package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigFileThirdKind;

public interface ConfigFileThirdKindMapper {
	public boolean addConfigFileThirdKind(ConfigFileThirdKind ftk);
    public boolean removeConfigFileThirdKind(int ftkId);
    public boolean updateConfigFileThirdKind(ConfigFileThirdKind ftk);
    public ConfigFileThirdKind queryConfigFileThirdKindById(int ftkId);
    public List<ConfigFileThirdKind> queryAllConfigFileThirdKind();
}
