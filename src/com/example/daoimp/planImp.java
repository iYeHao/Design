package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.example.dao.planDao;
import com.example.demo.Plan;

public class planImp {
public ArrayList<Plan> show(String searchStr){
	ArrayList<Plan> plist =new ArrayList<Plan>();
	planDao dao =new planDao();
	try {
		plist=dao.show(searchStr);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return plist;
}
public ArrayList<Plan> ShowDetail(int userid){
	ArrayList<Plan> planlist =new ArrayList<Plan>();
	planDao dao =new planDao();
	try {
		planlist =dao.DetailShow(userid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return planlist;
}
public Plan showPlan(int pid){
	Plan plan = null;
	planDao dao =new planDao();
	try {
		plan =dao.PlanShow(pid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return plan;
}
public Plan PlanCheck(int pid){
	Plan plan =new Plan();
	planDao dao = new planDao();
	try {
		plan=dao.PlanCheck(pid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return plan;
}
public int addplan(String pname, String ptype, Date d, int userid) {
	// TODO Auto-generated method stub
	int pid=0;
	planDao dao =new planDao();
	try {
		pid=dao.addplan(pname,ptype,d,userid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return pid;
}
}
