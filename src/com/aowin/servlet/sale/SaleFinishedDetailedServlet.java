package com.aowin.servlet.sale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.sale.SaleDao;
import com.aowin.model.sale.Product;
import com.aowin.model.sale.Soitem;
import com.aowin.model.sale.Somain;

public class SaleFinishedDetailedServlet extends HttpServlet{

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
			Somain sm=sd.selectSomain(soId);
			req.setAttribute("sm", sm);
			List<Soitem> cll=sd.selectSoitem(soId);		
			req.setAttribute("cll", cll);
			req.getRequestDispatcher("/sale/saleFinishedDetailed.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}