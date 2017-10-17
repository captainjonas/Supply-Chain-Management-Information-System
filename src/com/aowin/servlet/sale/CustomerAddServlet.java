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

public class CustomerAddServlet extends HttpServlet{

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
		String password=req.getParameter("password");
		String contactor=req.getParameter("contactor");
		String address=req.getParameter("address");
		String postcode=req.getParameter("postcode");
		String tel=req.getParameter("tel");
		String fax=req.getParameter("fax");
		String createDate=req.getParameter("createDate");
		
		Customer ct=new Customer();
		ct.setAddress(address);
		ct.setContactor(contactor);
		ct.setCreateDate(createDate);
		ct.setCustomerCode(customerCode);
		ct.setFax(fax);
		ct.setName(name);
		ct.setPassword(password);
		ct.setPostcode(postcode);
		ct.setTel(tel);
		
		
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
			boolean flag;
			CustomerDao cd=new CustomerDao();
			List<Customer> lc=cd.select(customerCode);
			if(lc.size()==0){
				flag=cd.add(ct);			
				if(flag){				
					List<Customer> cl=cd.getAllCustomer();
					req.setAttribute("cl", cl);						
					int count = cd.queryCount();
					p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
					cd.queryShopByPage(p);			
					req.setAttribute("page", p);
					req.setAttribute("warning", "addSuccess");
					req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
				}else{
					req.setAttribute("warning", "addFail");
					List<Customer> cl=cd.getAllCustomer();
					req.setAttribute("cl", cl);	
					int count = cd.queryCount();
					p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
					cd.queryShopByPage(p);			
					req.setAttribute("page", p);
					req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
				}
			}else{
				req.setAttribute("warning", "customerExit");
				int count = cd.queryCount();
				p.setTotalPage(count%p.getPageSize()==0?count/p.getPageSize():count/p.getPageSize()+1);		
				cd.queryShopByPage(p);			
				req.setAttribute("page", p);
				req.getRequestDispatcher("/sale/customerPage.jsp").forward(req, resp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
