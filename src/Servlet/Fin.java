package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.Userdao;
import com.aowin.model.User;

import Dao.Polidao;
import Model.Ploi;


public class Fin extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				String sql1="select * from pomain,vender where paytype='货到付款' and status=3 and pomain.vendercode=vender.vendercode ";
				String sql2="select * from pomain,vender where paytype='款到发货' and status=2 and pomain.vendercode=vender.vendercode ";
				String sql3="select * from pomain,vender where paytype='预付款到发货' and status=3 and pomain.vendercode=vender.vendercode ";
					if(request.getSession().getAttribute("user")==null){
						response.sendRedirect(request.getContextPath()+"/login.jsp");return;
					}
				try {
					User u=(User) request.getSession().getAttribute("user");
					ArrayList<String> alp;
					alp = Userdao.find(u.getAccount());
				for(String sq:alp){
					if(!sq.equals("管理员")&&!sq.equals("采购")){
						response.sendRedirect(request.getContextPath()+"/promt.jsp");return;
					}
				}
					ArrayList<Ploi> al1=Polidao.find(sql1);
					ArrayList<Ploi> al2=Polidao.find(sql2);
					ArrayList<Ploi> al3=Polidao.find(sql3);
					if(al1.size()!=0){
					request.setAttribute("pl1",al1);
					}
					if(al2.size()!=0){
					request.setAttribute("pl2",al2);
					}
					
					if(al3.size()!=0){
					request.setAttribute("pl3",al3);
					}
					request.getRequestDispatcher("/purchase/j.jsp").forward(request, response);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	}
	

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
