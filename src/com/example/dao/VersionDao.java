package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.Version;
import com.example.demo.VersionLink;



public class VersionDao extends baseDao {
	
	public void add(Version version) throws SQLException {
		String sql="insert into version (pid,fid,createtime,userid,vtext,vparent,vcomment) values(?,?,?,?,?,?,?) ";
		String sql2="insert into filed (fname,pid,userid,ftext,fatherid,fdate,fcomment) select fname,?,?,?,?,?,?from field_base where fid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setInt(1,version.getPid());
		ps.setInt(2,version.getFid());
		ps.setDate(3, version.getCreatetime());
		ps.setInt(4, version.getUserid());
		ps.setString(5, version.getVtext());
		ps.setInt(6, version.getVparent());
		ps.setString(7, version.getVcomment());
        ps.executeUpdate();
        
		PreparedStatement ps2 =this.conn.prepareStatement(sql2);
		ps2.setInt(1, version.getPid());
		ps2.setInt(2, version.getUserid());
		ps2.setString(3, version.getVtext());
		ps2.setInt(4, version.getVparent());
		ps2.setDate(5, version.getCreatetime());
		ps2.setString(6, version.getVcomment());
		ps2.setInt(7,version.getFid());
		ps2.executeUpdate();
	}
	
	public List<VersionLink> getVersionLinks(int pid, int fid) throws SQLException {
		List<VersionLink> links = new ArrayList();
		String sql = "select vid, fid, pid, createtime, version.userid, uname, vparent, vcomment from version left join users on version.userid = users.userid" +
				" where fid = ? and pid = ? order by createtime";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setInt(1, fid);
		ps.setInt(2, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			VersionLink link = new VersionLink();
			link.setVid(rs.getInt(1));
			link.setFid(rs.getInt(2));
			link.setPid(rs.getInt(3));
			link.setCreatetime(rs.getDate(4));
			link.setUserid(rs.getInt(5));
			link.setUsername(rs.getString(6));
			link.setVparent(rs.getInt(7));
			link.setVcomment(rs.getString(8));
			links.add(link);
		}
		return links;
	}
	
	public VersionLink showVersion(int vid) throws SQLException{
		String sql="select t.vid,t.fid,t.pid,t.createtime,t.userid, u.uname, t.vtext,t.vparent,t.vcomment from version t left join users u on t.userid = u.userid where t.vid=?";
		VersionLink version=new VersionLink();
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setInt(1, vid);
		ResultSet rs =ps.executeQuery();
		if(rs.next())
		{
			version.setVid(rs.getInt(1));
			version.setFid(rs.getInt(2));
			version.setPid(rs.getInt(3));
			version.setCreatetime(rs.getDate(4));
			version.setUserid(rs.getInt(5));
			version.setUsername(rs.getString(6));
			version.setVtext(rs.getString(7));
			version.setVparent(rs.getInt(8));
			version.setVcomment(rs.getString(9));
			
		}
		return version;
	}

}
