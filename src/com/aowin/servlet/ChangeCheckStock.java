package com.aowin.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.aowin.dao.CheckStoreDao;
import com.aowin.util.CreateLog;

public class ChangeCheckStock extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public ChangeCheckStock() {
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

		doPost(request,response);
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

		int stockNum=Integer.valueOf(request.getParameter("Num"));
		String proCode=(String)request.getSession().getAttribute("proCode");
		String name=(String)request.getSession().getAttribute("name");
		String unitName=(String)request.getSession().getAttribute("unitName");
		int realNum=Integer.valueOf(request.getParameter("realNum"));
		String type=request.getParameter("type");
		String description=request.getParameter("description");
		String time=request.getParameter("time");
		String createUser=request.getParameter("createUser");
			CheckStoreDao.addCheckStock(realNum+stockNum, type, description, time, createUser, proCode, stockNum,unitName,name);
			response.sendRedirect(request.getContextPath()+"/store?page=1");
		
			
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
