package com.aowin.servlet.sale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.sale.CustomerDao;
import com.aowin.dao.sale.SaleDao;
import com.aowin.model.sale.Customer;
import com.aowin.model.sale.Product;

public class SomainAddServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");	
		try {
			CustomerDao ct=new CustomerDao();
			List<Customer> cl=ct.getAllCustomer();
			req.setAttribute("cl", cl);
			
			SaleDao sd=new SaleDao();			
			List<Product> cll=sd.getProduct();
			req.setAttribute("cll", cll);
			req.getRequestDispatcher("/sale/saleAdd.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}