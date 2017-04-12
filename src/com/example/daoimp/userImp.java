package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.UserDao;
import com.example.demo.User;

public class userImp {
	
	public ArrayList<User> Show(){
		ArrayList<User>  ulist =new ArrayList<User> ();
		UserDao dao = new UserDao();
		try {
			ulist = dao.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return ulist;
		
	}
	public User DetailShow(int userid){
		User user =new User();
		UserDao dao =new UserDao();
		try {
			user = dao.DetailShow(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return user;
	}
	public void Delete(int userid){
		UserDao dao = new UserDao();
		try {
			dao.Delete(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
	}
	public User Login(String username, String userpassword) {
		// TODO Auto-generated method stub
		User b=new User();
		UserDao dao = new UserDao();
			try {
				b=dao.Login(username,userpassword);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				dao.Close();
			}
		return b;
		
	}
	public User register(String uemail, String uname, String upassword,
			int uage, int ulevel, String usex) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		User user=new User();
		try {
			user=dao.register(uemail,uname,upassword,uage,ulevel,usex);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return user;
		
	}
	public boolean find(String uname) {
		// TODO Auto-generated method stub
		boolean b=false;
		UserDao dao= new UserDao();
		try {
			b=dao.find(uname);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return b;
		
	}
	public User revise(int userid ,String uname, String usex, String urealname, int uage,
			String uposition, String uemail) {
		// TODO Auto-generated method stub
		User user =new User();
		UserDao dao =new UserDao();
		try {
			user=dao.revise(userid,uname,usex,urealname,uage,uposition,uemail);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return user;
	}
	public void revisepassword(String newpassword,int userid) {
		// TODO Auto-generated method stub
		UserDao dao=new UserDao();
		try {
			dao.revisepassword(newpassword,userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		
	}
}
