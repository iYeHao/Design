package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;
import java.sql.Date;

import com.example.demo.Plan;

public class planDao extends baseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Plan>show() throws SQLException{
		ArrayList<Plan> plist = new ArrayList<Plan>();
		String sql="select * from plan";
		Plan plan= new Plan();
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			plan.setPid(rs.getString(1));
			plan.setPname(rs.getString(4));
			plan.setPtype(rs.getString(3));
			plan.setPdate(rs.getDate(5));
			plan.setUserid(rs.getString(2));
			plist.add(plan);
		}
		return plist;
	}
	public ArrayList<Plan> DetailShow(String userid) throws SQLException{
		String sql="select * from plan where userid =?";
		ArrayList<Plan> planlist= new ArrayList<Plan>();
		Plan plan=new Plan();
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, userid);
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			plan.setPid(rs.getString(1));
			plan.setPname(rs.getString(4));
			plan.setPtype(rs.getString(3));
			plan.setPdate(rs.getDate(5));
			plan.setUserid(rs.getString(2));
			planlist.add(plan);
		}
		return planlist;
	}
	public Plan PlanCheck(String pid) throws SQLException{
		Plan plan =new Plan();
		String sql="select * from plan where pid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, pid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			plan.setPid(rs.getString(1));
			plan.setPname(rs.getString(4));
			plan.setPtype(rs.getString(3));
			plan.setPdate(rs.getDate(5));
			plan.setUserid(rs.getString(2));
		}
	  String ssql="select * from users where userid= ?";
	  java.sql.PreparedStatement pps =this.conn.prepareStatement(ssql);
	  pps.setObject(1, plan.getUserid());
	  java.sql.ResultSet rrs=pps.executeQuery();
	  while(rrs.next()){
	  plan.setUsername(rrs.getString(3));
	  }
		return plan;
	}
	public String addplan(String pname, String ptype, Date d, String userid) throws SQLException {
		// TODO Auto-generated method stub

		String pid=UUID.randomUUID().toString();
		String sql="Insert into Plan (pid,userid,pname,ptype,pdate) values(?,?,?,?,?)";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setObject(1, pid);
		ps.setObject(2, userid);
		ps.setObject(3, pname);
		ps.setObject(4, ptype);
		ps.setDate(5, d);
		ps.execute();
		return pid;
		
	}

}
