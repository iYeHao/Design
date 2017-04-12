package com.example.demo;

import java.sql.Date;


public class Version {
		private String vid;
		private int fid;
		private String pid;
		private Date createtime;
		private String userid;
		private String vtext;
		private String vparent;
		private String vcomment;
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
		public String getVtext() {
			return vtext;
		}
		public void setVtext(String vtext) {
			this.vtext = vtext;
		}
		public String getVparent() {
			return vparent;
		}
		public void setVparent(String vparent) {
			this.vparent = vparent;
		}
		public String getVcomment() {
			return vcomment;
		}
		public void setVcomment(String vcomment) {
			this.vcomment = vcomment;
		}
}
