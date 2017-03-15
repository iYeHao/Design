package com.example.demo;

public class FieldBase {
	private int fid;
	private String fname;
	private int fparent;
	private int flevel;
	public void setFid(int fid){
		this.fid=fid;
	}
	public int getFid(){
		return fid;
	}
	public void setFname(String fname){
		this.fname=fname;
	}
	public String getFname(){
		return fname;
	}
	public void setFparent(int fparent){
		this.fparent=fparent;
	}
	public int getFparent(){
		return fparent;
	}
	public void setFlevel(int flevel){
		this.flevel=flevel;
	}
	public int getFlevel(){
		return flevel;
	}
}
	
