package com.aowin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.model.Stock;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class StockDao {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	
		public static ArrayList<Stock> getInStock(String sql){
			ArrayList<Stock> al=new ArrayList<Stock> ();
			conn=DButil.getConn();
		 
			try {
				st=conn.createStatement();
				System.out.println(sql);
				rs=st.executeQuery(sql);
				while(rs.next()){
					String proCode=rs.getString("ProductCode");
					String Name=rs.getString(2);
					int Num=rs.getInt(4);
					String unit=rs.getString(3);
					Stock s=new Stock(proCode,Name,unit,Num);
					al.add(s);
				}
				
			} catch (SQLException e) {
				CreateLog.log(CategoryDao.class);
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
			}	
			return al;
		}
	

}
