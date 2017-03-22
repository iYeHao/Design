package com.example.demo;

import java.sql.Date;

public class Field {
	private double contribution;
	private String fid;
	private String pid;
	private String userid;
	private String fname;
	private String ftext;
	private String fatherid;
	private Date fdate;
	private String author;
	private String planname;
	private double similar;
	private double similar2;
	private int level;
	public void setSimilar(double similar){this.similar=similar;}
	public double getSimilar(){return similar;}
	public void setSimilar2(double similar2){this.similar2=similar2;}
	public double getSimilar2(){return similar2;}
	public void setContribution(double contribution){this.contribution=contribution;}
	public double getContribution(){return contribution;}
	public void setPlanname(String planname){
		this.planname=planname;
	}
	public String getPlanname(){
		return planname;
	}
	public void setAuthor(String author){
		this.author=author;
	}
	public String getAuthor(){
		return author;
	}
	public void setFid(String fid){
		this.fid=fid;
	}
	public String getFid(){
		return fid;
	}
	public void setPid(String pid)
	{
		this.pid=pid;
	}
	public String getPid(){
		return pid;
	}
	public void setUserid(String userid)
	{
		this.userid=userid;
	}
	public String getUserid(){
		return userid;
	}
	public void setFname(String fname)
	{
		this.fname=fname;
	}
	public String getFname()
	{
		return fname;
	}
	public void setFtext(String ftext)
	{
		this.ftext=ftext;
	}
	public String getFtext()
	{
		return ftext;
	}
	public void setFatherid(String fatherid)
	{
		this.fatherid=fatherid;
	}
	public String getFatherid(){
		return fatherid;
	}
	public void setFdate(Date fdate){
		this.fdate=fdate;
	}
	public Date getFdate()
	{
		return fdate;
	}
	public void setLevel(int level) {
		// TODO Auto-generated method stub
		this.level=level;
	}
	public int getLevel(){
		return level;
	}

}
