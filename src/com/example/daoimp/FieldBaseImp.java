package com.example.daoimp;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.dao.FieldBaseDao;
import com.example.demo.FieldBase;
import com.example.demo.MainField;

public class FieldBaseImp {
	
	public List<FieldBase> getAllFields(){
		List<FieldBase> fields = new ArrayList<FieldBase>();
		FieldBaseDao dao = new FieldBaseDao();
		try {
			fields=dao.getAllFields();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return fields;
	}
	
	public List<MainField> getMainFields() {
		List<MainField> mfields = new ArrayList<MainField>();
		List<FieldBase> fields = getAllFields();
		Map<Integer, MainField> fieldMap = new HashMap();
		for(int i = 0; i < fields.size(); i++) {
			FieldBase fb = fields.get(i);
			if(fb.getFlevel() == 1) {
				MainField mf = new MainField();
				mf.setFid(fb.getFid());
				mf.setFlevel(fb.getFlevel());
				mf.setFname(fb.getFname());
				mf.setFparent(fb.getFparent());
				mf.setChildren(new ArrayList<FieldBase>());
				fieldMap.put(mf.getFid(), mf);
				mfields.add(mf);
			}
		}
		for(int i = 0; i < fields.size(); i++) {
			FieldBase fb = fields.get(i);
			if(fb.getFlevel() != 1) {
				MainField mf = fieldMap.get(fb.getFparent());
				mf.getChildren().add(fb);
			}
		}
		return mfields;
	}
	
	public String getName(int fid) {
		String name = null;
		FieldBaseDao dao = new FieldBaseDao();
		try {
			name = dao.getName(fid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return name;
	}
	
	public int getId(String name) {
		int id = -1;
		FieldBaseDao dao = new FieldBaseDao();
		try {
			id = dao.getId(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			dao.Close();
		}
		return id;
	}
}
