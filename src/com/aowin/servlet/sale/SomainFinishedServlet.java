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


public class SomainFinishedServlet extends HttpServlet{

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
			boolean flag=sd.updateSomainStatus(soId, 4);
			if(flag){
				req.setAttribute("warning", "finishedSuccess");
				List<Somain> cl1=sd.getSomain("货到付款", 3);
				req.setAttribute("cl1", cl1);			
				List<Somain> cl2=sd.getSomain("款到发货", 2);
				req.setAttribute("cl2", cl2);		
				List<Somain> cl3=sd.getSomain("预付款到发货", 3);
				req.setAttribute("cl3", cl3);			
				req.getRequestDispatcher("/sale/saleFinish.jsp").forward(req, resp);
			}
			else{
				req.setAttribute("warning", "finishedFail");
				List<Somain> cl1=sd.getSomain("货到付款", 3);
				req.setAttribute("cl1", cl1);			
				List<Somain> cl2=sd.getSomain("款到发货", 2);
				req.setAttribute("cl2", cl2);		
				List<Somain> cl3=sd.getSomain("预付款到发货", 3);
				req.setAttribute("cl3", cl3);			
				req.getRequestDispatcher("/sale/saleFinish.jsp").forward(req, resp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	
}
