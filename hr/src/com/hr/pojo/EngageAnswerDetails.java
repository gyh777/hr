package com.hr.pojo;

public class EngageAnswerDetails {
    private int and_id;	//id
    private String answer_number;	//答案编号
    private int subject_id;	//试题编号
    private String answer;	//测试者答案
	public int getAnd_id() {
		return and_id;
	}
	public void setAnd_id(int and_id) {
		this.and_id = and_id;
	}
	public String getAnswer_number() {
		return answer_number;
	}
	public void setAnswer_number(String answer_number) {
		this.answer_number = answer_number;
	}
	public int getSubject_id() {
		return subject_id;
	}
	public void setSubject_id(int subject_id) {
		this.subject_id = subject_id;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
    
}