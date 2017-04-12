package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dao.VersionDao;
import com.example.dao.planDao;
import com.example.demo.Plan;
import com.example.demo.Version;
import com.example.demo.VersionLink;

public class VersionImp {
	
	public boolean add(Version version) {
		boolean ok = true;
		VersionDao dao = new VersionDao();
		try {
			dao.add(version);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ok = false;
		}
		return ok;
	}
	
	public List<VersionLink> getLinks(String pid, int fid) {
		List<VersionLink> result = null;
		VersionDao dao = new VersionDao();
		try {
			result = dao.getVersionLinks(pid, fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public VersionLink showVersion(String vid){
		VersionLink version = null;
		VersionDao dao =new VersionDao();
		try {
			version =dao.showVersion(vid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return version;
	}
	public void versionClone(List<String> vids) {
		VersionDao dao =new VersionDao();
		try {
			dao.versionClone(vids);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
	}
	public int versionClone1(int parseInt) {
		// TODO Auto-generated method stub
		return 0;
	}


}
