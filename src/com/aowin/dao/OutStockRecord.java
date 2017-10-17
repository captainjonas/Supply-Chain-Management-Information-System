package com.aowin.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import com.aowin.model.SoItem;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class OutStockRecord {
	Connection conn;
	Statement st;
	ResultSet rs;
	
	public ArrayList<SoItem> getOutStockRecord(String month){
		ArrayList<SoItem> al=new ArrayList<SoItem>();
		conn=DButil.getConn();
		String sql0="select * from outstockrecord";
		Statement st1=null,st2=null;
		ResultSet rs0=null,rs2=null;
		try {
			st=conn.createStatement();
			rs0=st.executeQuery(sql0);
			while(rs0.next()){
				String time=rs0.getString("StockTime");
				if(time.startsWith(month)){
					SoItem item=new SoItem();
					String proCode=rs0.getString("ProductCode");
					int num=rs0.getInt("StockNum");
					String type="";
					String soid=rs0.getString(3);
					int stockType=rs0.getInt("StockType");
					if(stockType==2){
						type="销售出库";
					}
					String sql1="select Name,Price from product where ProductCode='"+proCode+"'";
					System.out.println(sql1);
					st1=conn.createStatement();
					rs2=st1.executeQuery(sql1);
					BigDecimal itemPrice=new BigDecimal(0.00);
					String name="";
					if(rs2.next()){
						name=rs2.getString("Name");
						BigDecimal n=new BigDecimal(num);
						itemPrice=rs2.getBigDecimal(2).multiply(n);
					}
					item.setProductCode(proCode);
					item.setSoid(soid);
					item.setProductName(name);
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
					if(time1.startsWith(month)&&rs.getString("Type").equals("损耗")){
						String name1="";
						SoItem item1=new SoItem();
						String proCode=rs.getString("ProductCode");
						int originNum=rs.getInt("OriginNum");
						int RealNum=rs.getInt("RealNum");
						int num1=originNum-RealNum;
						String type="盘点出库";
						String order="NG";
						String sql1="select Name,Price from product where ProductCode='"+proCode+"'";
						st1=conn.createStatement();
						rs2=st1.executeQuery(sql1);
						BigDecimal itemPrice=new BigDecimal(0.00);
						if(rs2.next()){
							name1=rs2.getString("Name");
							BigDecimal n=new BigDecimal(num1);
							itemPrice=rs2.getBigDecimal(2).multiply(n);
						}
						item1.setProductCode(proCode);
						item1.setSoid(order);
						item1.setProductName(name1);
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
