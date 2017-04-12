package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.Date;

import oracle.jdbc.OraclePreparedStatement;
import oracle.jdbc.OracleTypes;

import com.example.demo.FieldBase;
import com.example.demo.Plan;
import com.example.demo.PlanDetail;
import com.example.demo.PlanFieldBaseDetail;
import com.example.demo.PlanFieldDetail;
import com.example.demo.VersionDetail;
import com.example.demo.VersionLink;

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
	
	public PlanDetail getPlanDetail(int pid) throws SQLException {
		PlanDetail pdetail = new PlanDetail();
		String pdetailSql = "select t.pid,t.pname,t.pdate,u.userid,u.uname from plan t left join USERS u on t.userid=u.userid where pid=?";
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(pdetailSql);
		ps.setObject(1, pid);
		ResultSet rs =ps.executeQuery();
		if(rs.next())
		{
			pdetail.setPid(rs.getInt(1));
			pdetail.setPname(rs.getString(2));
			pdetail.setPdate(rs.getTimestamp(3));
			pdetail.setUserid(rs.getInt(4));
			pdetail.setUsername(rs.getString(5));
			pdetail.setFieldDetails(new ArrayList());
		}
		List<PlanFieldDetail> fieldDetails = pdetail.getFieldDetails();
		String fieldDetailSql = "select * from field_base order by fid";
		PreparedStatement fdps =this.conn.prepareStatement(fieldDetailSql);
		ResultSet fdrs =fdps.executeQuery();
		Map<Integer, PlanFieldDetail> fieldMap = new HashMap();
		List<PlanFieldBaseDetail> fieldBaseDetails = new ArrayList();
		while(fdrs.next()) {
			int level = fdrs.getInt(4);
			if(level == 1) {
				PlanFieldDetail detail = new PlanFieldDetail();   
				detail.setFid(fdrs.getInt(1));
				detail.setFname(fdrs.getString(2));
				detail.setFieldBaseDetails(new ArrayList());
				fieldMap.put(detail.getFid(), detail);
				fieldDetails.add(detail);
			}
			else {
				PlanFieldBaseDetail pfbd = new PlanFieldBaseDetail();
				pfbd.setFid(fdrs.getInt(1));
				pfbd.setFname(fdrs.getString(2));
				pfbd.setFparent(fdrs.getInt(3));
				pfbd.setVersionDetails(new ArrayList());
				fieldBaseDetails.add(pfbd);
			}
		}
		String versionSql = "select vid, createtime, version.userid, uname, vtext from version left join users on version.userid = users.userid" +
				" where fid = ? and pid = ? order by createtime";
		java.sql.PreparedStatement vps = this.conn.prepareStatement(versionSql);
		for(int i = 0; i < fieldBaseDetails.size(); i++) {
			PlanFieldBaseDetail pfbd = fieldBaseDetails.get(i);
			PlanFieldDetail detail = fieldMap.get(pfbd.getFparent());
			if(detail != null) {
				detail.getFieldBaseDetails().add(pfbd);
			}
			int fid = pfbd.getFid();	
			vps.setInt(1, fid);
			vps.setInt(2, pid); 
			ResultSet vrs = vps.executeQuery();
			while(vrs.next()) {
				VersionDetail vdetail = new VersionDetail(); 
				vdetail.setVid(vrs.getInt(1));
				vdetail.setCreatetime(vrs.getTimestamp(2));
				vdetail.setUserid(vrs.getInt(3));
				vdetail.setUsername(vrs.getString(4));
				vdetail.setVtext(vrs.getString(5));
				pfbd.getVersionDetails().add(vdetail);
			}
		}
		return pdetail;
	}
	
	public PlanDetail getBestPlanDetail(int pid) throws SQLException {
		PlanDetail pdetail = new PlanDetail();
		String pdetailSql = "select t.pid,t.pname,t.pdate,u.userid,u.uname from plan t left join USERS u on t.userid=u.userid where pid=?";
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(pdetailSql);
		ps.setObject(1, pid);
		ResultSet rs =ps.executeQuery();
		if(rs.next())
		{
			pdetail.setPid(rs.getInt(1));
			pdetail.setPname(rs.getString(2));
			pdetail.setPdate(rs.getTimestamp(3));
			pdetail.setUserid(rs.getInt(4));
			pdetail.setUsername(rs.getString(5));
			pdetail.setFieldDetails(new ArrayList());
		}
		List<PlanFieldDetail> fieldDetails = pdetail.getFieldDetails();
		String fieldDetailSql = "select * from field_base order by fid";
		PreparedStatement fdps =this.conn.prepareStatement(fieldDetailSql);
		ResultSet fdrs =fdps.executeQuery();
		Map<Integer, PlanFieldDetail> fieldMap = new HashMap();
		List<PlanFieldBaseDetail> fieldBaseDetails = new ArrayList();
		while(fdrs.next()) {
			int level = fdrs.getInt(4);
			if(level == 1) {
				PlanFieldDetail detail = new PlanFieldDetail();   
				detail.setFid(fdrs.getInt(1));
				detail.setFname(fdrs.getString(2));
				detail.setFieldBaseDetails(new ArrayList());
				fieldMap.put(detail.getFid(), detail);
				fieldDetails.add(detail);
			}
			else {
				PlanFieldBaseDetail pfbd = new PlanFieldBaseDetail();
				pfbd.setFid(fdrs.getInt(1));
				pfbd.setFname(fdrs.getString(2));
				pfbd.setFparent(fdrs.getInt(3));
				pfbd.setVersionDetails(new ArrayList());
				fieldBaseDetails.add(pfbd);
			}
		}
		String versionSql = "select vid, createtime, version.userid, uname, vtext, vcount from version left join users on version.userid = users.userid" +
				" where fid = ? and pid = ? and rownum <=2 order by vcount";
		java.sql.PreparedStatement vps = this.conn.prepareStatement(versionSql);
		for(int i = 0; i < fieldBaseDetails.size(); i++) {
			PlanFieldBaseDetail pfbd = fieldBaseDetails.get(i);
			List<VersionDetail> vdetails = pfbd.getVersionDetails();
			PlanFieldDetail detail = fieldMap.get(pfbd.getFparent());
			if(detail != null) {
				detail.getFieldBaseDetails().add(pfbd);
			}
			int fid = pfbd.getFid();	
			vps.setInt(1, fid);
			vps.setInt(2, pid); 
			ResultSet vrs = vps.executeQuery();
			while(vrs.next()) {
				VersionDetail vdetail = new VersionDetail(); 
				vdetail.setVid(vrs.getInt(1));
				vdetail.setCreatetime(vrs.getTimestamp(2));
				vdetail.setUserid(vrs.getInt(3));
				vdetail.setUsername(vrs.getString(4));
				vdetail.setVtext(vrs.getString(5));
				vdetail.setVcount(vrs.getInt(6));
				vdetails.add(vdetail);
			}
			if(vdetails.size() == 2) { 
				if(vdetails.get(0).getVcount() == vdetails.get(1).getVcount()) {
					vdetails.clear();
				}
				else {
					vdetails.remove(1);
				}
			}
		}
		return pdetail;
	}

	/*public int planClone(int pid, List<Integer> vids, int userid) throws SQLException {
		int newPid = 0;
		Plan newPlan = new Plan();
		String selectPlanSql = "select ptype, pname from plan where pid = ?";
		String clonePlanSql = "insert into plan (userid,ptype,pname,pdate) values(?, ?, ?, sysdate) returning pid into ?";
		String cloneVersionSql = "insert into version (fid, pid, createtime, userid, vtext, vparent, vcomment) select fid, ?, createtime, userid, vtext, 0, vcomment from version where vid = ?";
		this.ConnetOrcl();
		OraclePreparedStatement selectPlanPs = (OraclePreparedStatement)this.conn.prepareStatement(selectPlanSql);
		selectPlanPs.setInt(1, pid);
		ResultSet selectRs = selectPlanPs.executeQuery();
		if(!selectRs.next()) {
			return newPid;
		}
		newPlan.setPtype(selectRs.getString(1));
		newPlan.setPname(selectRs.getString(2));
		OraclePreparedStatement clonePlanPs = (OraclePreparedStatement)this.conn.prepareStatement(clonePlanSql);
		clonePlanPs.setInt(1, userid);
		clonePlanPs.setString(2, newPlan.getPtype());
		clonePlanPs.setString(3, newPlan.getPname());
		clonePlanPs.registerReturnParameter(4, OracleTypes.INTEGER);
		int count = clonePlanPs.executeUpdate();
		if(count <= 0) {
			return newPid;
		}
		ResultSet rs = clonePlanPs.getReturnResultSet();
		rs.next();
		newPid = rs.getInt(1);
		OraclePreparedStatement cloneVersionPs = (OraclePreparedStatement)this.conn.prepareStatement(cloneVersionSql);
		for(int i = 0; i < vids.size(); i++) {
			cloneVersionPs.setInt(1, newPid);
			cloneVersionPs.setInt(2, vids.get(i));
			count = cloneVersionPs.executeUpdate();
			if(count <= 0) {
				return newPid;
			}
		}
		return newPid;
	}
	*/
}
