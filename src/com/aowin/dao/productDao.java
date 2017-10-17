package com.aowin.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aowin.model.Page;
import com.aowin.model.Product;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class productDao {
	

		static Connection conn;
		static Statement st;
		static ResultSet rs;
		
		
			public static int queryCount(){
				String sql="select count(*) n from product";
				conn=DButil.getConn();
				try {
					st=conn.prepareStatement(sql);
					rs=st.executeQuery(sql);
					if(rs.next()){
						int n=rs.getInt("n");
						return n;
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
					CreateLog.log(productDao.class);
				}finally{
					DButil.close(rs, st, conn);
				}	
				 	return 0;
			}
			
			public static void queryProductByPage(Page p){
				String sql="select * from product limit ?,?";
				List<Product> sl=new ArrayList<Product>();
				PreparedStatement ps=null;
				ResultSet rs1=null;
				int stockNum=0;
				conn=DButil.getConn();
				try {
					ps=conn.prepareStatement(sql);
					ps.setInt(1,(p.getCurrentPage()-1)*p.getPageSize());
					ps.setInt(2,p.getPageSize());
					rs=ps.executeQuery();
					while(rs.next()){
						String proCode=rs.getString("ProductCode");
						String name=rs.getString(3);
						String unitName=rs.getString("UnitName");
						int PONum=rs.getInt("PONum");
						int SONum=rs.getInt("SONum");
						String sql1="select Num from stock where ProductCode='"+proCode+"'";
						st=conn.createStatement();
						rs1=st.executeQuery(sql1);
						if(rs1.next()){
							stockNum=rs1.getInt("Num");
						}else{
							stockNum=0;
						}
						Product pro=new Product();
						pro.setProductCode(proCode);
						pro.setName(name);
						pro.setPoNum(PONum);
						pro.setSoNum(SONum);
						pro.setStockNum(stockNum);
						pro.setUnitName(unitName);
						sl.add(pro);
					}
					
					p.setData(sl);
				} catch (SQLException e) {
					CreateLog.log(CategoryDao.class);
					e.printStackTrace();
				}finally{
					DButil.close(rs, st, conn);
					try {
						if(rs1!=null){
							rs1.close();
							rs1=null;
						}
						if(ps!=null){
							ps.close();
							ps=null;
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}	
			}

	}


