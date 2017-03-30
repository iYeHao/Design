package com.example.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.UUID;

import com.example.demo.User;

public class UserDao extends baseDao{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ArrayList<User> show() throws SQLException{
		ArrayList<User> ulist = new ArrayList<User> ();
		String sql="select * from users";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		java.sql.ResultSet rs = ps.executeQuery();
		while(rs.next()){
			User user=new User();
			user.setUserid(rs.getString(1));
			user.setUpassword(rs.getString(4));
			user.setUname(rs.getString(3));
			user.setUemail(rs.getString(2));
			user.setUage(rs.getInt(5));
			user.setUlevel(rs.getInt(6));
			user.setUsex(rs.getString(7));
			ulist.add(user);
		}
		return ulist;
	}
	public User DetailShow(String userid) throws SQLException{
		User user =new User();
		String sql="select * from users where userid = ?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setObject(1, userid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			
			user.setUserid(rs.getString(1));
			user.setUpassword(rs.getString(4));
			user.setUname(rs.getString(3));
			user.setUemail(rs.getString(2));
			user.setUage(rs.getInt(5));
			user.setUlevel(rs.getInt(6));
			user.setUsex(rs.getString(7));
			user.setUrealname(rs.getString(8));
			user.setUposition(rs.getString(9));
		}
		return user;
		
	}
	public void Delete(String userid) throws SQLException{
		String sql ="delete from plan where userid =?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setObject(1, userid);
		java.sql.ResultSet rs =ps.executeQuery();
		rs.deleteRow();
	}                                                                                                            
	public User Login(String username, String userpassword) throws SQLException {
		// TODO Auto-generated method stub
		User user=new User();
		String sql="select *from users where uname=? and upassword=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setObject(1, username);
		ps.setObject(2, userpassword);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			
			user.setUserid(rs.getString(1));
		}
		return user;
	}
	public User register(String uemail, String uname, String upassword,
			int uage, int ulevel, String usex) throws SQLException {
		User user=null;
		String userid=UUID.randomUUID().toString();
		String sql="Insert into users (userid,uemail,uname,upassword,uage,ulevel,usex) values(?,?,?,?,?,?,?)";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setObject(1,userid);
		ps.setObject(2, uemail);
		ps.setObject(3, uname);
		ps.setObject(4, upassword);
		ps.setObject(5, uage);
		ps.setObject(6, ulevel);
		ps.setObject(7, usex);
		ps.setString(1,userid);
		ps.setString(2, uemail);
		ps.setString(3, uname);
		ps.setString(4, upassword);
		ps.setInt(5, uage);
		ps.setInt(6, ulevel);
		ps.setString(7, usex);
		ps.executeUpdate();
		user=new User();
		return user;
	}
	public boolean find(String uname) throws SQLException {
		// TODO Auto-generated method stub
		boolean b=false;
		String sql="select * from users where uname=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setObject(1, uname);
		java.sql.ResultSet rs =ps.executeQuery();
		while (rs.next()){
			b=true;
		}
		return b;
		
	}
	public User revise(String userid,String uname, String usex, String urealname, int uage,
			String uposition, String uemail) throws SQLException {
		// TODO Auto-generated method stub
		User user=null;
	String sql="update users  set uname=?, usex=?,urealname=?,uage=?,uposition=?,uemail=? where userid = ?"	;
	this.ConnetOrcl();
	java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
	ps.setObject(7,userid);
	ps.setObject(1, uname);
	ps.setObject(2, usex);
	ps.setObject(3, urealname);
	ps.setObject(4, uage);
	ps.setObject(5, uposition);
	ps.setObject(6, uemail);
	ps.setString(7,userid);
	ps.setString(1, uname);
	ps.setString(2, usex);
	ps.setString(3, urealname);
	ps.setInt(4, uage);
	ps.setString(5, uposition);
	ps.setString(6, uemail);
	ps.executeQuery();
	user =new User();
	user.setUserid(userid);
	
	return user;
	}
	public void revisepassword(String newpassword,String userid) throws SQLException {
		// TODO Auto-generated method stub
		String sql="update users set upassword=? where userid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setObject(1,newpassword);
		ps.setObject(2, userid);
		ps.setString(1, newpassword);
		ps.setString(2, userid);
		ps.executeUpdate();
	}
	public void reviselevel(double level ,String userid) throws SQLException {
		// TODO Auto-generated method stub
		double plevel=0;
		String sql="select * from users where userid=?";
		this.ConnetOrcl();
		java.sql.PreparedStatement ps=this.conn.prepareStatement(sql);
		ps.setString(1, userid);
		java.sql.ResultSet rs =ps.executeQuery();
		while(rs.next()){
			plevel=rs.getDouble(6);
		}
		if(plevel==0){
		String sql2="update users set ulevel=? where userid=?";
		java.sql.PreparedStatement ps2=this.conn.prepareStatement(sql2);
		ps2.setDouble(1,  level);
		ps2.setString(2, userid);
		ps2.executeQuery();
		
		}else{
			String sql3="update users set ulevel=? where userid=?";
			java.sql.PreparedStatement ps3=this.conn.prepareStatement(sql3);
			ps3.setDouble(1,(level+plevel)*0.5);
			ps3.setString(2,userid);
			ps3.executeQuery();
		}
	}
}
