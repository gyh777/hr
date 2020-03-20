package com.hr.dto;

import java.io.Serializable;

import com.hr.pojo.ConfigMajor;

public class EngageExamDto implements Serializable{
	ConfigMajor configMajor;
    private int count;
    
	public ConfigMajor getConfigMajor() {
		return configMajor;
	}
	public void setConfigMajor(ConfigMajor configMajor) {
		this.configMajor = configMajor;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
