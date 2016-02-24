package com.assesment.dom;

import java.util.Date;

public class StatusDo {
	private String cid;
	private String cname;
	private String status;
	private String noOfAttempts;
	private String marks;;
	private Date date;
	public String getMarks() {
		return marks;
	}
	public void setMarks(String marks) {
		this.marks = marks;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getNoOfAttempts() {
		return noOfAttempts;
	}
	public void setNoOfAttempts(String noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
