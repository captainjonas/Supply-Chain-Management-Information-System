package com.aowin.servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.OutStockRecord;
import com.aowin.model.SoItem;
import com.aowin.util.CreateLog;

public class OutstockSum extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public OutstockSum() {
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

		String month=request.getParameter("month");
		OutStockRecord or=new OutStockRecord();
		ArrayList<SoItem> al=or.getOutStockRecord(month);
		int n=al.size();
		int num=0;
		BigDecimal money=new BigDecimal(0.00);
		for(SoItem item:al){
			num+=item.getNum();
			money=money.add(item.getItemPrice());
		}
		request.setAttribute("outstockRecord", al);
		request.setAttribute("n", n);
		request.setAttribute("num",num);
		request.setAttribute("money", money);
		request.getRequestDispatcher("gztm/xxcx/OutstockSum.jsp").forward(request,response);
		
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
