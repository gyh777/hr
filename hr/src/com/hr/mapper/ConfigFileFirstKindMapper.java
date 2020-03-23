package com.hr.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigFileFirstKind;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigFileFirstKindMapper {
	public boolean addConfigFileFirstKind(ConfigFileFirstKind ffk);
    public boolean removeConfigFileFirstKind(@Param("first_kind_id") String ffkId);
    public boolean updateConfigFileFirstKind(ConfigFileFirstKind ffk);
    public ConfigFileFirstKind queryConfigFileFirstKindById(@Param("first_kind_id") String ffkId);
    public List<ConfigFileFirstKind> queryAllConfigFileFirstKind();
    public List<TwoStringValue> queryConfigFileFirstKindIdAndName();
    public String queryIdByName(String first_kind_name);
    List<ConfigFileFirstKind> getAllFirstByPage(@Param("currPage")Integer pageNo,@Param("pageSize")Integer pageSize);

}

