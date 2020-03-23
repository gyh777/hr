package com.hr.pojo;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class SalaryStandard  implements Serializable{
	
	DateFormat format= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"); 
    private Short ssdId;

    private String standardId;

    private String standardName;

    private String designer;

    private String register;

    private String checker;

    private String changer;
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date registTime;
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date checkTime;
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date changeTime;

    private String salarySum;

    private Short checkStatus;

    private Short changeStatus;
    
    private String checkComment;
    
    private String remark;

    public String getCheckComment() {
		return checkComment;
	}

	public void setCheckComment(String checkComment) {
		this.checkComment = checkComment;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Short getSsdId() {
        return ssdId;
    }

    public void setSsdId(Short ssdId) {
        this.ssdId = ssdId;
    }

    public String getStandardId() {
        return standardId;
    }

    public void setStandardId(String standardId) {
        this.standardId = standardId == null ? null : standardId.trim();
    }

    public String getStandardName() {
        return standardName;
    }

    public void setStandardName(String standardName) {
        this.standardName = standardName == null ? null : standardName.trim();
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer == null ? null : designer.trim();
    }

    public String getRegister() {
        return register;
    }

    public void setRegister(String register) {
        this.register = register == null ? null : register.trim();
    }

    public String getChecker() {
        return checker;
    }

    public void setChecker(String checker) {
        this.checker = checker == null ? null : checker.trim();
    }

    public String getChanger() {
        return changer;
    }

    public void setChanger(String changer) {
        this.changer = changer == null ? null : changer.trim();
    }

   

    public Date getRegistTime() {
		return registTime;
	}

	public void setRegistTime(String registTime) {
		try {
			this.registTime = format.parse(registTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(String checkTime) {
		try {
			this.checkTime = format.parse(checkTime);
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
	}

	public Date getChangeTime() {
		return changeTime;
	}

	public void setChangeTime(String changeTime) {
		try {
			this.changeTime = format.parse(changeTime);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getSalarySum() {
        return salarySum;
    }

    public void setSalarySum(String salarySum) {
        this.salarySum = salarySum;
    }

    public Short getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(Short checkStatus) {
        this.checkStatus = checkStatus;
    }

    public Short getChangeStatus() {
        return changeStatus;
    }

    public void setChangeStatus(Short changeStatus) {
        this.changeStatus = changeStatus;
    }

	@Override
	public String toString() {
		return "SalaryStandard [ssdId=" + ssdId + ", standardId=" + standardId
				+ ", standardName=" + standardName + ", designer=" + designer
				+ ", register=" + register + ", checker=" + checker
				+ ", changer=" + changer + ", registTime=" + registTime
				+ ", checkTime=" + checkTime + ", changeTime=" + changeTime
				+ ", salarySum=" + salarySum + ", checkStatus=" + checkStatus
				+ ", changeStatus=" + changeStatus + "]";
	}
    
}