package com.hr.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigMajorKind;
import com.hr.web.controller.requestparamtype.TwoStringValue;

public interface ConfigMajorKindService {
    public List<ConfigMajorKind> selectAllConfigMajorKind();
	public List<TwoStringValue> selectAllConfigMajorKindIdAndName();
    public String selectConfigMajorKindIdByName(String major_kind_name);
    public boolean deleteConfigMajorKind(String major_kind_name);
	public boolean addConfigMajorKind(ConfigMajorKind ck);
}
