package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigFileFirstKind;

public interface ConfigFileFirstKindService {
	public boolean addConfigFileFirstKind(ConfigFileFirstKind ffk);
    public boolean removeConfigFileFirstKind(String ffkId);
    public boolean updateConfigFileFirstKind(ConfigFileFirstKind ffk);
    public ConfigFileFirstKind queryConfigFileFirstKindById(String ffkId);
    public List<ConfigFileFirstKind> queryAllConfigFileFirstKind();
}
