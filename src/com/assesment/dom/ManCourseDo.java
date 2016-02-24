package com.assesment.dom;

import java.util.Date;

public class ManCourseDo {
	private String mcid;
	private String mcname;
	private String mcauthor;
	private String mminDuration;
	private String mfileExt;
	private String mfileName;
	private Date mdate;
	
	public String getMfileName() {
		return mfileName;
	}
	public void setMfileName(String mfileName) {
		this.mfileName = mfileName;
	}
	public String getMcid() {
		return mcid;
	}
	public void setMcid(String mcid) {
		this.mcid = mcid;
	}
	public String getMcname() {
		return mcname;
	}
	public void setMcname(String mcname) {
		this.mcname = mcname;
	}
	public String getMcauthor() {
		return mcauthor;
	}
	public void setMcauthor(String mcauthor) {
		this.mcauthor = mcauthor;
	}
	public String getMminDuration() {
		return mminDuration;
	}
	public void setMminDuration(String mminDuration) {
		this.mminDuration = mminDuration;
	}
	public String getMfileExt() {
		return mfileExt;
	}
	public void setMfileExt(String mfileExt) {
		this.mfileExt = mfileExt;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	
}
