package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.example.demo.Plan;

public class planDao extends baseDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ArrayList<Plan> show(String searchStr) throws SQLException{
		ArrayList<Plan> plist = new ArrayList<Plan>();
		String sql="select t.pid, t.userid, t.ptype, t.pname, t.pdate, u.uname from plan t left join users u on t.userid = u.userid where t.pname like ?" +
				" or t.ptype like ? or u.uname like ? order by t.pdate desc";
		String sql2 = "select t.pid, t.userid, t.ptype, t.pname, t.pdate, u.uname from plan t left join users u on t.userid = u.userid order by t.pdate desc";
		this.ConnetOrcl();
		PreparedStatement ps = null;
		if(searchStr == null || searchStr.equals("")) {
			ps = this.conn.prepareStatement(sql2);
		} else {
			ps = this.conn.prepareStatement(sql);
			String str = "%" + searchStr + "%";
			ps.setObject(1, str);
			ps.setObject(2, str);
			ps.setObject(3, str);
		}
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			Plan plan= new Plan();
			plan.setPid(rs.getInt(1));
			plan.setUserid(rs.getInt(2));
			plan.setPtype(rs.getString(3));
			plan.setPname(rs.getString(4));
			plan.setPdate(rs.getDate(5));
			plan.setUsername(rs.getString(6));
			plist.add(plan);
		}
		return plist;
	}
	public ArrayList<Plan> DetailShow(int userid) throws SQLException{
		String sql="select * from plan where userid =?";
		ArrayList<Plan> planlist= new ArrayList<Plan>();
		Plan plan=new Plan();
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, userid);
		ResultSet rs =ps.executeQuery();
		while(rs.next())
		{
			plan.setPid(rs.getInt(1));
			plan.setPname(rs.getString(4));
			plan.setPtype(rs.getString(3));
			plan.setPdate(rs.getDate(5));
			plan.setUserid(rs.getInt(2));
			planlist.add(plan);
		}
		return planlist;
	}
	public Plan PlanShow(int pid) throws SQLException{
		String sql="select t.pid,t.pname,t.pdate,u.uname from plan t left join USERS u on t.userid=u.userid where pid=?";
		Plan plan= new Plan();
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, pid);
		ResultSet rs =ps.executeQuery();
		if(rs.next())
		{
			plan.setPid(rs.getInt(1));
			plan.setPname(rs.getString(2));
			plan.setPdate(rs.getDate(3));
			plan.setUsername(rs.getString(4));
		}
		return plan;
	}
	public Plan PlanCheck(int pid) throws SQLException{
		Plan plan =new Plan();
		String sql="select * from plan where pid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, pid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			plan.setPid(rs.getInt(1));
			plan.setPname(rs.getString(4));
			plan.setPtype(rs.getString(3));
			plan.setPdate(rs.getDate(5));
			plan.setUserid(rs.getInt(2));
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
	public int addplan(String pname, String ptype, Date d, int userid) throws SQLException {
		// TODO Auto-generated method stub

		int pid=(int) (Math.random()*1000);
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
