package com.aowin.servlet.sale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.aowin.dao.sale.SaleDao;
import com.aowin.model.sale.Somain;

public class SomainSelectServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		

		String soId=req.getParameter("soId");
		String startDate=req.getParameter("startDate");
		String endDate=req.getParameter("endDate");
		String customerName=req.getParameter("customerName");
		String status=req.getParameter("status");
		String payType=req.getParameter("payType");
		
		
		int status0 = 0;
		if(status!=""){
			status0=Integer.parseInt(status);
		};
		StringBuffer sb=new StringBuffer("select *from somain where 1=1 ");
		if(true){
			if(soId!=""){
				sb.append("and SOID like '%"+soId+"%'");
			};
			if(startDate!=""){
				sb.append(" and CreateTime>'"+startDate+"'");
			};	
			if(endDate!=""){
				sb.append(" and CreateTime<'"+endDate+"'");
			};	
			if(customerName!=""){
				sb.append(" and Name like '%"+customerName+"%'");
			};	
			if(status!=""){
				sb.append(" and Status like '%"+status0+"%'");
			};	
			if(payType!=""){
				sb.append(" and PayType= '"+payType+"'");
			};	
		};	
		String sql=sb.toString();
		if(soId!=""||startDate!=""||endDate!=""||customerName!=""||status!=""||payType!=""){
			try {			
				SaleDao sd=new SaleDao();
				List<Somain> cl=sd.allSelectSomain(sql);
				req.setAttribute("cl", cl);
				req.getRequestDispatcher("/sale/saleSelect.jsp").forward(req, resp);
			} catch (SQLException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else{
			req.getRequestDispatcher("/sale/saleSelect.jsp").forward(req, resp);
		}
	}	
}
