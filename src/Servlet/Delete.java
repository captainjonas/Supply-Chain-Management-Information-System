package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Pomaindao;
import Dao.Verdendao;
import Model.Pomain;

public class Delete extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			boolean b=true;
			String q=request.getParameter("q");
			//System.out.println(q);
			try {
				ArrayList<Pomain> al=Pomaindao.at(q);
				for(Pomain p:al){
					if(p.getStatus()==1||p.getStatus()==2||p.getStatus()==3||p.getStatus()==5){
						b=false;
					}
				}
				System.out.println(al.size());
				//System.out.println(b);
				if(b||al.size()==0){
					Verdendao.delete(q);
					request.setAttribute("zx","true");
					request.getRequestDispatcher("Cur").forward(request, response);
				}
				else{
					request.setAttribute("x","true");
					request.getRequestDispatcher("Cur").forward(request, response);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
