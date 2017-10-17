package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.model.User;
import com.aowin.util.DButil;


public class Userdao {
	public static  User  getUser(String name,String password) throws SQLException{
		User u=new User();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select * from scmuser where account=? and password=?";
		try {
			con = DButil.getConn();
			System.out.println(con);
			st = con.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, password);
			rs = st.executeQuery();
			if (rs.next()) {
				u.setAccount(rs.getString("account"));
				u.setCreatedate(rs.getString("createdate"));
				u.setPassword(rs.getString("password"));
				u.setName(rs.getString("name"));
				u.setStatus(rs.getString("status"));
				return u;
			}
			return null;
		} finally{
			DButil.close(rs, st, con);
		}
		
	}
	
	public static ArrayList<String> find(String account) throws SQLException{
		ArrayList<String> al=new ArrayList<String>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select modelname from usermodel u,systemmodel s where account=? and s.ModelCode=u.ModelCode";
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, account);
			rs = st.executeQuery();
			while (rs.next()) {
				String auth = rs.getString("modelname");
				al.add(auth);
			}
			return al;
		}finally{
			DButil.close(rs, st, con);
		}
	}
	
	
	
}
