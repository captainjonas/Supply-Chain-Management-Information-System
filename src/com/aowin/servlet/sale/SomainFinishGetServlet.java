package com.aowin.servlet.sale;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.Userdao;
import com.aowin.dao.sale.SaleDao;
import com.aowin.model.User;
import com.aowin.model.sale.Somain;


public class SomainFinishGetServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		boolean flag=false;
		if(req.getSession().getAttribute("user")==null){
			resp.sendRedirect(req.getContextPath()+"/login.jsp");
		}else{
			User u=(User) req.getSession().getAttribute("user");
			ArrayList<String> alp;
			try {
				System.out.println("servlet"+u.getAccount());
				alp = Userdao.find(u.getAccount());
			for(String sq:alp){
				System.out.println(sq);
				if(sq.equals("管理员")||sq.equals("销售")){
					flag=true;	
				}
			}
			if(flag){
				try {
					SaleDao sd=new SaleDao();
					List<Somain> cl1=sd.getSomain("货到付款", 3);
					req.setAttribute("cl1", cl1);
					
					List<Somain> cl2=sd.getSomain("款到发货", 2);
					req.setAttribute("cl2", cl2);
					
					List<Somain> cl3=sd.getSomain("预付款到发货", 3);
					req.setAttribute("cl3", cl3);
					
					
					req.getRequestDispatcher("/sale/saleFinish.jsp").forward(req, resp);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
							
			}else{
				resp.sendRedirect(req.getContextPath()+"/promt.jsp");
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			
     	
		
	}

		
	
}