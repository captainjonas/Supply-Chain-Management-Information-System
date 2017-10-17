package com.aowin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.Userdao;
import com.aowin.model.User;
import com.aowin.util.CreateLog;

public class Servlet_login extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Servlet_login() {
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

		doPost(request, response);
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

		String name=request.getParameter("username");
		String password=request.getParameter("password");
		System.out.println(name);
		System.out.print(password);
		try {
			User u=Userdao.getUser(name, password);
			System.out.println(u);
			request.getSession().setAttribute("user",u);
			if(u!=null&&!u.getStatus().equals("锁定")){
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
			else if(u!=null&&u.getStatus().equals("锁定")){
				System.out.println(u.getStatus());
				request.setAttribute("er","账号已经被锁定，请找管理员处理");
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
			else{
				request.setAttribute("ew","账号密码错误");
				request.getRequestDispatcher("/success.jsp").forward(request, response);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			CreateLog.log(Servlet_login.class);
		}
		
	
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
