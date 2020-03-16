package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigFileSecondKind;

public interface ConfigFileSecondKindService {
	public boolean addConfigFileSecondKind(ConfigFileSecondKind fsk);
    public boolean removeConfigFileSecondKind(String fskId);
    public boolean updateConfigFileSecondKind(ConfigFileSecondKind fsk);
    public ConfigFileSecondKind queryConfigFileSecondKindById(String fskId);
    public List<ConfigFileSecondKind> queryAllConfigFileSecondKind();
}
