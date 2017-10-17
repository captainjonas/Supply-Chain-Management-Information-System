package com.aowin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DButil {
	public static Connection conn=null;
	public static Statement st=null;
	public static String url="jdbc:mysql://localhost:3306/crebas";
	public static String user="root";
	public static String password="daxian";
	
	
	
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn(){
		try {
			conn=DriverManager.getConnection(url,user,password);
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
	public static void close(ResultSet rs,Statement st,Connection conn){
		try {
			if(rs!=null){
				rs.close();
				rs=null;
			}
			if(st!=null){
				st.close();
				st=null;
			}
			if(conn!=null){
				conn.close();
				conn=null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
