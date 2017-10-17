package com.aowin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class CheckStoreDao {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	

		public static void addCheckStock(int RealNum,String type, String description, String time, String createUser,String code,int originNum,String unitName, String name){
			conn=DButil.getConn();
			String sql1="";
			if(originNum!=0){
				sql1="update stock set Num="+RealNum+" where ProductCode='"+code+"'";
			}else{
				sql1="insert stock values('"+code+"', '"+name+"', '"+unitName+"', "+RealNum+")";
			}
			
			String sql="insert checkstock (ProductCode, OriginNum, RealNum, StockTime, CreateUser, Description, Type) values('"+code+"', "+originNum+", "+RealNum+", '"+time+"', '"+createUser+"', '"+description+"', '"+type+"')";
			System.out.println(sql);
			System.out.println(sql1);
			try{
				conn.setAutoCommit(false);
				st=conn.createStatement();
				int result1=st.executeUpdate(sql1);
				int result2=st.executeUpdate(sql);
				if(result1!=1||result2!=1){
						try {
							throw new Exception("cancel");
						} catch (Exception e) {
							conn.rollback();
							conn.setAutoCommit(true);
							System.err.println(e.getMessage());
						}
				}
				conn.commit();
				conn.setAutoCommit(true);
		
			}catch (SQLException e) {
				e.printStackTrace();
				CreateLog.log(CategoryDao.class);
			}finally{
				DButil.close(rs, st, conn);
			}	
			
		}
		
		

}
