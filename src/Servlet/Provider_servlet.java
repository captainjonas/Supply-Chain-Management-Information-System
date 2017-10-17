package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Dao.Verdendao;
import Model.Vender;

public class Provider_servlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doPost(request, response);
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String q=request.getParameter("q");
			String w=request.getParameter("w");
			String e=request.getParameter("e");
			String r=request.getParameter("r");
			String t=request.getParameter("t");
			String y=request.getParameter("y");
			String u=request.getParameter("u");
			String i=request.getParameter("i");
			String o=request.getParameter("o");
			String h1=request.getParameter("hi");
			Vender c=new Vender();
			c.setCustomercode(q);
			c.setName(w);
			c.setPassword(e);
			c.setContactor(r);
			c.setAddress(t);
			c.setPostcode(y);
			c.setCreatedate(u);
			c.setTel(i);
			c.setFax(o);
			if("新增".equals(h1)){
				try {
					boolean b=Verdendao.add(c);
					//System.out.println(b);
					if(!b){
						request.getSession().setAttribute("boo","true");
						response.sendRedirect(request.getContextPath()+"/servlet/Cur");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					request.getSession().setAttribute("bur","true");
					response.sendRedirect(request.getContextPath()+"/servlet/Cur");
				}
			}
			else{
				try {
					Verdendao.chuang(c);
					request.getSession().setAttribute("bw","true");
					response.sendRedirect(request.getContextPath()+"/servlet/Cur");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					request.getSession().setAttribute("qwer","true");
					response.sendRedirect(request.getContextPath()+"/servlet/Cur");
				}
				
			}
			
		
	}

}
