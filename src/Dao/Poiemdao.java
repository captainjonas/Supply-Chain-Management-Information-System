package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.util.DButil;

import Model.Poiem;
import Model.Poitem;

public class Poiemdao {
	public static ArrayList<Poitem> find(String poid) throws SQLException{
		ArrayList<Poitem> al=new ArrayList<Poitem>();
		int u=0;
			Connection con = null;
			PreparedStatement st = null;
			//System.out.println(poid);
			ResultSet rs = null;
			try {
			String sql = "select num,productcode from poitem where poid=?";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, poid);
			rs = st.executeQuery();
			while (rs.next()) {
				Poitem p=new Poitem();
				p.setNum(rs.getInt("num"));
				p.setProductcode(rs.getString("productcode"));
				al.add(p);
			}
			return al;
		}finally{
			DButil.close(rs, st, con);
		}

	}
	public static void dele(String poid,ArrayList<Poitem> al) throws SQLException{
		Connection con=null;
		Statement st=null;
		ResultSet rs=null;
		int i=0;
		con = DButil.getConn();
		con.setAutoCommit(false);
		st = con.createStatement();
		String sql="delete from pomain where poid= '"+poid+"'";
		//System.out.println(sql);
		String sql1="delete from poitem where poid= '"+poid+"'";
		try {
			for (Poitem p : al) {
				String sql2 = "update product set ponum=" + p.getPonum()
						+ " where productcode= '" + p.getProductcode() + "'";
				System.out.println(sql2);
				i = st.executeUpdate(sql2);
			}
			boolean b = st.execute(sql1);
			boolean c = st.execute(sql);
			System.out.println(c);
			System.out.println(b);
			if (b == true || c == true || i == 0) {
				con.rollback();
				con.setAutoCommit(true);
			} else {
				con.commit();
				con.setAutoCommit(true);
			}
		}finally{
			DButil.close(rs, st, con);
		}
	}
	public static ArrayList<Poitem> po(String poid) throws SQLException{
		ArrayList<Poitem> al=new ArrayList<Poitem>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select *  from  poitem,product  where poitem.productcode=product.productcode and poid=? and poitem.unitName=product.unitname";
		//select price,id,name,number from shop,cart where shop.no=cart.no and account=? and status=0"
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, poid);
			rs = st.executeQuery();
			while (rs.next()) {
				Poitem p = new Poitem();
				p.setPoid(poid);
				p.setProductcode(rs.getString("productcode"));
				p.setUnitprice(rs.getBigDecimal("unitprice"));
				p.setNum(rs.getInt("num"));
				p.setUnitname(rs.getString("unitname"));
				p.setItemprice(rs.getBigDecimal("itemprice"));
				p.setName(rs.getString("name"));
				//System.out.println(p.getName());
				al.add(p);
			}
			return al;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static ArrayList<Poiem> np(String poid) throws SQLException{
		ArrayList<Poiem> al=new ArrayList<Poiem>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select * from poitem,product where poitem.ProductCode=product.ProductCode and poid=?";
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, poid);
			rs = st.executeQuery();
			while (rs.next()) {
				Poiem p = new Poiem();
				p.setProductcode(rs.getString("productcode"));
				p.setName(rs.getString("name"));
				p.setUnitname(rs.getString("unitname"));
				p.setUnitprice(rs.getBigDecimal("unitprice"));
				p.setNum(rs.getInt("num"));
				p.setItemprice(rs.getBigDecimal("itemprice"));
				al.add(p);
			}
			return al;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static boolean ap(String poid,String account) throws SQLException{
		boolean b=false;
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				String sql = "select * from pomain where poid=? and account=?";
				con = DButil.getConn();
				st = con.prepareStatement(sql);
				st.setString(1, poid);
				st.setString(2, account);
				rs = st.executeQuery();
				if (rs.next()) {
					b = true;
					return b;
				}
				return false;
			} finally{
				DButil.close(rs, st, con);
			}
		
	}
	
}
