package com.assesment.dom;

public class AssesmentDO {
	private String cid;
	private String cname;
	private String email;
	private String phone;
	private String city;
	private String status;
	private int questionNumber;
	private String question;
	private String optOne;
	private String optTwo;
	private String optThree;
	private String optFour;
	private String corrAnswer;
	private String ass_duration;
	
	
	
	public String getAss_duration() {
		return ass_duration;
	}
	public void setAss_duration(String ass_duration) {
		this.ass_duration = ass_duration;
	}
	public int getQuestionNumber() {
		return questionNumber;
	}
	public void setQuestionNumber(int questionNumber) {
		this.questionNumber = questionNumber;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getOptOne() {
		return optOne;
	}
	public void setOptOne(String optOne) {
		this.optOne = optOne;
	}
	public String getOptTwo() {
		return optTwo;
	}
	public void setOptTwo(String optTwo) {
		this.optTwo = optTwo;
	}
	public String getOptThree() {
		return optThree;
	}
	public void setOptThree(String optThree) {
		this.optThree = optThree;
	}
	public String getOptFour() {
		return optFour;
	}
	public void setOptFour(String optFour) {
		this.optFour = optFour;
	}
	public String getCorrAnswer() {
		return corrAnswer;
	}
	public void setCorrAnswer(String corrAnswer) {
		this.corrAnswer = corrAnswer;
	}
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	public String toString() {
		return "CustomerTO [cid=" + cid + ", cname=" + cname + ", email=" + email + ", phone=" + phone + ", city="
				+ city + ", status=" + status + "]";
	}	
}
