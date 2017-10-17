package Dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.aowin.util.DButil;

import Model.Page1;
import Model.Ploi;
import Model.Poitem;
import Model.Pomain;

public class Pomaindao {
	public static String att(String name) throws SQLException{
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
				String u = rs.getString("vendercode");
				return u;
			} else {
				return null;

			}
		}finally{
			DButil.close(rs, st, con);
		}
	}
	public static ArrayList<Pomain> at(String vendercode) throws SQLException{
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select status from pomain where vendercode=?";
		con=DButil.getConn();
		st=con.prepareStatement(sql);
		st.setString(1, vendercode);
		rs=st.executeQuery();
		while(rs.next()){
			Pomain p=new Pomain();
			p.setStatus(rs.getInt("status"));
			al.add(p);
		}
		return al;
	}
	public static void find(Page1 p) throws SQLException{
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select * from pomain limit ?,?";
		con=DButil.getConn();
		st=con.prepareStatement(sql);
		st.setInt(1, (p.getNowpage()-1)*p.getPagefen());
		st.setInt(2,p.getPagefen());
		rs=st.executeQuery();
		while(rs.next()){
			Pomain p1=new Pomain();
			p1.setPoid(rs.getString("poid"));
			p1.setVendercode(rs.getString("vendercode"));
			p1.setAccount(rs.getString("account"));
			p1.setCreatetime(rs.getString("createtime"));
			p1.setTipfee(rs.getBigDecimal("tipfee"));
			p1.setProducttotal(rs.getBigDecimal("producttotal"));
			p1.setPototal(rs.getBigDecimal("pototal"));
			p1.setPaytype(rs.getString("paytype"));
			p1.setPrepayfee((rs.getBigDecimal("prepayfee")));
			p1.setStatus(rs.getInt("status"));
			p1.setRemark(rs.getString("remark"));
			p1.setStocktime(rs.getString("stocktime"));
			p1.setStockuser(rs.getString("stockuser"));
			p1.setPaytime(rs.getString("paytime"));
			p1.setPayuser(rs.getString("payuser"));
			p1.setPrepaytime(rs.getString("prepaytime"));
			p1.setPrepayuser(rs.getString("prepayuser"));
			p1.setEndtime(rs.getString("endtime"));
			p1.setEnduser(rs.getString("enduser"));
			al.add(p1);
		}
		p.setPageyu(al);
	}
	public static int ui() throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			String sql = "select count(*) n from pomain";
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
	public static void qwe(Pomain p2,ArrayList<Poitem> al) throws SQLException{
		Connection con=null;
		//PreparedStatement st=null;
		Statement st=null;
		ResultSet rs=null;
		boolean i=true;
		int o = 0;
		con = DButil.getConn();
		st = con.createStatement();
		con.setAutoCommit(false);
		//System.out.println(p2.getAccount());
		//System.out.println(p2.getVendercode());
		try {
		String sql="insert into pomain(poid,vendercode,account,createtime,tipfee,producttotal,pototal,paytype,prepayfee,status) values('"+p2.getPoid()+"' , '"+p2.getVendercode()+"', '"+p2.getAccount()+"' , '"+p2.getCreatetime()+"' , "+p2.getTipfee()+" , "+p2.getProducttotal()+" , "+p2.getPototal()+" , '"+p2.getPaytype()+"' , "+p2.getPrepayfee()+" , "+p2.getStatus()+")";
		boolean b = st.execute(sql);
		for(Poitem p:al){
		String sql1="insert into poitem values('"+p.getPoid()+"' , '"+p.getProductcode()+"' , "+p.getUnitprice()+" , "+p.getNum()+", '"+p.getUnitname()+"' , "+p.getItemprice()+")";
		String sql2="update product set ponum="+p.getPonum()+"  where productcode='"+p.getProductcode()+"'";
		 i=st.execute(sql1);
		 o=st.executeUpdate(sql2);
		 //System.out.println(o);
		}
		//System.out.println("b="+b);
		//System.out.println("i="+i);
		//System.out.println("o="+o);
			//System.out.println(sql);
			if (b==true ||i==true||o==0) {
				con.rollback();
				con.setAutoCommit(true);
			} else {
				con.commit();
				con.setAutoCommit(true);
			}
		} finally{
			DButil.close(rs, st, con);
		}
		
		
		
	}
	public static Pomain chuan(String poid) throws SQLException{
		Pomain p=new Pomain();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			con = DButil.getConn();
			String sql = "select * from pomain where poid=?";
			st = con.prepareStatement(sql);
			st.setString(1, poid);
			rs = st.executeQuery();
			if(rs.next()) {
				p.setPoid(poid);
				p.setAccount(rs.getString("account"));
				p.setVendercode(rs.getString("vendercode"));
				p.setCreatetime(rs.getString("createtime"));
				p.setTipfee(rs.getBigDecimal("tipfee"));
				p.setProducttotal(rs.getBigDecimal("producttotal"));
				p.setPototal(rs.getBigDecimal("pototal"));
				p.setPaytype(rs.getString("paytype"));
				p.setPrepayfee(rs.getBigDecimal("prepayfee"));
				p.setStatus(rs.getInt("status"));
				System.out.println(p);
				return p;
			}
			return null;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static ArrayList<Pomain> xunz(String sql) throws SQLException{
		ArrayList<Pomain> al=new ArrayList<Pomain>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while (rs.next()) {
				Pomain p = new Pomain();
				p.setPoid(rs.getString("poid"));
				p.setAccount(rs.getString("account"));
				p.setVendercode(rs.getString("vendercode"));
				p.setCreatetime(rs.getString("createtime"));
				p.setTipfee(rs.getBigDecimal("tipfee"));
				p.setProducttotal(rs.getBigDecimal("producttotal"));
				p.setPototal(rs.getBigDecimal("pototal"));
				p.setPaytype(rs.getString("paytype"));
				p.setPrepayfee(rs.getBigDecimal("prepayfee"));
				p.setStatus(rs.getInt("status"));
				p.setName(rs.getString("name"));
				al.add(p);
			}
			return al;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
	public static Ploi xuanyuan(String poid) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		Ploi p = new Ploi();
		try {
			String sql = "select * from pomain,vender where pomain.vendercode=vender.vendercode and poid=?";
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1,poid);
			rs = st.executeQuery();
			if(rs.next()) {
				p.setPoid(poid);
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
				return p;
			}
			return null;
		}finally{
			DButil.close(rs, st, con);
		}
		
	}
}
