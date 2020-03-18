package com.hr.pojo;

import java.util.Date;

public class EngageInterview {
    private int ein_id;	//主键id
    private String human_name;	//姓名
    private int interview_amount;	//面试次数
    private String human_major_kind_id;	//职位分类id
    private String human_major_kind_name;	//职位分类
    private String human_major_id;	//职位名称id
    private String human_major_name;	//职位名称
    private String image_degree;	//形象评价
    private String native_language_degree;	//口才评价
    private String foreign_language_degree;	//外语口语评价
    private String response_speed_degree;	//应变能力
    private String eq_degree;	//EQ
    private String iq_degree;	//IQ
    private String multi_quality_degree;	//综合素质
    private String register;	//登记人姓名
    private String checker;	//审核人姓名
    private Date registe_time;	//登记时间
    private Date check_time;	//审核时间
    private Short resume_id;	//
    private String result;   	//面试结果
    private String interview_comment;   //面试意见
    private String check_comment;	//审核意见
    private Short interview_status;	//面试状态
    private Short check_status;	//审核状态

	public int getEinId() {
		return ein_id;
	}

	public void setEinId(int ein_id) {
		this.ein_id = ein_id;
	}

	public String getHuman_name() {
		return human_name;
	}

	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}

	public int getInterview_amount() {
		return interview_amount;
	}

	public void setInterview_amount(int interview_amount) {
		this.interview_amount = interview_amount;
	}

	public String getHuman_major_kind_id() {
		return human_major_kind_id;
	}

	public void setHuman_major_kind_id(String human_major_kind_id) {
		this.human_major_kind_id = human_major_kind_id;
	}

	public String getHuman_major_kind_name() {
		return human_major_kind_name;
	}

	public void setHuman_major_kind_name(String human_major_kind_name) {
		this.human_major_kind_name = human_major_kind_name;
	}

	public String getHuman_major_id() {
		return human_major_id;
	}

	public void setHuman_major_id(String human_major_id) {
		this.human_major_id = human_major_id;
	}

	public String getHuman_major_name() {
		return human_major_name;
	}

	public void setHuman_major_name(String human_major_name) {
		this.human_major_name = human_major_name;
	}

	public String getImage_degree() {
		return image_degree;
	}

	public void setImage_degree(String image_degree) {
		this.image_degree = image_degree;
	}

	public String getNative_language_degree() {
		return native_language_degree;
	}

	public void setNative_language_degree(String native_language_degree) {
		this.native_language_degree = native_language_degree;
	}

	public String getForeign_language_degree() {
		return foreign_language_degree;
	}

	public void setForeign_language_degree(String foreign_language_degree) {
		this.foreign_language_degree = foreign_language_degree;
	}

	public String getResponse_speed_degree() {
		return response_speed_degree;
	}

	public void setResponse_speed_degree(String response_speed_degree) {
		this.response_speed_degree = response_speed_degree;
	}

	public String getEq_degree() {
		return eq_degree;
	}

	public void setEq_degree(String eq_degree) {
		this.eq_degree = eq_degree;
	}

	public String getIq_degree() {
		return iq_degree;
	}

	public void setIq_degree(String iq_degree) {
		this.iq_degree = iq_degree;
	}

	public String getMulti_quality_degree() {
		return multi_quality_degree;
	}

	public void setMulti_quality_degree(String multi_quality_degree) {
		this.multi_quality_degree = multi_quality_degree;
	}

	public String getRegister() {
		return register;
	}

	public void setRegister(String register) {
		this.register = register;
	}

	public String getChecker() {
		return checker;
	}

	public void setChecker(String checker) {
		this.checker = checker;
	}

	public Date getRegiste_time() {
		return registe_time;
	}

	public void setRegiste_time(Date registe_time) {
		this.registe_time = registe_time;
	}

	public Date getCheck_time() {
		return check_time;
	}

	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}

	public Short getResume_id() {
		return resume_id;
	}

	public void setResume_id(Short resume_id) {
		this.resume_id = resume_id;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getInterview_comment() {
		return interview_comment;
	}

	public void setInterview_comment(String interview_comment) {
		this.interview_comment = interview_comment;
	}

	public String getCheck_comment() {
		return check_comment;
	}

	public void setCheck_comment(String check_comment) {
		this.check_comment = check_comment;
	}

	public Short getInterview_status() {
		return interview_status;
	}

	public void setInterview_status(Short interview_status) {
		this.interview_status = interview_status;
	}

	public Short getCheck_status() {
		return check_status;
	}

	public void setCheck_status(Short check_status) {
		this.check_status = check_status;
	}

}