package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigFileThirdKind;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigFileThirdKindService {
	public boolean addConfigFileThirdKind(ConfigFileThirdKind ftk);
    public boolean removeConfigFileThirdKind(String ftkId);
    public boolean updateConfigFileThirdKind(ConfigFileThirdKind ftk);
    public ConfigFileThirdKind queryConfigFileThirdKindById(String ftkId);
    public List<ConfigFileThirdKind> queryAllConfigFileThirdKind();
    public String queryIdByName(String third_kind_id);
    public List<TwoStringValue> queryKindIdAndName(
    		String first_kind_name,String second_kind_name);
}
