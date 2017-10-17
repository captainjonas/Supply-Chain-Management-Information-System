package com.aowin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.Userdao;
import com.aowin.model.User;

public class InRegister extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public InRegister() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		boolean flag=false;
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");
		}else{
			User u=(User) request.getSession().getAttribute("user");
			ArrayList<String> alp;
			try {
				System.out.println("servlet"+u.getAccount());
				alp = Userdao.find(u.getAccount());
			for(String sq:alp){
				System.out.println(sq);
				if(sq.equals("管理员")||sq.equals("仓库")){
					flag=true;	
				}
			}
			System.out.println("flag="+flag);
			if(flag){
				request.getRequestDispatcher("gztm/instock.jsp").forward(request,response);
			}else{
				response.sendRedirect(request.getContextPath()+"/promt.jsp");
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}

}
