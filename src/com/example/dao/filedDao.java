package com.example.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import oracle.jdbc.OraclePreparedStatement;
import com.example.demo.Field;

public class filedDao extends baseDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/*
	 * 所有filed的列表
	 */

	public ArrayList<Field> show() throws SQLException{
		
		ArrayList<Field> flist= new ArrayList<Field>();
		String sql="select * from filed ";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			Field filed =new Field();
			filed.setFid(rs.getString(1));
			filed.setFname(rs.getString(4));
			int end =rs.getString(5).length();
			if(end>=30){
				end=30;
			}else
			{
			}
			filed.setFtext(rs.getString(5).substring(0,end));
			filed.setUserid(rs.getString(3));
			filed.setFdate(rs.getDate(7));
			flist.add(filed);
		}
		return flist;
	}
public ArrayList<Field> Dshow() throws SQLException{
		
		ArrayList<Field> flist= new ArrayList<Field>();
		String sql="select * from filed ";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			Field filed =new Field();
			filed.setFid(rs.getString(1));
			filed.setFname(rs.getString(4));
			filed.setFtext(rs.getString(5));
			filed.setUserid(rs.getString(3));
			filed.setFdate(rs.getDate(7));
			flist.add(filed);
		}
		return flist;
	}
	/*
	 * filed的详情
	 */
	public Field filedcheck(String fid) throws SQLException{
		Field f = new Field();
		String sql="select * from filed where fid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setObject(1, fid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			f.setFid(fid);
			f.setFdate(rs.getDate(7));
			f.setFatherid(rs.getString(6));
			f.setPid(rs.getString(2));
			f.setUserid(rs.getString(3));
			f.setFname(rs.getString(4));
			f.setFtext(rs.getString(5));
		}
		String ssql="select * from users where userid = ?";
		java.sql.PreparedStatement pps =this.conn.prepareStatement(ssql);
		pps.setObject(1,f.getUserid());
		java.sql.ResultSet rrs =pps.executeQuery();
		while(rrs.next()){
			f.setAuthor(rrs.getString(3));
		}
		String sssql="select * from plan where pid = ?";
		java.sql.PreparedStatement ppps = this.conn.prepareStatement(sssql);
		ppps.setObject(1, f.getPid());
		java.sql.ResultSet rrrs = ppps.executeQuery();
		while(rrrs.next()){
			f.setPlanname(rrrs.getString(4));
		}
		return f;
	}
	/*
	 * 删除field
	 */
	public void deletefiled(String fid) throws SQLException{
		String sql="delete from filed where fid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, fid);
		ps.execute();
	}
	/*
	 * 添加field
	 */
	public Field addfiled(String ftext,String fname,String userid,String pid,Date date) throws SQLException{
		Field f=new Field();
		String fid=UUID.randomUUID().toString();
		String sql="insert into filed (ftext,fname,userid,pid,fdate,fatherid,fid) values(?,?,?,?,?,?,?)";
		
		String sql2 = "insert into version (fid, pid, createtime, userid, vtext, vparent,vid) select fid, ?, ?, ?, ?,?,?  from field_base where fname = ?";
		//String sql2 = "insert into version (fid, pid, createtime, userid, vtext, vparent,vid)values(1,?,?,?,?,?,?)";
		this.ConnetOrcl();
		String fatherid=null;
		OraclePreparedStatement ps=(OraclePreparedStatement)this.conn.prepareStatement(sql);
		ps.setString(1, ftext);
		ps.setString(2, fname);
		ps.setString(3, userid);
		ps.setString(4, pid);
		ps.setDate(5, date);
		ps.setString(6, fatherid);
		ps.setString(7, fid);
		ps.executeQuery();
		f.setFid(fid);
		f.setFtext(ftext);
		PreparedStatement ps2 = this.conn.prepareStatement(sql2);
		ps2.setString(1, pid);
		ps2.setDate(2, date);
		ps2.setString(3, userid);
		ps2.setString(4, ftext);
		ps2.setString(5, fatherid);
		ps2.setString(6, fid);
		ps2.setString(7,fname);
		ps2.executeUpdate();
		return f;
	}

	/*
	 * 查找field的作者
	 */
	public String findAuthor(String userid) throws SQLException{
		String author=null;
		String sql="select * from users where userid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setString(1, userid);
		java.sql.ResultSet rs=ps.executeQuery();
		while(rs.next()){
			author=rs.getString(3);
		}
		return author;
	}
	ArrayList<Field> flist = new ArrayList<Field>();
	/*
	 * field 的回溯
	 */
	public ArrayList<Field> trackback(String fid) throws SQLException {
		// TODO Auto-generated method stub

		if(fid==null){
			return flist;
		}
		Field f=new Field();
		String sql="select * from Filed where fid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setString(1, fid);
		java.sql.ResultSet rs=ps.executeQuery();
		while(rs.next()){
			f.setFid(rs.getString(1));
			f.setPid(rs.getString(2));
			f.setUserid(rs.getString(3));
			f.setFname(rs.getString(4));
			f.setFtext(rs.getString(5));
			f.setFatherid(rs.getString(6));
			f.setFdate(rs.getDate(7));
		}
		f.setAuthor(this.findAuthor(f.getUserid()));
		f.setLevel(this.findlevel(f.getUserid()));
		flist.add(f);
		return trackback(f.getFatherid());
	}
	public  int findlevel(String userid){
		int level=0;
		String sql="select *from users where userid=?";
		this.ConnetOrcl();
		try {
			java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
			ps.setString(1, userid);
			java.sql.ResultSet rs=ps.executeQuery();
			while(rs.next()){
				level=rs.getInt(6);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return level;
		
	}

}