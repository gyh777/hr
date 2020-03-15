package com.hr.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.hr.pojo.ConfigPublicChar;

public interface ConfigPublicCharMapper {
    public List<ConfigPublicChar> selectAllConfigPublicChar();
    public List<String> selectTheSameAttribute(String attribute_kind);
    public boolean deleteConfigPublicChar(@Param("attribute_kind") String attribute_kind 
    											,@Param("attribute_name") String attribute_name);
	public boolean addConfigPublicChar(ConfigPublicChar cpc);
}
