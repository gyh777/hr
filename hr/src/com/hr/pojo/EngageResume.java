package com.hr.pojo;

import java.util.Date;

public class EngageResume {
    private int res_id;		//主键id
    private String human_name;	//姓名
    private String engage_type;	//招聘类型
    private String human_address;	//地址
    private String human_postcode;	//邮编
    private String human_major_kind_id;	//职位分类id
    private String human_major_kind_name;	//职位分类
    private String human_major_id;	//职位名称id
    private String human_major_name;	//职位名称
    private String human_telephone;	//电话
    private String human_homephone;	//家庭电话
    private String human_mobilephone;	//手机
    private String human_email;	//email
    private String human_hobby;	//兴趣爱好
    private String human_specility;	//特长
    private String human_sex;	//性别
    private String human_religion;	//宗教信仰
    private String human_party;	//政治面貌
    private String human_nationality;	//国籍
    private String human_race;	//民族
    private Date human_birthday;	//生日
    private Short human_age;	//年龄
    private String human_educated_degree;	//教育程度
    private Short human_educated_years;	//教育年限
    private String human_educated_major;	//专业
    private String human_college;	//毕业院校
    private String human_idcard;	//身份证号
    private String human_birthplace;	//出生地
    private Double demand_salary_standard;	//薪酬标准
    private String human_history_records;	//个人履历
    private String remark;	//备注
    private String recomandation;	//推荐意见
    private String human_picture;	//照片
    private String attachment_name;	//档案附件
    private Short check_status;	//复核状态
    private String register;	//登记人
    private Date regist_time;	//登记时间
    private String checker;	//复核人姓名
    private Date check_time;	//复核时间
    private Short interview_status;	//面试状态
    private Double total_points;	//总分
    private Short test_amount;	//考试次数
    private String test_checker;	//测试复核人
    private Date test_check_time;	//测试复核时间
    private String pass_register;	//通过登记人姓名
    private Date pass_regist_time;	//通过登记时间
    private String pass_checker;	//通过复核人姓名
    private Date pass_check_time;	//通过复核时间
    private Short pass_check_status;	//通过的复核状态
    private String pass_checkComment;	//录用申请审核意见
    private String pass_passComment;	//录用申请审批意见
	public int getRes_id() {
		return res_id;
	}
	public void setRes_id(int res_id) {
		this.res_id = res_id;
	}
	public String getHuman_name() {
		return human_name;
	}
	public void setHuman_name(String human_name) {
		this.human_name = human_name;
	}
	public String getEngage_type() {
		return engage_type;
	}
	public void setEngage_type(String engage_type) {
		this.engage_type = engage_type;
	}
	public String getHuman_address() {
		return human_address;
	}
	public void setHuman_address(String human_address) {
		this.human_address = human_address;
	}
	public String getHuman_postcode() {
		return human_postcode;
	}
	public void setHuman_postcode(String human_postcode) {
		this.human_postcode = human_postcode;
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
	public String getHuman_telephone() {
		return human_telephone;
	}
	public void setHuman_telephone(String human_telephone) {
		this.human_telephone = human_telephone;
	}
	public String getHuman_homephone() {
		return human_homephone;
	}
	public void setHuman_homephone(String human_homephone) {
		this.human_homephone = human_homephone;
	}
	public String getHuman_mobilephone() {
		return human_mobilephone;
	}
	public void setHuman_mobilephone(String human_mobilephone) {
		this.human_mobilephone = human_mobilephone;
	}
	public String getHuman_email() {
		return human_email;
	}
	public void setHuman_email(String human_email) {
		this.human_email = human_email;
	}
	public String getHuman_hobby() {
		return human_hobby;
	}
	public void setHuman_hobby(String human_hobby) {
		this.human_hobby = human_hobby;
	}
	public String getHuman_specility() {
		return human_specility;
	}
	public void setHuman_specility(String human_specility) {
		this.human_specility = human_specility;
	}
	public String getHuman_sex() {
		return human_sex;
	}
	public void setHuman_sex(String human_sex) {
		this.human_sex = human_sex;
	}
	public String getHuman_religion() {
		return human_religion;
	}
	public void setHuman_religion(String human_religion) {
		this.human_religion = human_religion;
	}
	public String getHuman_party() {
		return human_party;
	}
	public void setHuman_party(String human_party) {
		this.human_party = human_party;
	}
	public String getHuman_nationality() {
		return human_nationality;
	}
	public void setHuman_nationality(String human_nationality) {
		this.human_nationality = human_nationality;
	}
	public String getHuman_race() {
		return human_race;
	}
	public void setHuman_race(String human_race) {
		this.human_race = human_race;
	}
	public Date getHuman_birthday() {
		return human_birthday;
	}
	public void setHuman_birthday(Date human_birthday) {
		this.human_birthday = human_birthday;
	}
	public Short getHuman_age() {
		return human_age;
	}
	public void setHuman_age(Short human_age) {
		this.human_age = human_age;
	}
	public String getHuman_educated_degree() {
		return human_educated_degree;
	}
	public void setHuman_educated_degree(String human_educated_degree) {
		this.human_educated_degree = human_educated_degree;
	}
	public Short getHuman_educated_years() {
		return human_educated_years;
	}
	public void setHuman_educated_years(Short human_educated_years) {
		this.human_educated_years = human_educated_years;
	}
	public String getHuman_educated_major() {
		return human_educated_major;
	}
	public void setHuman_educated_major(String human_educated_major) {
		this.human_educated_major = human_educated_major;
	}
	public String getHuman_college() {
		return human_college;
	}
	public void setHuman_college(String human_college) {
		this.human_college = human_college;
	}
	public String getHuman_idcard() {
		return human_idcard;
	}
	public void setHuman_idcard(String human_idcard) {
		this.human_idcard = human_idcard;
	}
	public String getHuman_birthplace() {
		return human_birthplace;
	}
	public void setHuman_birthplace(String human_birthplace) {
		this.human_birthplace = human_birthplace;
	}
	public Double getDemand_salary_standard() {
		return demand_salary_standard;
	}
	public void setDemand_salary_standard(Double demand_salary_standard) {
		this.demand_salary_standard = demand_salary_standard;
	}
	public String getHuman_history_records() {
		return human_history_records;
	}
	public void setHuman_history_records(String human_history_records) {
		this.human_history_records = human_history_records;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public String getRecomandation() {
		return recomandation;
	}
	public void setRecomandation(String recomandation) {
		this.recomandation = recomandation;
	}
	public String getHuman_picture() {
		return human_picture;
	}
	public void setHuman_picture(String human_picture) {
		this.human_picture = human_picture;
	}
	public String getAttachment_name() {
		return attachment_name;
	}
	public void setAttachment_name(String attachment_name) {
		this.attachment_name = attachment_name;
	}
	public Short getCheck_status() {
		return check_status;
	}
	public void setCheck_status(Short check_status) {
		this.check_status = check_status;
	}
	public String getRegister() {
		return register;
	}
	public void setRegister(String register) {
		this.register = register;
	}
	public Date getRegist_time() {
		return regist_time;
	}
	public void setRegist_time(Date regist_time) {
		this.regist_time = regist_time;
	}
	public String getChecker() {
		return checker;
	}
	public void setChecker(String checker) {
		this.checker = checker;
	}
	public Date getCheck_time() {
		return check_time;
	}
	public void setCheck_time(Date check_time) {
		this.check_time = check_time;
	}
	public Short getInterview_status() {
		return interview_status;
	}
	public void setInterview_status(Short interview_status) {
		this.interview_status = interview_status;
	}
	public Double getTotal_points() {
		return total_points;
	}
	public void setTotal_points(Double total_points) {
		this.total_points = total_points;
	}
	public Short getTest_amount() {
		return test_amount;
	}
	public void setTest_amount(Short test_amount) {
		this.test_amount = test_amount;
	}
	public String getTest_checker() {
		return test_checker;
	}
	public void setTest_checker(String test_checker) {
		this.test_checker = test_checker;
	}
	public Date getTest_check_time() {
		return test_check_time;
	}
	public void setTest_check_time(Date test_check_time) {
		this.test_check_time = test_check_time;
	}
	public String getPass_register() {
		return pass_register;
	}
	public void setPass_register(String pass_register) {
		this.pass_register = pass_register;
	}
	public Date getPass_regist_time() {
		return pass_regist_time;
	}
	public void setPass_regist_time(Date pass_regist_time) {
		this.pass_regist_time = pass_regist_time;
	}
	public String getPass_checker() {
		return pass_checker;
	}
	public void setPass_checker(String pass_checker) {
		this.pass_checker = pass_checker;
	}
	public Date getPass_check_time() {
		return pass_check_time;
	}
	public void setPass_check_time(Date pass_check_time) {
		this.pass_check_time = pass_check_time;
	}
	public Short getPass_check_status() {
		return pass_check_status;
	}
	public void setPass_check_status(Short pass_check_status) {
		this.pass_check_status = pass_check_status;
	}
	public String getPass_checkComment() {
		return pass_checkComment;
	}
	public void setPass_checkComment(String pass_checkComment) {
		this.pass_checkComment = pass_checkComment;
	}
	public String getPass_passComment() {
		return pass_passComment;
	}
	public void setPass_passComment(String pass_passComment) {
		this.pass_passComment = pass_passComment;
	}
    
}