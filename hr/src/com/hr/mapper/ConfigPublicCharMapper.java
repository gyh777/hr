package com.hr.mapper;

import java.util.List;

import com.hr.pojo.ConfigPublicChar;

public interface ConfigPublicCharMapper {
    public List<ConfigPublicChar> selectAllConfigPublicChar();
    public boolean deleteConfigPublicChar(int pbcId);
	public boolean addConfigPublicChar(ConfigPublicChar cpc);
}
