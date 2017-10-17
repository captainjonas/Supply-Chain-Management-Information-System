package com.aowin.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.model.Record;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class RecordDao {

	
		public ArrayList<Record> getInstockRecords(String productCode){
			Connection conn=null;
			Statement st=null,st1=null;
			ResultSet rs=null;
			ResultSet rs2=null;
			ArrayList<Record> al=new ArrayList<Record>();
			conn=DButil.getConn();
			try {
				String type="";
				int stockNum=0;
				String sql="select * from instockrecord where productCode="+productCode;
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					String orderCode=rs.getString("OrderCode");
						int stockType=rs.getInt("StockType");
						if(stockType==1){
							type="采购入库";
							stockNum=rs.getInt("StockNum");
						
					}
					String createUser=rs.getString("CreateUser");
					String stockTime=rs.getString("stockTime");
					Record rec=new Record(stockTime,orderCode,createUser,stockNum,type);
					al.add(rec);
				}
				String sql1="select * from checkstock where Type='盈余' and productCode="+productCode;
				st1=conn.createStatement();
				rs2=st1.executeQuery(sql1);
				while(rs2.next()){
						type="盘点入库";
						int realNum=rs2.getInt(4);
						int originNum=rs2.getInt(3);
						stockNum=realNum-originNum;
						String order="NG";
					String createUser=rs2.getString("CreateUser");
					String stockTime=rs2.getString("stockTime");
					Record rec1=new Record(stockTime,order,createUser,stockNum,type);
					al.add(rec1);
				}
				return al;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
				if(rs2!=null||st1!=null){
					try {
						rs2.close();
						st1.close();
						rs2=null;
						st1=null;
					} catch (SQLException e) {
						CreateLog.log(RecordDao.class);
						e.printStackTrace();
					}
					
				}
			}	
			return al;
		}
		
		
		
		public ArrayList<Record> getOutstockRecords(String productCode){
			Connection conn=null;
			Statement st=null,st1=null;
			ResultSet rs=null,rs2=null;
			ArrayList<Record> al=new ArrayList<Record>();
			conn=DButil.getConn();
			try {
				String type="";
				int stockNum=0;
				String sql="select * from outstockrecord where productCode="+productCode;
				System.out.println(sql);
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					String orderCode=rs.getString("OrderCode");
						int stockType=rs.getInt("StockType");
						if(stockType==2){
							type="销售出库";	
					}
						stockNum=rs.getInt("StockNum");
					String createUser=rs.getString("CreateUser");
					String stockTime=rs.getString("stockTime");
					Record rec=new Record(stockTime,orderCode,createUser,stockNum,type);
					al.add(rec);
				}
				String sql1="select * from checkstock where Type='损耗' and productCode="+productCode;
				System.out.println(sql1);
				st1=conn.createStatement();
				rs2=st1.executeQuery(sql1);
				while(rs2.next()){
						type="盘点出库";
						int realNum=rs2.getInt(4);
						int originNum=rs2.getInt(3);
						stockNum=originNum-realNum;
						String order="NG";
					String createUser=rs2.getString(6);
					String stockTime=rs2.getString(5);
					Record rec1=new Record(stockTime,order,createUser,stockNum,type);
					al.add(rec1);
				}
				return al;
				
			} catch (SQLException e) {
				CreateLog.log(CategoryDao.class);
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
				if(rs2!=null||st1!=null){
					try {
						rs2.close();
						st1.close();
						rs2=null;
						st1=null;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}	
			return al;
		}
	
}
