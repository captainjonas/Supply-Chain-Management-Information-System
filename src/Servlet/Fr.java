package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Polidao;
import Model.Ploi;

public class Fr extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String startime=request.getParameter("startime");
			String endtime=request.getParameter("endtime");
			if(startime!=""&&endtime!=""){
				String sql="select * from pomain,vender where pomain.vendercode=vender.vendercode and createtime>='"+startime+"' and createtime<='"+endtime+"'";
				try {
					BigDecimal sun=new BigDecimal(0.00);
					BigDecimal sum=new BigDecimal(0.00);
					ArrayList<Ploi> al=Polidao.find(sql);
					for(Ploi pl:al){
						sum.add(pl.getPototal());
					}
					
					request.setAttribute("qs",sum);
					request.setAttribute("qwes",al);
					int n=Polidao.uop(startime, endtime);
					request.setAttribute("qe",n);
					int y=Polidao.iop(startime, endtime);
					request.setAttribute("qw",y);
					ArrayList<BigDecimal> al2=Polidao.poi(startime, endtime);
					for(BigDecimal fl:al2){
						sun.add(fl);
					}
					request.setAttribute("fl", sun);
					request.getRequestDispatcher("/purchase/find.jsp").forward(request, response);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
				request.getRequestDispatcher("/purchase/find.jsp").forward(request, response);
			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
