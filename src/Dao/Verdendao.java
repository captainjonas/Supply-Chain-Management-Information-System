package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.util.DButil;

import Model.Page;
import Model.Vender;

public class Verdendao {
	public static void shu(Page p) throws SQLException{
		ArrayList<Vender> al = new ArrayList<Vender>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select * from vender limit ?,?";
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setInt(1,(p.getNowpage()-1)*p.getPagefen());
			st.setInt(2,p.getPagefen());
			rs = st.executeQuery();
			while (rs.next()) {
				Vender c = new Vender();
				c.setCustomercode(rs.getString("vendercode"));
				c.setAddress(rs.getString("address"));
				c.setContactor(rs.getString("contactor"));
				c.setCreatedate(rs.getString("createdate"));
				c.setFax(rs.getString("fax"));
				c.setName(rs.getString("name"));
				c.setPassword(rs.getString("password"));
				c.setPostcode(rs.getString("postcode"));
				c.setTel(rs.getString("tel"));
				al.add(c);
			}
			p.setPageyu(al);
		} finally{
			DButil.close(rs, st, con);
		}
		
		
	}
	public static int ui() throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql = "select count(*) n from vender";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			rs=st.executeQuery();
			if(rs.next()){
				int n=rs.getInt("n");
			return n;
			}
			return 0;
		} finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static boolean add(Vender c) throws SQLException{
		boolean b=true;
		Connection con=null;
		PreparedStatement st=null;
		String sql="insert into vender value(?,?,?,?,?,?,?,?,?)";
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, c.getCustomercode());
			st.setString(2, c.getName());
			st.setString(3, c.getPassword());
			st.setString(4, c.getContactor());
			st.setString(5, c.getAddress());
			st.setString(6, c.getPostcode());
			st.setString(7, c.getTel());
			st.setString(8, c.getFax());
			st.setString(9, c.getCreatedate());
			b = st.execute();
			System.out.println(b);
			return b;
		} finally{
			DButil.close(null, st, con);
		}
		
	}
	public static void chuang(Vender c) throws SQLException{
		
		Connection con=null;
		PreparedStatement st=null;
		String sql="update vender set  name=? , password=? , contactor=? , address=? , postcode=? , tel=? , fax=? , createdate=? where vendercode=?" ;
		con=DButil.getConn();
		try {
			st = con.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getPassword());
			st.setString(3, c.getContactor());
			st.setString(4, c.getAddress());
			st.setString(5, c.getPostcode());
			st.setString(6, c.getTel());
			st.setString(7, c.getFax());
			st.setString(8, c.getCreatedate());
			st.setString(9, c.getCustomercode());
			st.executeUpdate();
		} finally{
			DButil.close(null, st, con);
		}
		
	}
	public static void delete(String vendercode) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		//System.out.println(vendercode);
		try {
			String sql = "delete from vender where vendercode=?";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1,vendercode);
			st.execute();
			System.out.println("ɾ���ɹ�");
		} finally{
			DButil.close(null, st, con);
		}
		
	}
	public static ArrayList<Vender> find() throws SQLException{
		ArrayList<Vender> al=new ArrayList<Vender>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql = "select name from vender";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Vender v = new Vender();
				v.setName(rs.getString("name"));
				al.add(v);
			}
			return al;
		} finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static String findname(String vendercode) throws SQLException{
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs=null;
			try {
				String sql = "select name from vender where vendercode=?";
				con = DButil.getConn();
				st = con.prepareStatement(sql);
				st.setString(1, vendercode);
				rs = st.executeQuery();
				if (rs.next()) {
					String name = rs.getString("name");
					return name;
				}
				return null;
			} finally{
				DButil.close(rs, st, con);
			}
		
	}
	public static String findid(String name) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql = "select vendercode from vender where name=?";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, name);
			rs = st.executeQuery();
			if (rs.next()) {
				String vendercode = rs.getString("vendercode");
				return vendercode;
			}
			return null;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
}
