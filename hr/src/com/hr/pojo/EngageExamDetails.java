package com.hr.pojo;

public class EngageExamDetails {
    private int exd_id;	//
    private String exam_number;	//试卷编号
    private String first_kind_id;	//试卷一级分类编号
    private String first_kind_name;	//试卷一级分类
    private String second_kind_id;	//试卷二级分类编号
    private String second_kind_name;	//试卷二级分类
    private int question_Amount;	//出题数量
    
	public int getExd_id() {
		return exd_id;
	}
	public void setExd_id(int exd_id) {
		this.exd_id = exd_id;
	}
	public String getExam_number() {
		return exam_number;
	}
	public void setExam_number(String exam_number) {
		this.exam_number = exam_number;
	}
	public String getFirst_kind_id() {
		return first_kind_id;
	}
	public void setFirst_kind_id(String first_kind_id) {
		this.first_kind_id = first_kind_id;
	}
	public String getFirst_kind_name() {
		return first_kind_name;
	}
	public void setFirst_kind_name(String first_kind_name) {
		this.first_kind_name = first_kind_name;
	}
	public String getSecond_kind_id() {
		return second_kind_id;
	}
	public void setSecond_kind_id(String second_kind_id) {
		this.second_kind_id = second_kind_id;
	}
	public String getSecond_kind_name() {
		return second_kind_name;
	}
	public void setSecond_kind_name(String second_kind_name) {
		this.second_kind_name = second_kind_name;
	}
	public int getQuestion_Amount() {
		return question_Amount;
	}
	public void setQuestion_Amount(int question_Amount) {
		this.question_Amount = question_Amount;
	}
    
}