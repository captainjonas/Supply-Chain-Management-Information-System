package com.aowin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.model.Category;
import com.aowin.util.CreateLog;
import com.aowin.util.DButil;

public class CategoryDao {
	static Connection conn;
	static Statement st;
	static ResultSet rs;
	
		public static ArrayList<Category> getCategories(){
			ArrayList<Category> al=new ArrayList<Category> ();
			conn=DButil.getConn();
			String sql="select * from category";
			PreparedStatement ps=null;
			System.out.println(sql);
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				while(rs.next()){
					int id=rs.getInt(1);
					String name=rs.getString(2);
					String remark=rs.getString(3);
					Category ca=new Category(id,name,remark);
					al.add(ca);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
						CreateLog.log(CategoryDao.class);
					}
					ps=null;
				}
				DButil.close(rs, st, conn);
			}	
			return al;
		}
	
		public static boolean deleteCategory(int id){
			conn=DButil.getConn();
			String sql="select * from product where CategoryID="+id;
			System.out.println(sql);
			try {
			    st=conn.createStatement();
				rs=st.executeQuery(sql);
				if(rs.next()){
					return false;
				}else{
					String sql1="delete from category where CategoryID="+id;
					st.execute(sql1);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
			}	

			return true;
		}
		
		
		public static int setID(){
			conn=DButil.getConn();
			int max=4;
			String sql="select CategoryID from category";
			System.out.println(sql);
			try {
			    st=conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()){
				  int id=rs.getInt("CategoryID");
				  if(id>max)
					  max=id;
				}
				System.out.println(max+1);
				return max+1;
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
			}	
			return max+1;
		}

		public static void addCategory(int id, String name, String remark){
			conn=DButil.getConn();
			String sql="insert category values("+id+", '"+name+"', '"+remark+"')";
			System.out.println(sql);
			try {
			    st=conn.createStatement();
				st.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
			}	
			
		}
		
		public static void updateCategory(int id, String name, String remark){
			conn=DButil.getConn();
			String sql="update category set Name='"+name+"', Remark='"+remark+"' where CategoryID="+id;
			System.out.println(sql);
			try {
			    st=conn.createStatement();
				st.execute(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				DButil.close(rs, st, conn);
			}	
			
		}
		
		
		
}
