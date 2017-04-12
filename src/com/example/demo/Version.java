package com.example.demo;

import java.sql.Timestamp;


public class Version {
		private int vid;
		private int fid;
		private int pid;
		private Timestamp createtime;
		private int userid;
		private String vtext;
		private int vparent;
		private String vcomment;
		private int vcount;
		public int getVid() {
			return vid;
		}
		public void setVid(int vid) {
			this.vid = vid;
		}
		public int getFid() {
			return fid;
		}
		public void setFid(int fid) {
			this.fid = fid;
		}
		public int getPid() {
			return pid;
		}
		public void setPid(int pid) {
			this.pid = pid;
		}
		public Timestamp getCreatetime() {
			return createtime;
		}
		public void setCreatetime(Timestamp createtime) {
			this.createtime = createtime;
		}
		public int getUserid() {
			return userid;
		}
		public void setUserid(int userid) {
			this.userid = userid;
		}
		public String getVtext() {
			return vtext;
		}
		public void setVtext(String vtext) {
			this.vtext = vtext;
		}
		public int getVparent() {
			return vparent;
		}
		public void setVparent(int vparent) {
			this.vparent = vparent;
		}
		public String getVcomment() {
			return vcomment;
		}
		public void setVcomment(String vcomment) {
			this.vcomment = vcomment;
		}
		public int getVcount() {
			return vcount;
		}
		public void setVcount(int vcount) {
			this.vcount = vcount;
		}
}
