package com.example.daoimp;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

import com.example.dao.filedDao;
import com.example.demo.Field;

public class filedImp {
	public ArrayList<Field> show(){
		ArrayList<Field> flist =new ArrayList<Field>();
		filedDao dao = new filedDao();
		
		try {
			flist=dao.show();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return flist;
		
	}
	public ArrayList<Field> Dshow(String userid){
		ArrayList<Field> flist =new ArrayList<Field>();
		filedDao dao = new filedDao();
		
		try {
			flist=dao.Dshow(userid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return flist;
		
	}
	public Field filedcheck(String fid){
		Field f =new Field();
		filedDao dao =new filedDao();
		try {
			f=dao.filedcheck(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return f;
	}
	public void deletefiled(String fid){
		filedDao dao =new filedDao();
		try {
			dao.deletefiled(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
	}
	public Field addfiled(String ftext,String fname,String userid,String pid,Date date){
		Field file =new Field();
		filedDao dao=new filedDao();
		try {
			file=dao.addfiled(ftext, fname, userid, pid, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return file;
	}
	public ArrayList<Field> trackback(String fid) {
		// TODO Auto-generated method stub
		ArrayList<Field> flist = new ArrayList<Field>();
		filedDao dao=new filedDao();
		try {
			flist=dao.trackback(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return  flist;
	}
}
