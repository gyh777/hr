package com.hr.service;

import java.util.List;

import com.hr.pojo.ConfigPublicChar;

public interface ConfigPublicCharService {
    public List<ConfigPublicChar> selectAllConfigPublicChar();
    public boolean deleteConfigPublicChar(String attribute_kind ,String attribute_name);
	public boolean addConfigPublicChar(ConfigPublicChar cpc);
}
