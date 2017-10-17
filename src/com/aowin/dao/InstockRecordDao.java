package com.aowin.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.model.PoItem;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class InstockRecordDao {
	Connection conn;
	Statement st;
	ResultSet rs;
	
	public ArrayList<PoItem> getInStockRecord(String month){
		ArrayList<PoItem> al=new ArrayList<PoItem>();
		
		conn=DButil.getConn();
		String sql0="select * from instockrecord";
		Statement st1=null,st2=null;
		ResultSet rs0=null,rs2=null;
		String name="";
		try {
			st=conn.createStatement();
			rs0=st.executeQuery(sql0);
			while(rs0.next()){
				String time=rs0.getString("StockTime");
				if(time.startsWith(month)){
					PoItem item=new PoItem();
					String poid="";
					String proCode=rs0.getString("ProductCode");
					int num=rs0.getInt("StockNum");
					String type="";
					poid=rs0.getString(3);
					int stockType=rs0.getInt("StockType");
					if(stockType==1){
						type="采购入库";
					}
					String sql1="select Name,Price from product where ProductCode='"+proCode+"'";
					System.out.println(sql1);
					st1=conn.createStatement();
					rs2=st1.executeQuery(sql1);
					BigDecimal itemPrice=new BigDecimal(0.00);
					if(rs2.next()){
						name=rs2.getString("Name");
						BigDecimal n=new BigDecimal(num);
						itemPrice=rs2.getBigDecimal(2).multiply(n);
					}
					item.setProCode(proCode);
					item.setPoID(poid);
					item.setProName(name);
					item.setStockTime(time);
					item.setType(type);
					item.setNum(num);
					item.setItemPrice(itemPrice);
					al.add(item);
					}
			}
				
				String sql3="select * from checkstock";
				st2=conn.createStatement();
				rs=st2.executeQuery(sql3);
				while(rs.next()){
					String time1=rs.getString("StockTime");
					if(time1.startsWith(month)&&rs.getString("Type").equals("盈余")){
						PoItem item1=new PoItem();
						String proCode=rs.getString("ProductCode");
						int originNum=rs.getInt("OriginNum");
						int RealNum=rs.getInt("RealNum");
						int num1=RealNum-originNum;
						String type="盘点入库";
						String order="NG";
						String sql1="select Name,Price from product where ProductCode='"+proCode+"'";
						st1=conn.createStatement();
						rs2=st1.executeQuery(sql1);
						BigDecimal itemPrice=new BigDecimal(0.00);
						if(rs2.next()){
							name=rs2.getString("Name");
							BigDecimal n=new BigDecimal(num1);
							itemPrice=rs2.getBigDecimal(2).multiply(n);
						}
						item1.setProCode(proCode);
						item1.setPoID(order);
						item1.setProName(name);
						item1.setStockTime(time1);
						item1.setType(type);
						item1.setNum(num1);
						item1.setItemPrice(itemPrice);
						al.add(item1);
						}
						
			}	
		} catch (SQLException e) {
			e.printStackTrace();
			CreateLog.log(CategoryDao.class);
		}finally{
			DButil.close(rs, st, conn);
			DButil.close(rs0, st1, conn);
			DButil.close(rs2, st2, conn);
		}	
		return al;
	}

}
