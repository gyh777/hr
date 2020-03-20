package com.hr.dto;

import java.io.Serializable;

import com.hr.pojo.ConfigQuestionSecondKind;

public class ConfigQuestionDto implements Serializable{
	ConfigQuestionSecondKind configQuestionSecondKind;
	int count;
	public ConfigQuestionSecondKind getConfigQuestionSecondKind() {
		return configQuestionSecondKind;
	}
	public void setConfigQuestionSecondKind(
			ConfigQuestionSecondKind configQuestionSecondKind) {
		this.configQuestionSecondKind = configQuestionSecondKind;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	
}
