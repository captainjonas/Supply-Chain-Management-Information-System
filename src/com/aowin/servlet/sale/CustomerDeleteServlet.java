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
import com.aowin.model.sale.Page;
import com.aowin.model.sale.Somain;

public class CustomerDeleteServlet extends HttpServlet{
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
			SaleDao sd=new SaleDao();
			CustomerDao ctd=new CustomerDao();
			List<Somain> ls=sd.selectCustomerOfSomain(name);
			System.out.println(name);
			System.out.println(ls);
			if(ls.size()==0){			
				boolean flag=ctd.delete(customerCode);
				if(flag){
					req.setAttribute("warning", "删除成功!");
					
					List<Customer> cl=ctd.getAllCustomer();
					req.setAttribute("cl", cl);	
					int count = ctd.queryCount();
					p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
					ctd.queryShopByPage(p);			
					req.setAttribute("page", p);			
					req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
				}else{
					req.setAttribute("warning", "删除失败!");
					List<Customer> cl=ctd.getAllCustomer();
					req.setAttribute("cl", cl);	
					int count = ctd.queryCount();
					p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
					ctd.queryShopByPage(p);			
					req.setAttribute("page", p);			
					req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
				}
			}else{	
				req.setAttribute("warning", "该客户有未完结的销售单，请先了结完销售单！");
				List<Customer> cl=ctd.getAllCustomer();
				req.setAttribute("cl", cl);	
				int count = ctd.queryCount();
				p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
				ctd.queryShopByPage(p);			
				req.setAttribute("page", p);			
				req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
