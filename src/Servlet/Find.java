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

public class Find extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String str="";
			String poid=request.getParameter("poid");
			String startime=request.getParameter("startime");
			String endtime=request.getParameter("endtime");
			String gongying = request.getParameter("gongying");
			String paytype = request.getParameter("paytype");
			System.out.println(paytype);
			try {
			 str+="select * from pomain,vender where 1=1 and pomain.vendercode=vender.vendercode";
			 if(poid!=""){
				 str+=(" and poid like '%"+poid+"%'");
			 }
			 if(startime!=""&&endtime!=""){
				 str+=(" and createtime>= '"+startime+"' and createtime <= '"+endtime+"' ");
			 }
			 if(startime!=""&&endtime==""){
				 str+=(" and createtime>= '"+startime+"' ");
			 }
			 if(startime==""&&endtime!=""){
				 str+=(" and createtime<= '"+endtime+"' ");
			 }
			 if(!gongying.equals("请选择供应商")){
					String verdencode= Verdendao.findid(gongying);
					str+=(" and vender.vendercode='"+verdencode+"'");
				}
			 if(!paytype.equals("请选择付款方式")){
				 str+=(" and paytype= '"+paytype+"'");
			 }
			 System.out.println(str);
			 ArrayList<Pomain> al=Pomaindao.xunz(str);
			 System.out.println(al.size());
			 if(al.size()==0){
				 request.setAttribute("quxiao","没有这条数据");
				 request.getRequestDispatcher("/purchase/y.jsp").forward(request, response);
			 }else{
				 request.getSession().setAttribute("jihe",al);
				 request.getRequestDispatcher("/purchase/y.jsp").forward(request, response);
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
