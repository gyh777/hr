package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigFileSecondKind;
import com.hr.pojo.ConfigFileThirdKind;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigFileSecondKindService {
	public boolean addConfigFileSecondKind(ConfigFileSecondKind fsk);
    public boolean removeConfigFileSecondKind(String fskId);
    public boolean updateConfigFileSecondKind(ConfigFileSecondKind fsk);
    public ConfigFileSecondKind queryConfigFileSecondKindById(String fskId);
    public List<ConfigFileSecondKind> queryAllConfigFileSecondKind();
    public String queryIdByName(String second_kind_name);
    public List<TwoStringValue> queryIdAndNameByFirstKindName(String first_kind_name);
    List<ConfigFileSecondKind> queryAllSecondByPage(ConfigFileSecondKind t);
}
