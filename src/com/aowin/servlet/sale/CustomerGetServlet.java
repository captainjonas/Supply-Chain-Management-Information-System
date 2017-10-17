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
import com.aowin.model.sale.Page;

public class CustomerGetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String page = req.getParameter("page");
		int currentPage;
		if(page==null || "".equals(page)){
			currentPage=1;
		}else{
			currentPage = Integer.parseInt(page);
		}
		Page p = new Page();
		p.setCurrentPage(currentPage);
		p.setPageSize(5);
		
		try {
			CustomerDao ctd=new CustomerDao();
			List<Customer> cl=ctd.getAllCustomer();
			req.setAttribute("cl", cl);
			
			int count = ctd.queryCount();
			p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
			ctd.queryShopByPage(p);			
			req.setAttribute("page", p);			
			req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}