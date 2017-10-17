package com.aowin.servlet.sale;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.aowin.dao.sale.SaleDao;
import com.aowin.model.sale.Somain;
import com.aowin.model.sale.Soitem;


public class SomainSoitemSaveServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String soId=req.getParameter("soId");
		String createTime=req.getParameter("createTime");
		String customerCode=req.getParameter("customerCode");
		String name=req.getParameter("name");
		String account=req.getParameter("account");
		String tipFee0=(req.getParameter("tipFee"));
		String productTotal0=req.getParameter("productTotal");
		String payType=req.getParameter("payType");
		String prePayFee0=req.getParameter("prePayFee");
		String remark=req.getParameter("remark");
		String soTotal0=req.getParameter("soTotal");
		
		
		BigDecimal tipFee=(new BigDecimal(Float.parseFloat(tipFee0)));
		BigDecimal productTotal=(new BigDecimal(Float.parseFloat(productTotal0)));
		BigDecimal prePayFee=(new BigDecimal(Float.parseFloat(prePayFee0)));
		BigDecimal soTotal=(new BigDecimal(Float.parseFloat(soTotal0)));
		
		Somain sm=new Somain();
		
		sm.setSoId(soId);
		sm.setCreateTime(createTime);
		sm.setCustomerCode(customerCode);
		sm.setName(name);
		sm.setAccount(account);
		sm.setTipFee(tipFee);
		sm.setProductTotal(productTotal);
		sm.setPayType(payType);
		sm.setPrePayFee(prePayFee);
		sm.setRemark(remark);
		sm.setSoTotal(soTotal);
		
		
		String k=req.getParameter("k");
		System.out.println(k);
		String[] kk=k.split(",");
		List<Soitem> ls=new ArrayList<Soitem>();
		for (int i = 0; i < kk.length;i+=6) {
			Soitem st=new Soitem();
			st.setSoId(soId);
			st.setProductCode(kk[i]);
			st.setProductName(kk[i+1]);
			st.setNum(Integer.parseInt(kk[i+2]));
			st.setUnitName(kk[i+3]);
			st.setUnitPrice(new BigDecimal(Float.parseFloat(kk[i+4])));
			st.setItemPrice(new BigDecimal(Float.parseFloat(kk[i+5])));
			
			ls.add(st);
		};
		
		try {
			SaleDao sd=new SaleDao();
			boolean flag=sd.add(sm, ls);
			if(flag){
				req.setAttribute("warning", "success");
				List<Somain> cl=sd.getSomain();
				req.setAttribute("cl", cl);
				req.getRequestDispatcher("/sale/sale.jsp").forward(req, resp);
			}
			else{
				req.setAttribute("warning", "fail");
				List<Somain> cl=sd.getSomain();
				req.setAttribute("cl", cl);
				req.getRequestDispatcher("/sale/sale.jsp").forward(req, resp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}
	
}