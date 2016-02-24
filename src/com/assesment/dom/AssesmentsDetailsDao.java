package com.assesment.dom;

public class AssesmentsDetailsDao {
	
	private String assTitle;
	private String assDuration;
	private String  totalQue;
	private String  assesmentsId;
	private String  courseId;

	
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String getAssesmentsId() {
		return assesmentsId;
	}
	public void setAssesmentsId(String assesmentsId) {
		this.assesmentsId = assesmentsId;
	}
	public String getAssTitle() {
		return assTitle;
	}
	public void setAssTitle(String assTitle) {
		this.assTitle = assTitle;
	}
	public String getAssDuration() {
		return assDuration;
	}
	public void setAssDuration(String assDuration) {
		this.assDuration = assDuration;
	}
	public String getTotalQue() {
		return totalQue;
	}
	public void setTotalQue(String totalQue) {
		this.totalQue = totalQue;
		
	}
	}
