package com.example.demo;

import java.sql.Date;

public class VersionLink {
	private String vid;
	private int fid;
	private String pid;
	private Date createtime;
	private String userid;
	private String username;
	private String vcomment;
	private String vparent;
	private String vtext;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getVcomment() {
		return vcomment;
	}
	public void setVcomment(String vcomment) {
		this.vcomment = vcomment;
	}
	public String getVid() {
		return vid;
	}
	public void setVid(String vid) {
		this.vid = vid;
	}
	public int getFid() {
		return fid;
	}
	public void setFid(int fid) {
		this.fid = fid;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public Date getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getVparent() {
		return vparent;
	}
	public void setVparent(String vparent) {
		this.vparent = vparent;
	}
	public String getVtext() {
		return vtext;
	}
	public void setVtext(String vtext) {
		this.vtext = vtext;
	}

}
