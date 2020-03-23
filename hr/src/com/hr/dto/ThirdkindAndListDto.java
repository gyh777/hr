package com.hr.dto;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.ConfigFileThirdKind;

public class ThirdkindAndListDto implements Serializable {
   private ConfigFileThirdKind configFileThirdKind;
   private List<ConfigFileThirdKind> list;
   
public ConfigFileThirdKind getConfigFileThirdKind() {
	return configFileThirdKind;
}
public void setConfigFileThirdKind(ConfigFileThirdKind configFileThirdKind) {
	this.configFileThirdKind = configFileThirdKind;
}
public List<ConfigFileThirdKind> getList() {
	return list;
}
public void setList(List<ConfigFileThirdKind> list) {
	this.list = list;
}
}
