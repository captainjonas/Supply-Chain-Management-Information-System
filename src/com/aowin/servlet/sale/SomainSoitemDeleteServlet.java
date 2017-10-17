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
import com.aowin.model.sale.Soitem;

public class SomainSoitemDeleteServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String soId=req.getParameter("soId");
		
	
		try {
			SaleDao sd=new SaleDao();
			boolean flag=sd.deleteSomain(soId);
			if(flag){
				req.setAttribute("warning", "deleteSuccess");
				List<Somain> cl=sd.getSomain();
				req.setAttribute("cl", cl);
				req.getRequestDispatcher("/sale/sale.jsp").forward(req, resp);
			}
			else{
				req.setAttribute("warning", "deleteFail");
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