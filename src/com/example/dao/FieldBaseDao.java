package com.example.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.FieldBase;

public class FieldBaseDao extends baseDao {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<FieldBase> getAllFields() throws SQLException {
		List<FieldBase> fields= new ArrayList<FieldBase>();
		String sql="select * from field_base order by fid";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ResultSet rs =ps.executeQuery();
		while(rs.next()){
			FieldBase field =new FieldBase();
			field.setFid(rs.getInt(1));
			field.setFname(rs.getString(2));
			field.setFparent(rs.getInt(3));
			field.setFlevel(rs.getInt(4));
			fields.add(field);
		}
		return fields;
	}
	
	public String getName(int fid) throws SQLException {
		String name = null;
		String sql = "select fname from field_base where fid = ?";
		this.ConnetOrcl();
		PreparedStatement ps =this.conn.prepareStatement(sql);
		ps.setInt(1, fid);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			name = rs.getString(1);
		}
		return name;
	}
	
	public int getId(String name) throws SQLException {
		int id = 0;
		String sql = "select fid from field_base where fname = ?";
		this.ConnetOrcl();
		PreparedStatement ps = this.conn.prepareStatement(sql);
		ps.setString(1, name);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			id = rs.getInt(1);
		}
		return id;
	}
}
