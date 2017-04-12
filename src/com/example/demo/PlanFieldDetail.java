package com.example.demo;

import java.util.List;

public class PlanFieldDetail {
	private int fid;
	private String fname;
	private List<PlanFieldBaseDetail> fieldBaseDetails;
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public List<PlanFieldBaseDetail> getFieldBaseDetails() {
		return fieldBaseDetails;
	}
	public void setFieldBaseDetails(List<PlanFieldBaseDetail> fieldBaseDetails) {
		this.fieldBaseDetails = fieldBaseDetails;
	}
	
}
