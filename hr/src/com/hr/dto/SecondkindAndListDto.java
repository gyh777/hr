package com.hr.dto;

import java.io.Serializable;
import java.util.List;

import com.hr.pojo.ConfigFileSecondKind;
import com.hr.pojo.ConfigFileThirdKind;

public class SecondkindAndListDto implements Serializable {
   private ConfigFileSecondKind configFileSecondKind;
   private List<ConfigFileSecondKind> list;

public ConfigFileSecondKind getConfigFileSecondKind() {
	return configFileSecondKind;
}
public void setConfigFileSecondKind(ConfigFileSecondKind configFileSecondKind) {
	this.configFileSecondKind = configFileSecondKind;
}
public List<ConfigFileSecondKind> getList() {
	return list;
}
public void setList(List<ConfigFileSecondKind> list) {
	this.list = list;
}

}
