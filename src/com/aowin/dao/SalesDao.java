package com.aowin.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.model.SoItem;
import com.aowin.model.Somain;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class SalesDao {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	
		public static ArrayList<Somain> getSomain(String payType){
			int flag=1;
			if(payType.equals("款到发货")){
				flag=3;
			}else if(payType.equals("预付款到发货")){
				flag=5;
			}
			ArrayList<Somain> al=new ArrayList<Somain> ();
			conn=DButil.getConn();
			String sql="select * from somain where PayType=?";
			System.out.println(sql);
			PreparedStatement ps=null;
			ResultSet rs2=null,rs1=null;
			Statement st1=null;
			String customerName="",creatorName="";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, payType);
				rs=ps.executeQuery();
				while(rs.next()){
		            int status=rs.getInt("Status");
		            if(status==flag){
		            	String soid=rs.getString(1);
						String createtime=rs.getString(4);
						String customerCode=rs.getString("customerCode");
						String sql2="select Name from customer where customerCode='"+customerCode+"'";
						System.out.println(sql2);
						st=conn.createStatement();
						rs2=st.executeQuery(sql2);
						if(rs2.next()){
							customerName=rs2.getString("Name");
						}
						String account=rs.getString("Account");
						String sql1="select Name from scmuser where Account='"+account+"'";
						st1=conn.createStatement();
						rs1=st1.executeQuery(sql1);
						if(rs1.next()){
							creatorName=rs1.getString("Name");
						}
						BigDecimal tipfee=rs.getBigDecimal("TipFee");
						BigDecimal producttotal=rs.getBigDecimal(6);
						BigDecimal soTotal=rs.getBigDecimal(7);
						BigDecimal prepayfee=rs.getBigDecimal(9);
						
						Somain so=new Somain();
					    so.setSoid(soid);
					    so.setCreateTime(createtime);
					    so.setCustomerName(customerName);
					    so.setTipFee(tipfee);
					    so.setProductTotal(producttotal);
					    so.setSoTotal(soTotal);
					    so.setPrepayFee(prepayfee);
					    so.setCreatorName(creatorName);
						al.add(so);
		            }
					
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs2!=null){
					try {
						rs2.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rs2=null;
				}
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ps=null;
				}
				DButil.close(rs1, st1, conn);
				DButil.close(rs, st, conn);
				
			}	
			return al;
		}
		
		
		public static SoItem getItem(String soid){
			SoItem item=new SoItem();
			conn=DButil.getConn();
			String sql="select * from soitem where SOID='"+soid+"'";
			PreparedStatement ps=null;
			System.out.println(sql);
			ResultSet rs2=null;
			String name="";
			try {
				st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
					String proCode=rs.getString(2);
					BigDecimal unitPrice=rs.getBigDecimal(3);
					int num=rs.getInt(4);
					String unitName=rs.getString(5);
					BigDecimal itemPrice=rs.getBigDecimal(6);
					String sql1="select Name from product where ProductCode='"+proCode+"'";
					ps=conn.prepareStatement(sql1);
					rs2=ps.executeQuery();
					if(rs2.next()){
						name=rs2.getString("Name");
					}
					item=new SoItem(soid,proCode,unitPrice,num, unitName, itemPrice, name);
					return item;
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs2!=null){
					try {
						rs2.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					rs2=null;
				}
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					ps=null;
				}
				DButil.close(rs, st, conn);
			}	
			return item;
		}
		
		
		public static void outStock(String soid,String time,String createUser){
			conn=DButil.getConn();
			String code="",sql2="",name="",unitName="";
			int num=0,soNum=0;
			Statement st0=null;
			ResultSet rs0=null,rs5=null,rs6=null,rs9=null;
			String sql0="select ProductCode,Num from soitem where SOID='"+soid+"'";
			try{
			st0=conn.createStatement();
			rs0=st0.executeQuery(sql0);
			if(rs0.next()){
				code=rs0.getString("ProductCode");
				num=rs0.getInt("Num");
			}
			String sql5="select Name, UnitName from product where ProductCode='"+code+"'";
			rs6=st0.executeQuery(sql5);
			if(rs6.next()){
				name=rs6.getString("Name");
				unitName=rs6.getString("UnitName");
			}
			
			
			String sql="select Num from stock where ProductCode='"+code+"'";
			rs5=st0.executeQuery(sql);
			if(rs5.next()){
				int number=rs5.getInt("Num");
				int n=number-num;
				sql2="update stock set Num="+n+" where ProductCode='"+code+"'";
			}
			
			String sql1="insert outstockrecord (ProductCode, OrderCode, StockNum, StockType, StockTime, CreateUser) values('"+code+"', '"+soid+"', "+num+",2, '"+time+"', '"+createUser+"')";
			String sql3="update somain set status=6, stockTime='"+time+"', StockUser='"+createUser+"' where SOID='"+soid+"'";
			
			String sql9="select SONum from product where ProductCode='"+code+"'";
			st=conn.createStatement();
			rs9=st.executeQuery(sql9);
			if(rs9.next()){
				soNum=rs9.getInt("SONum");
			}
			int n9=soNum-num;
			String sql4="update product set SoNum="+n9+" where ProductCode='"+code+"'";
			System.out.println(sql1);
			System.out.println(sql2);
			System.out.println(sql3);
			System.out.println(sql4);
			
				conn.setAutoCommit(false);
				
				int result3=st.executeUpdate(sql3);
				int result4=st.executeUpdate(sql4);
				int result2=st.executeUpdate(sql2);
				int result1=st.executeUpdate(sql1);
				
				
				if(result1!=1||result2!=1||result3!=1||result4!=1){
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
				CreateLog.log(CategoryDao.class);
				e.printStackTrace();
			}finally{
				if(rs5!=null||rs6!=null||rs9!=null){
					try {
						rs5.close();
						rs6.close();
						rs9.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
					rs5=null;
					rs6=null;
					rs9=null;
				}
				DButil.close(rs, st, conn);
				DButil.close(rs0, st0, conn);
			}	
			
		}

}
