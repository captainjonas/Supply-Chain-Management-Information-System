package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.util.DButil;

import Model.Ploi;

public class Polidao {
	public static ArrayList<Ploi> find(String sql) throws SQLException{
		ArrayList<Ploi> al=new ArrayList<Ploi>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Ploi p = new Ploi();
				p.setPoid(rs.getString("poid"));
				p.setAccount(rs.getString("account"));
				p.setVendercode(rs.getString("vendercode"));
				//System.out.println(p.getPoid());
				p.setCreatetime(rs.getString("createtime"));
				p.setName(rs.getString("name"));
				p.setTipfee(rs.getBigDecimal("tipfee"));
				p.setProducttotal(rs.getBigDecimal("producttotal"));
				p.setPototal(rs.getBigDecimal("pototal"));
				p.setPaytype(rs.getString("paytype"));
				p.setPrepayfee(rs.getBigDecimal("prepayfee"));
				p.setStatus(rs.getInt("status"));
				p.setRemark(rs.getString("remark"));
				p.setStocktime(rs.getString("stocktime"));
				p.setStockuser(rs.getString("stockuser"));
				p.setPrepaytime(rs.getString("prepaytime"));
				p.setPrepayuser(rs.getString("prepayuser"));
				al.add(p);
				System.out.println(al);
			}
			return al;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static void up(String poid) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		try {
			String sql = "update pomain set status=4 where poid=?";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, poid);
			st.executeUpdate();
		}finally{
			DButil.close(null, st, con);
		}
	}
	public static int uop(String startime,String endtime) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		int n1=0;
		try {
			String sql = "select count(*) n from pomain where createtime>=? and createtime<=?";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1,startime);
			st.setString(2, endtime);
			rs=st.executeQuery();
			if(rs.next()){
				n1=rs.getInt("n");
				return n1;
			}
			return 0;
		}finally{
			DButil.close(rs, st, con);
		}
	}
	public static int iop(String startime,String endtime) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		int n1=0;
		try {
			String sql = "select count(*) n from pomain where createtime>=? and createtime<=? and status=4";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1,startime);
			st.setString(2, endtime);
			rs=st.executeQuery();
			if(rs.next()){
				n1=rs.getInt("n");
				return n1;
			}
			return 0;
		}finally{
			DButil.close(rs, st, con);
		}
	}
	public static ArrayList<BigDecimal> poi(String startime,String endtime) throws SQLException{
			ArrayList<BigDecimal> al=new ArrayList<BigDecimal>();
			Connection con=null;
			PreparedStatement st=null;
			ResultSet rs = null;
			String sql = "select pototal from pomain where paytime>=? and PayTime<=?";
			try {
				con = DButil.getConn();
				st = con.prepareStatement(sql);
				st.setString(1, startime);
				st.setString(2, endtime);
				rs = st.executeQuery();
				while (rs.next()) {
					BigDecimal f = rs.getBigDecimal("pototal");
					al.add(f);
				}
				return al;
			} finally{
				DButil.close(rs, st, con);
			}
		
	}
}
