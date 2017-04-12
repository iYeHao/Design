package com.example.demo;

import java.sql.Timestamp;
import java.util.List;

public class PlanDetail {
	private String pid;
	private String pname;
	private Timestamp pdate;
	private String userid;
	private String username;
	private List<PlanFieldDetail> fieldDetails;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Timestamp getPdate() {
		return pdate;
	}
	public void setPdate(Timestamp pdate) {
		this.pdate = pdate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<PlanFieldDetail> getFieldDetails() {
		return fieldDetails;
	}
	public void setFieldDetails(List<PlanFieldDetail> fieldDetails) {
		this.fieldDetails = fieldDetails;
	}
	
}
