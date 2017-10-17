package com.aowin.servlet.sale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.sale.CustomerDao;
import com.aowin.model.sale.Customer;

public class CustomerSelectServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		
		String customerCode=req.getParameter("customerCode");
		String name=req.getParameter("name");
		
		
		StringBuffer sb=new StringBuffer("select * from customer where 1=1 ");
		if(true){
			if(customerCode!=""){
				sb.append("and CustomerCode like '%"+customerCode+"%'");
			};
			if(name!=""){
				sb.append(" and Name like '%"+name+"%'");
			};		
		};	
		String sql=sb.toString();
			
		if(name!=""||customerCode!=""){
			try {
				CustomerDao ctd=new CustomerDao();			
				List<Customer> cl=ctd.AllSelect(sql);
				req.setAttribute("cl", cl);
				req.getRequestDispatcher("/sale/customerSelect.jsp").forward(req, resp);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			req.getRequestDispatcher("/sale/customerSelect.jsp").forward(req, resp);	
		}
		
	}
}
