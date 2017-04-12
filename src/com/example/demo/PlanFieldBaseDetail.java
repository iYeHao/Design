package com.example.demo;

import java.util.List;

public class PlanFieldBaseDetail {
	private int fid;
	private int fparent;
	private String fname;
	private List<VersionDetail> versionDetails;
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
	public List<VersionDetail> getVersionDetails() {
		return versionDetails;
	}
	public void setVersionDetails(List<VersionDetail> versionDetails) {
		this.versionDetails = versionDetails;
	}
	public int getFparent() {
		return fparent;
	}
	public void setFparent(int fparent) {
		this.fparent = fparent;
	}
	
}
