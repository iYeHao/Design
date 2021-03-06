package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;

import com.example.dao.planDao;
import com.example.demo.Plan;
import com.example.demo.PlanDetail;

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
public ArrayList<Plan> ShowDetail(String userid){
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
public Plan PlanCheck(String pid){
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
public Plan showPlan(String pid){
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
public String addplan(String pname, String ptype, Date d, String userid) {
	// TODO Auto-generated method stub
	String pid=null;
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
public PlanDetail getPlanDetail(String pid) {
	PlanDetail detail = null;
	planDao dao =new planDao();
	try {
		detail = dao.getPlanDetail(pid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return detail;
}

public PlanDetail getBestPlanDetail(String pid) {
	PlanDetail detail = null;
	planDao dao =new planDao();
	try {
		detail = dao.getBestPlanDetail(pid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return detail;
}
/*public int planClone(int pid, List<Integer> vids, int userid) {
	int newPid  = 0;
	planDao dao =new planDao();
	try {
		newPid = dao.planClone(pid, vids, userid);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		dao.Close();
	}
	return newPid;
}
*/
}
