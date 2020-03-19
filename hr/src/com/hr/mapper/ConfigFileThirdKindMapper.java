package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigFileThirdKind;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigFileThirdKindMapper {
	public boolean addConfigFileThirdKind(ConfigFileThirdKind ftk);
    public boolean removeConfigFileThirdKind(int ftkId);
    public boolean updateConfigFileThirdKind(ConfigFileThirdKind ftk);
    public ConfigFileThirdKind queryConfigFileThirdKindById(int ftkId);
    public List<ConfigFileThirdKind> queryAllConfigFileThirdKind();
    public String queryIdByName(String third_kind_name);
    public List<TwoStringValue> queryKindIdAndName(
    		@Param("first_kind_name")String first_kind_name,
    		@Param("second_kind_name")String second_kind_name);
}
