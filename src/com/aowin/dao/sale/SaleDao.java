package com.aowin.dao.sale;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.aowin.model.sale.Somain;
import com.aowin.model.sale.Product;
import com.aowin.model.sale.Soitem;
import com.aowin.util.DButil;

public class SaleDao {
	public List<Somain> getSomain() throws SQLException{
		List<Somain> cl = new ArrayList<Somain>();
		
		String sql="select *from somain";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String soId=rs.getString("SOId");
				String customerCode=rs.getString("CustomerCode");
				String name = rs.getString("Name");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");

				BigDecimal tipFee=rs.getBigDecimal("TipFee");
				BigDecimal productTotal=rs.getBigDecimal("ProductTotal");
				BigDecimal soTotal=rs.getBigDecimal("SOTotal");
				String payType = rs.getString("PayType");
				BigDecimal prePayFee = rs.getBigDecimal("PrePayFee");
				
				int  status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String  stockUser= rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser=rs.getString("EndUser");
				
				
				Somain sm=new Somain();
	
				sm.setAccount(account);
				sm.setCreateTime(createTime);
				sm.setName(name);
				sm.setEndTime(endTime);
				sm.setEndUser(endUser);
				sm.setCustomerCode(customerCode);
				
				sm.setPayTime(payTime);
				sm.setPayType(payType);
				sm.setPayUser(payUser);
				sm.setPrePayFee(prePayFee);
				sm.setPrePayTime(prePayTime);
				
				sm.setPrePayUser(prePayUser);
				sm.setProductTotal(productTotal);
				sm.setRemark(remark);
				sm.setSoId(soId);
				sm.setSoTotal(soTotal);
				
				sm.setStatus(status);
				sm.setStockTime(stockTime);
				sm.setStockUser(stockUser);
				sm.setTipFee(tipFee);


				cl.add(sm);
			}
			return cl;
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
	public List<Somain> getSomain(String yearMonth) throws SQLException{
		List<Somain> cl = new ArrayList<Somain>();
		
		String sql="select *from somain where SOID like'%"+yearMonth+"%'";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String soId=rs.getString("SOId");
				String customerCode=rs.getString("CustomerCode");
				String name = rs.getString("Name");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");

				BigDecimal tipFee=rs.getBigDecimal("TipFee");
				BigDecimal productTotal=rs.getBigDecimal("ProductTotal");
				BigDecimal soTotal=rs.getBigDecimal("SOTotal");
				String payType = rs.getString("PayType");
				BigDecimal prePayFee = rs.getBigDecimal("PrePayFee");
				
				int  status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String  stockUser= rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser=rs.getString("EndUser");
				BigDecimal nonPayment=new BigDecimal(0.00);
				
				Somain sm=new Somain();
	
				sm.setAccount(account);
				sm.setCreateTime(createTime);
				sm.setName(name);
				sm.setEndTime(endTime);
				sm.setEndUser(endUser);
				sm.setCustomerCode(customerCode);
				
				sm.setPayTime(payTime);
				sm.setPayType(payType);
				sm.setPayUser(payUser);
				sm.setPrePayFee(prePayFee);
				sm.setPrePayTime(prePayTime);
				
				sm.setPrePayUser(prePayUser);
				sm.setProductTotal(productTotal);
				sm.setRemark(remark);
				sm.setSoId(soId);
				sm.setSoTotal(soTotal);
				
				sm.setStatus(status);
				sm.setStockTime(stockTime);
				sm.setStockUser(stockUser);
				sm.setTipFee(tipFee);
				sm.setNonPayment(nonPayment);

				cl.add(sm);
			}
			return cl;
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
	
	public List<Somain> getSomain(String payType,int status) throws SQLException{
		List<Somain> cl = new ArrayList<Somain>();
		
		String sql="select *from somain where PayType='"+payType+"' and Status='"+status+"'";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String soId=rs.getString("SOId");
				String customerCode=rs.getString("CustomerCode");
				String name = rs.getString("Name");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");

				BigDecimal tipFee=rs.getBigDecimal("TipFee");
				BigDecimal productTotal=rs.getBigDecimal("ProductTotal");
				BigDecimal soTotal=rs.getBigDecimal("SOTotal");
				String payType2 = rs.getString("PayType");
				BigDecimal prePayFee = rs.getBigDecimal("PrePayFee");
				
				int  status2 = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String  stockUser= rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser=rs.getString("EndUser");
				
				
				Somain sm=new Somain();
	
				sm.setAccount(account);
				sm.setCreateTime(createTime);
				sm.setName(name);
				sm.setEndTime(endTime);
				sm.setEndUser(endUser);
				sm.setCustomerCode(customerCode);
				
				sm.setPayTime(payTime);
				sm.setPayType(payType2);
				sm.setPayUser(payUser);
				sm.setPrePayFee(prePayFee);
				sm.setPrePayTime(prePayTime);
				
				sm.setPrePayUser(prePayUser);
				sm.setProductTotal(productTotal);
				sm.setRemark(remark);
				sm.setSoId(soId);
				sm.setSoTotal(soTotal);
				
				sm.setStatus(status2);
				sm.setStockTime(stockTime);
				sm.setStockUser(stockUser);
				sm.setTipFee(tipFee);


				cl.add(sm);
			}
			return cl;
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
	
	
	
	
	public List<Product> getProduct() throws SQLException{
		List<Product> cl = new ArrayList<Product>();
		
		String sql="select *from product ";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String productCode=rs.getString("ProductCode");
				String productName=rs.getString("Name");
				BigDecimal unitPrice = rs.getBigDecimal("Price");
				String unitName = rs.getString("UnitName");
				String createDate=rs.getString("CreateDate");				
				int num = rs.getInt("soNum");
				
				
				
				Product pd=new Product();
	
				pd.setSoNum(num);
				pd.setProductCode(productCode);
				pd.setProductName(productName);
				pd.setUnitName(unitName);
				pd.setCreateDate(createDate);
				pd.setUnitPrice(unitPrice);
				pd.setSoNum(num);
				cl.add(pd);
			}
			return cl;
			
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	public List<Soitem> getSoitem() throws SQLException{
		List<Soitem> cl = new ArrayList<Soitem>();
		
		String sql="select *from soitem ";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String productCode=rs.getString("ProductCode");
				String productName=rs.getString("Name");
				BigDecimal unitPrice = rs.getBigDecimal("UnitPrice");
				int num = rs.getInt("Num");
				String unitName = rs.getString("UnitName");
				BigDecimal itemPrice=rs.getBigDecimal("ItemPrice");
				
				
				Soitem sm=new Soitem();
				sm.setItemPrice(itemPrice);
				sm.setNum(num);
				sm.setProductCode(productCode);
				sm.setProductName(productName);
				sm.setUnitName(unitName);
				sm.setUnitPrice(unitPrice);

				cl.add(sm);
			}
			return cl;
			
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
	public boolean update(Somain sm,List<Soitem> ls,String soId) throws SQLException{
		int num=0;
		int num0=0;
		Connection conn = null;
		Statement stat=null;	
		ResultSet rs = null;
		boolean flag=false;
		try {
			
			conn= DButil.getConn();		
			conn.setAutoCommit(false);
			stat=conn.createStatement();
				
			SaleDao sd=new SaleDao();		
			List<Soitem> cl=sd.selectSoitem(soId);			
			String deleteSql="delete from somain where SOID='"+soId+"'";
			
			stat.addBatch(deleteSql);
			
			for (int i = 0; i < cl.size(); i++) {
				String 	sonumSql0="select (SONum) from product where ProductCode='"+cl.get(i).getProductCode()+"'";	
				rs=stat.executeQuery(sonumSql0);		
				if(rs.next()){
					num0=rs.getInt("SONum");
				};	
				System.out.println("num0="+num0);
				String beforeSONumSql="update product set SONum='"+(num0-cl.get(i).getNum())+"' where ProductCode='"+cl.get(i).getProductCode()+"'";				
				System.out.println("beforeSONumSql="+beforeSONumSql);
				stat.addBatch(beforeSONumSql);			
			};
			
			String somainSql="insert into somain(SOId,CreateTime,CustomerCode,Account,TipFee,ProductTotal,PayType,Remark,PrePayFee,SOTotal,Name) values('"+sm.getSoId()+"','"+sm.getCreateTime()+"','"+sm.getCustomerCode()+"','"+sm.getAccount()+"','"+sm.getTipFee()+"','"+sm.getProductTotal()+"','"+sm.getPayType()+"','"+sm.getRemark()+"','"+sm.getPrePayFee()+"','"+sm.getSoTotal()+"','"+sm.getName()+"')";
			stat.addBatch(somainSql);		
			for (int i = 0; i < ls.size(); i++) {
				String soitemSql="insert into soitem(SOId,ProductCode,Name,UnitPrice,Num,UnitName,ItemPrice) values('"+sm.getSoId()+"','"+ls.get(i).getProductCode()+"','"+ls.get(i).getProductName()+"','"+ls.get(i).getUnitPrice()+"','"+ls.get(i).getNum()+"','"+ls.get(i).getUnitName()+"','"+ls.get(i).getItemPrice()+"')";
				stat.addBatch(soitemSql);				
			};
			
			
			for (int i = 0; i < ls.size(); i++) {
				String afterSONumSql = null;
				String 	sonumSql="select (SONum) from product where ProductCode='"+ls.get(i).getProductCode()+"'";	
				rs=stat.executeQuery(sonumSql);		
				if(rs.next()){
					num=rs.getInt("SONum");
				};
				System.out.println("num="+num);
				afterSONumSql="update product set SONum='"+(num+ls.get(i).getNum())+"' where ProductCode='"+ls.get(i).getProductCode()+"'";	
				for (int j = 0; j <cl.size(); j++) {
					if(cl.get(j).getProductCode().equals(ls.get(i).getProductCode())){
						afterSONumSql="update product set SONum='"+(num+ls.get(i).getNum()-cl.get(j).getNum())+"' where ProductCode='"+cl.get(j).getProductCode()+"'";						
						System.out.println("haha");
						break;
					};
				};
				System.out.println("afterSONumSql="+afterSONumSql);
				stat.addBatch(afterSONumSql);				
			};
			
			int[] rows=stat.executeBatch();
			flag=true;
			for (int r : rows) {
				if(r==0){
					flag=false;
					return false;				
				}
			}
			return true;
		} finally {
			if(flag){
				conn.commit();
			}else{
				System.out.println("回滚了。。。");
				conn.rollback();
			}
			conn.setAutoCommit(true );
			DButil.close(rs, stat, conn);
		}
	}
	

	
	
	
	public boolean add(Somain sm,List<Soitem> ls) throws SQLException{
		int num=0;
		
		Connection conn = null;
		Statement stat=null;	
		ResultSet rs = null;
		boolean flag=false;
		try {
			
			conn= DButil.getConn();		
			conn.setAutoCommit(false);
			stat=conn.createStatement();		
	
			String somainSql="insert into somain(SOId,CreateTime,CustomerCode,Account,TipFee,ProductTotal,PayType,Remark,PrePayFee,SOTotal,Name) values('"+sm.getSoId()+"','"+sm.getCreateTime()+"','"+sm.getCustomerCode()+"','"+sm.getAccount()+"','"+sm.getTipFee()+"','"+sm.getProductTotal()+"','"+sm.getPayType()+"','"+sm.getRemark()+"','"+sm.getPrePayFee()+"','"+sm.getSoTotal()+"','"+sm.getName()+"')";
			int r1=stat.executeUpdate(somainSql);		
			for (int i = 0; i < ls.size(); i++) {
				String soitemSql="insert into soitem(SOId,ProductCode,Name,UnitPrice,Num,UnitName,ItemPrice) values('"+sm.getSoId()+"','"+ls.get(i).getProductCode()+"','"+ls.get(i).getProductName()+"','"+ls.get(i).getUnitPrice()+"','"+ls.get(i).getNum()+"','"+ls.get(i).getUnitName()+"','"+ls.get(i).getItemPrice()+"')";
				stat.addBatch(soitemSql);				
			};
			for (int i = 0; i < ls.size(); i++) {
				String 	sonumSql="select (SONum) from product where ProductCode='"+ls.get(i).getProductCode()+"'";	
				rs=stat.executeQuery(sonumSql);		
				if(rs.next()){
					num=rs.getInt("SONum");
				};
				String afterSONumSql="update product set SONum='"+(num+ls.get(i).getNum())+"' where ProductCode='"+ls.get(i).getProductCode()+"'";
				stat.addBatch(afterSONumSql);
			};
			
			int[] rows=stat.executeBatch();
			flag=true;
			for (int r : rows) {
				if(r==0||r1==0){
					flag=false;
					return false;				
				}
			}
			return true;
		} finally {
			if(flag){
				conn.commit();
			}else{
				System.out.println("回滚了。。。");
				conn.rollback();
			}
			conn.setAutoCommit(true );
			DButil.close(rs, stat, conn);
		}
	}
	
	
	
	public boolean updateSomainStatus(String soId,int status) throws SQLException {
		String sql="update somain set Status='"+status+"' where SOID='"+soId+"'";
		
		Connection conn = null;
		Statement stat =null;
		try {
			conn = DButil.getConn();
			stat=conn.createStatement();
			int n=stat.executeUpdate(sql);		
			return n==1?true:false;

		} finally {
			DButil.close(null, stat, conn);
		}
	}
	
	
	
	public boolean updateSoitem(Soitem sm,String ProductCode) throws SQLException {
		String sql="update somain set ProductCode=?,UnitPrice=?,Num=?,UnirName=? where ProductCode=?";
		
		Connection conn = null;
		PreparedStatement ps =null;
		try {
			conn = DButil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, sm.getProductCode());
			ps.setBigDecimal(2, sm.getUnitPrice());
			ps.setInt(3, sm.getNum());
			ps.setString(4, sm.getUnitName());
			ps.setString(5, ProductCode);
			int n = ps.executeUpdate();
			return n==1?true:false;

		} finally {
			DButil.close(null, ps, conn);
		}
	}
	
	
	public boolean deleteSomain(String soId) throws SQLException{
		
		int num=0;
		Connection conn = null;
		Statement stat=null;	
		ResultSet rs = null;
		boolean flag=false;
		try {
			
			conn= DButil.getConn();		
			conn.setAutoCommit(false);
			stat=conn.createStatement();		
			
			String deleteSql="delete from somain where SOID='"+soId+"'";
			
			stat.addBatch(deleteSql);
			SaleDao sd=new SaleDao();		
			List<Soitem> cl=sd.selectSoitem(soId);
			
			for (int i = 0; i < cl.size(); i++) {
				String 	sonumSql="select (SONum) from product where ProductCode='"+cl.get(i).getProductCode()+"'";	
				rs=stat.executeQuery(sonumSql);		
				if(rs.next()){
					num=rs.getInt("SONum");
				};
				String afterSONumSql="update product set SONum='"+(num-cl.get(i).getNum())+"' where ProductCode='"+cl.get(i).getProductCode()+"'";
				stat.addBatch(afterSONumSql);				
			};
			
	
			int[] rows=stat.executeBatch();
			flag=true;
			for (int r : rows) {
				if(r==0){
					flag=false;
					return false;				
				}
			}
			return true;
		} finally {
			if(flag){
				conn.commit();
			}else{
				System.out.println("回滚了。。。");
				conn.rollback();
			}
			conn.setAutoCommit(true );
			DButil.close(rs, stat, conn);
		}
		
	}
	
	public void deleteSoitem(String soId) throws SQLException{
		
		String sql="delete from soitem where SOID=?";
		
		Connection conn = null;
		PreparedStatement ps =null;
		
		
		try {
			conn = DButil.getConn();
			ps = conn.prepareStatement(sql);
			ps.setString(1, soId);		
			ps.executeUpdate();
		} finally {
			DButil.close(null,ps,conn);
		}
	}
	
	
	
	
	public Somain selectSomain(String soId) throws SQLException{
		
		
		String sql="select *from somain where SOID='"+soId+"'";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Somain sm=new Somain();
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				String customerCode = rs.getString("CustomerCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");

				BigDecimal tipFee=rs.getBigDecimal("TipFee");
				BigDecimal productTotal=rs.getBigDecimal("ProductTotal");
				BigDecimal soTotal=rs.getBigDecimal("SOTotal");
				String payType = rs.getString("PayType");
				BigDecimal prePayFee = rs.getBigDecimal("PrePayFee");
				
				int  status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String  stockUser= rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser=rs.getString("EndUser");
				String name=rs.getString("Name");
				
				
				sm.setSoId(soId);
				sm.setAccount(account);
				sm.setCreateTime(createTime);
				sm.setCustomerCode(customerCode);
				sm.setEndTime(endTime);
				sm.setEndUser(endUser);
				
				sm.setPayTime(payTime);
				sm.setPayType(payType);
				sm.setPayUser(payUser);
				sm.setPrePayFee(prePayFee);
				sm.setPrePayTime(prePayTime);
				
				sm.setPrePayUser(prePayUser);
				sm.setProductTotal(productTotal);
				sm.setRemark(remark);
				sm.setSoId(soId);
				sm.setSoTotal(soTotal);
				
				sm.setStatus(status);
				sm.setStockTime(stockTime);
				sm.setStockUser(stockUser);
				sm.setTipFee(tipFee);
				sm.setName(name);
				
				System.out.println(sm);
			}
			return sm;
		
			
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
public List<Somain> selectCustomerOfSomain(String name) throws SQLException{
		
		List<Somain> cl = new ArrayList<Somain>();
		String sql="select *from somain where Name='"+name+"'";
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		Somain sm=new Somain();
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			if (rs.next()) {
				
				String customerCode = rs.getString("CustomerCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				String soId=rs.getString("SOID");
				BigDecimal tipFee=rs.getBigDecimal("TipFee");
				BigDecimal productTotal=rs.getBigDecimal("ProductTotal");
				BigDecimal soTotal=rs.getBigDecimal("SOTotal");
				String payType = rs.getString("PayType");
				BigDecimal prePayFee = rs.getBigDecimal("PrePayFee");
				
				int  status = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String  stockUser= rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser=rs.getString("EndUser");
				String name2=rs.getString("Name");
				
				sm.setSoId(soId);
				sm.setAccount(account);
				sm.setCreateTime(createTime);
				sm.setCustomerCode(customerCode);
				sm.setEndTime(endTime);
				sm.setEndUser(endUser);
				
				sm.setPayTime(payTime);
				sm.setPayType(payType);
				sm.setPayUser(payUser);
				sm.setPrePayFee(prePayFee);
				sm.setPrePayTime(prePayTime);
				
				sm.setPrePayUser(prePayUser);
				sm.setProductTotal(productTotal);
				sm.setRemark(remark);
				sm.setSoId(soId);
				sm.setSoTotal(soTotal);
				
				sm.setStatus(status);
				sm.setStockTime(stockTime);
				sm.setStockUser(stockUser);
				sm.setTipFee(tipFee);
				sm.setName(name2);
				cl.add(sm);
				
			}
			return cl;	
			
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
		
	public List<Soitem> selectSoitem(String soId) throws SQLException{
		List<Soitem> cl = new ArrayList<Soitem>();
		
		String sql="select *from soitem where SOID='"+soId+"'";		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				String productCode=rs.getString("ProductCode");
				BigDecimal unitPrice = rs.getBigDecimal("UnitPrice");
				int num = rs.getInt("Num");
				String unitName = rs.getString("UnitName");
				BigDecimal itemPrice=rs.getBigDecimal("ItemPrice");
				String productName=rs.getString("Name");
				
				Soitem st=new Soitem();
				st.setItemPrice(itemPrice);
				st.setNum(num);
				st.setProductCode(productCode);
				st.setUnitName(unitName);
				st.setUnitPrice(unitPrice);
				st.setSoId(soId);
				st.setProductName(productName);
				cl.add(st);
			}
			return cl;
			
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
	
public List<Somain> allSelectSomain(String sql) throws SQLException{
		
		
	List<Somain> cl=new ArrayList<Somain>();
		
		Connection conn = null;
		Statement stat = null;
		ResultSet rs = null;
		
		try {
			conn = DButil.getConn();
			stat = conn.createStatement();
			rs = stat.executeQuery(sql);
			
			while (rs.next()) {
				
				String customerCode0 = rs.getString("CustomerCode");
				String account = rs.getString("Account");
				String createTime = rs.getString("CreateTime");
				String soId = rs.getString("SOID");
				BigDecimal tipFee=rs.getBigDecimal("TipFee");
				BigDecimal productTotal=rs.getBigDecimal("ProductTotal");
				BigDecimal soTotal=rs.getBigDecimal("SOTotal");
				String payType = rs.getString("PayType");
				BigDecimal prePayFee = rs.getBigDecimal("PrePayFee");
				
				int  status0 = rs.getInt("Status");
				String remark = rs.getString("Remark");
				String stockTime = rs.getString("StockTime");
				String  stockUser= rs.getString("StockUser");
				String payTime = rs.getString("PayTime");
				
				String payUser = rs.getString("PayUser");
				String prePayTime = rs.getString("PrePayTime");
				String prePayUser = rs.getString("PrePayUser");
				String endTime = rs.getString("EndTime");
				String endUser=rs.getString("EndUser");
				String name=rs.getString("Name");
				
				Somain sm=new Somain();
				sm.setSoId(soId);
				sm.setAccount(account);
				sm.setCreateTime(createTime);
				sm.setCustomerCode(customerCode0);
				sm.setEndTime(endTime);
				sm.setEndUser(endUser);
				
				sm.setPayTime(payTime);
				sm.setPayType(payType);
				sm.setPayUser(payUser);
				sm.setPrePayFee(prePayFee);
				sm.setPrePayTime(prePayTime);
				
				sm.setPrePayUser(prePayUser);
				sm.setProductTotal(productTotal);
				sm.setRemark(remark);
				sm.setSoId(soId);
				sm.setSoTotal(soTotal);
				
				sm.setStatus(status0);
				sm.setStockTime(stockTime);
				sm.setStockUser(stockUser);
				sm.setTipFee(tipFee);
				sm.setName(name);
				
				cl.add(sm);
			}
			return cl;
			
		} finally {
			DButil.close(rs,stat,conn);
		}
	}
		
	
	
	
	
}
