package com.aowin.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.Userdao;
import com.aowin.model.User;

public class Ruku extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public Ruku() {
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
		boolean flag=true;
		if(request.getSession().getAttribute("user")==null){
			flag=false;
			response.sendRedirect(request.getContextPath()+"/login.jsp");return;
		}else{
			User u=(User) request.getSession().getAttribute("user");
			System.out.println(u.getAccount());
			ArrayList<String> alp;
			try {
				alp = Userdao.find(u.getAccount());
				System.out.println(u.getAccount());
			for(String sq:alp){
				System.out.println(sq);
				if(!sq.equals("管理员")&&!sq.equals("仓库")){
					System.out.println("类型"+sq);
					flag=false;
					response.sendRedirect(request.getContextPath()+"/promt.jsp");return;
				}
			}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(flag){
			request.getRequestDispatcher("gztm/xxcx/dlqy.jsp").forward(request,response);
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
