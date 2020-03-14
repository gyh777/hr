package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigFileThirdKind;

public interface ConfigFileThirdKindService {
	public boolean addConfigFileThirdKind(ConfigFileThirdKind ftk);
    public boolean removeConfigFileThirdKind(int ftkId);
    public boolean updateConfigFileThirdKind(ConfigFileThirdKind ftk);
    public ConfigFileThirdKind queryConfigFileThirdKindById(int ftkId);
    public List<ConfigFileThirdKind> queryAllConfigFileThirdKind();
}
