package com.example.demo;

import java.util.List;

public class MainField {
	private Integer fid;
	private String fname;
	private Integer fparent;
	private Integer flevel;
	private List<FieldBase> children;
	
	public void setFid(Integer fid){
		this.fid=fid;
	}
	public Integer getFid(){
		return fid;
	}
	public void setFname(String fname){
		this.fname=fname;
	}
	public String getFname(){
		return fname;
	}
	public void setFparent(Integer fparent){
		this.fparent=fparent;
	}
	public Integer getFparent(){
		return fparent;
	}
	public void setFlevel(Integer flevel){
		this.flevel=flevel;
	}
	public Integer getFlevel(){
		return flevel;
	}
	public void setChildren(List<FieldBase> children) {
		this.children = children;
	}
	public List<FieldBase> getChildren(){
		return children;
	}
}
