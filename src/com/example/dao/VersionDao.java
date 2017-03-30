package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.example.demo.User;
import com.example.demo.Version;
import com.example.demo.VersionLink;



public class VersionDao extends baseDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void add(Version version) throws SQLException {
		String vid=UUID.randomUUID().toString();
		String sql="insert into version (pid,fid,createtime,userid,vtext,vparent,vcomment,vid) values(?,?,?,?,?,?,?,?) ";
		String sql2="insert into filed (fname,pid,userid,ftext,fatherid,fdate,fid) select fname,?,?,?,?,?,? from field_base where fid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setString(1,version.getPid());
		ps.setInt(2,version.getFid());
		ps.setDate(3, version.getCreatetime());
		ps.setString(4, version.getUserid());
		ps.setString(5, version.getVtext());
		ps.setString(6, version.getVparent());
		ps.setString(7, version.getVcomment());
		ps.setString(8, vid);
        ps.executeUpdate();
		PreparedStatement ps2 =this.conn.prepareStatement(sql2);
		ps2.setString(1, version.getPid());
		ps2.setString(2, version.getUserid());
		ps2.setString(3, version.getVtext());
		ps2.setString(4, version.getVparent());
		ps2.setDate(5, version.getCreatetime());
		ps2.setString(6, vid);
		ps2.setInt(7,version.getFid());
		ps2.executeUpdate();
	}
	
	public List<VersionLink> getVersionLinks(String pid, int fid) throws SQLException {
		List<VersionLink> links = new ArrayList();
		String sql = "select vid, fid, pid, createtime, version.userid, uname, vparent, vcomment from version left join users on version.userid = users.userid" +
				" where fid = ? and pid = ? order by createtime";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setInt(1, fid);
		ps.setString(2, pid);
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			VersionLink link = new VersionLink();
			link.setVid(rs.getString(1));
			link.setFid(rs.getInt(2));
			link.setPid(rs.getString(3));
			link.setCreatetime(rs.getDate(4));
			link.setUserid(rs.getString(5));
			link.setUsername(rs.getString(6));
			link.setVparent(rs.getString(7));
			link.setVcomment(rs.getString(8));
			links.add(link);
		}
		return links;
	}
	
	public VersionLink showVersion(String vid) throws SQLException{
		String sql="select t.vid,t.fid,t.pid,t.createtime,t.userid, u.uname, t.vtext,t.vparent,t.vcomment from version t left join users u on t.userid = u.userid where t.vid=?";
		VersionLink version=new VersionLink();
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, vid);
		ResultSet rs =ps.executeQuery();
		if(rs.next())
		{
			version.setVid(rs.getString(1));
			version.setFid(rs.getInt(2));
			version.setPid(rs.getString(3));
			version.setCreatetime(rs.getDate(4));
			version.setUserid(rs.getString(5));
			version.setUsername(rs.getString(6));
			version.setVtext(rs.getString(7));
			version.setVparent(rs.getString(8));
			version.setVcomment(rs.getString(9));
			
		}
		return version;
	}

}
