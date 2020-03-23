package com.hr.service;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigFileFirstKind;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigFileFirstKindService {
	public boolean addConfigFileFirstKind(ConfigFileFirstKind ffk);
    public boolean removeConfigFileFirstKind(String ffkId);
    public boolean updateConfigFileFirstKind(ConfigFileFirstKind ffk);
    public ConfigFileFirstKind queryConfigFileFirstKindById(String ffkId);
    public List<ConfigFileFirstKind> queryAllConfigFileFirstKind();
    public List<TwoStringValue> queryConfigFileFirstKindIdAndName();
    public String queryIdByName(String three_kind_name);
    List<ConfigFileFirstKind> getAllFirstByPage(@Param("currPage")Integer pageNo,@Param("pageSize")Integer pageSize);

}
