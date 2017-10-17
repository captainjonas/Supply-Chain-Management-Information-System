package com.aowin.dao.sale;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aowin.model.sale.Customer;
import com.aowin.model.sale.Page;
import com.aowin.util.DButil;


public class CustomerDao {
	
	public List<Customer> getAllCustomer() throws SQLException{
		List<Customer> cl = new ArrayList<Customer>();
		
		String sql="select *from customer";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String customerCode = rs.getString("CustomerCode");
				String name = rs.getString("Name");
				String password = rs.getString("Password");
				String contactor = rs.getString("Contactor");
				String address = rs.getString("Address");
				String postcode = rs.getString("Postcode");
				String tel = rs.getString("Tel");
				String fax = rs.getString("Fax");
				String createDate = rs.getString("CreateDate");

				
				Customer customer = new Customer();
				customer.setCustomerCode(customerCode);
				customer.setName(name);
				customer.setPassword(password);
				customer.setContactor(contactor);
				customer.setAddress(address);
				customer.setPostcode(postcode);
				customer.setTel(tel);
				customer.setFax(fax);
				customer.setCreateDate(createDate);				
				cl.add(customer);
			}
			return cl;
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
	public boolean add(Customer customer) throws SQLException{

		String sql="insert into customer(CustomerCode,Name,Password,Contactor,Address,Postcode,Tel,Fax,CreateDate) values(?,?,?,?,?,?,?,?,?)";
		
		Connection conn = null;
		PreparedStatement ps =null;
		
		try {
			conn = DButil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getCustomerCode());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getContactor());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getPostcode());
			ps.setString(7, customer.getTel());
			ps.setString(8, customer.getFax());
			ps.setString(9, customer.getCreateDate());
			int n = ps.executeUpdate();
			return n==1?true:false;			
		} finally {
			DButil.close(null, ps, conn);
		}
	}
	
	
	public List<Customer> select(String customerCode) throws SQLException{
		
		List<Customer> cl = new ArrayList<Customer>();
		String sql="select * from customer where CustomerCode=?";
		
		Connection conn = null;
		PreparedStatement ps =null;	
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			
			ps = conn.prepareStatement(sql);
			ps.setString(1, customerCode);	
			rs = ps.executeQuery();
			
			while (rs.next()) {
				String name = rs.getString("Name");
				String password = rs.getString("Password");
				String contactor = rs.getString("Contactor");
				String address = rs.getString("Address");
				String postcode = rs.getString("Postcode");
				String tel = rs.getString("Tel");
				String fax = rs.getString("Fax");
				String createDate = rs.getString("CreateDate");			
				
				Customer customer = new Customer();
				customer.setCustomerCode(customerCode);
				customer.setName(name);
				customer.setPassword(password);
				customer.setContactor(contactor);
				customer.setAddress(address);
				customer.setPostcode(postcode);
				customer.setTel(tel);
				customer.setFax(fax);
				customer.setCreateDate(createDate);	
				
				cl.add(customer);
				}
				return cl;
			
		} finally {
			DButil.close(rs,ps,conn);
		}
	}
	
	public boolean updateCustomer(Customer customer,String customerCode) throws SQLException {
		String sql="update customer set CustomerCode=?,Name=?,Password=?,Contactor=?,Address=?,Postcode=?,Tel=?,Fax=?,CreateDate=? where CustomerCode=?";
		
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, customer.getCustomerCode());
			ps.setString(2, customer.getName());
			ps.setString(3, customer.getPassword());
			ps.setString(4, customer.getContactor());
			ps.setString(5, customer.getAddress());
			ps.setString(6, customer.getPostcode());
			ps.setString(7, customer.getTel());
			ps.setString(8, customer.getFax());
			ps.setString(9, customer.getCreateDate());
			ps.setString(10, customerCode);
			int n = ps.executeUpdate();
			return n==1?true:false;
			
			
		} finally {
			DButil.close(null, ps, conn);
		}
	}
	
	
	public boolean delete(String customerCode) throws SQLException{
		
		String sql="delete from customer where CustomerCode=?";
		
		Connection conn = null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, customerCode);		
			int n=ps.executeUpdate();
			return n==1?true:false;
		} finally {
			DButil.close(rs,ps,conn);
		}
	}

	public List<Customer> AllSelect(String sql) throws SQLException{
	
		List<Customer> cl = new ArrayList<Customer>();
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
	
	try {
		conn = DButil.getConn();	
		stat = conn.createStatement();
		rs = stat.executeQuery(sql);
		
		while (rs.next()) {
			String customerCode0=rs.getString("CustomerCode");
			String name0 = rs.getString("Name");
			String password = rs.getString("Password");
			String contactor = rs.getString("Contactor");
			String address = rs.getString("Address");
			String postcode = rs.getString("Postcode");
			String tel = rs.getString("Tel");
			String fax = rs.getString("Fax");
			String createDate = rs.getString("CreateDate");			
			
			Customer customer = new Customer();
			customer.setCustomerCode(customerCode0);
			customer.setName(name0);
			customer.setPassword(password);
			customer.setContactor(contactor);
			customer.setAddress(address);
			customer.setPostcode(postcode);
			customer.setTel(tel);
			customer.setFax(fax);
			customer.setCreateDate(createDate);	
			
			cl.add(customer);
			}
			return cl;
		
	} finally {
		DButil.close(rs,stat,conn);
	}
}

	
	
	public int queryCount() throws SQLException{
		String sql = "select count(*) n  from customer";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs=null;
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs=stat.executeQuery(sql);
			if (rs.next()) {
				int n = rs.getInt("n");
				System.out.println(n);
				return n;
			}
			System.out.println("haha");
			return 0;
		} finally {
			DButil.close(rs, stat, conn);
		}
	}
	
	public void queryShopByPage(Page p) throws SQLException{
		String sql = "select * from customer limit ?,?";
		List<Customer> cl = new ArrayList<Customer>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (p.getCurrentPage() - 1) * p.getPageSize());
			ps.setInt(2, p.getPageSize());
			rs = ps.executeQuery();
			while (rs.next()) {
				
				String customerCode = rs.getString("CustomerCode");
				String name = rs.getString("Name");
				String password = rs.getString("Password");
				String contactor = rs.getString("Contactor");
				String address = rs.getString("Address");
				String postcode = rs.getString("Postcode");
				String tel = rs.getString("Tel");
				String fax = rs.getString("Fax");
				String createDate = rs.getString("CreateDate");

				
				Customer customer = new Customer();
				customer.setCustomerCode(customerCode);
				customer.setName(name);
				customer.setPassword(password);
				customer.setContactor(contactor);
				customer.setAddress(address);
				customer.setPostcode(postcode);
				customer.setTel(tel);
				customer.setFax(fax);
				customer.setCreateDate(createDate);				
				cl.add(customer);
			}
			p.setData(cl);
		} finally {
			DButil.close(rs, ps, conn);
		}
	}

}
