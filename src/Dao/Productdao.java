package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.aowin.util.DButil;

import Model.Product;

public class Productdao {
	public static ArrayList<Product>  adn() throws SQLException{
		ArrayList<Product> al=new ArrayList<Product>();
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select * from product";
		con=DButil.getConn();
		st=con.prepareStatement(sql);
		rs=st.executeQuery();
		while(rs.next()){
			Product p=new Product();
			p.setProductcode(rs.getString("productcode"));
			p.setCategoryid(rs.getInt("categoryid"));
			p.setName(rs.getString("name"));
			p.setUnitname(rs.getString("unitname"));
			p.setPrice(rs.getBigDecimal("price"));
			p.setCreatedate(rs.getString("createdate"));
			p.setRemark(rs.getString("remark"));
			p.setPonum(rs.getInt("ponum"));
			p.setSonum(rs.getInt("sonum"));
			al.add(p);
		}
		return al;
		
	}
	public static int num(String productcode) throws SQLException{
		Connection con=null;
		PreparedStatement st=null;
		ResultSet rs=null;
		String sql="select ponum from product where productcode=?";
		try {
			con = DButil.getConn();
			st = con.prepareStatement(sql);
			st.setString(1, productcode);
			rs = st.executeQuery();
			if (rs.next()) {
				int u = rs.getInt("ponum");
				return u;
			}
			return 0;
		}finally{
			DButil.close(rs, st, con);
		}
	}
}
