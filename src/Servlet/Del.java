package Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.model.User;

import Dao.Poiemdao;
import Dao.Productdao;
import Model.Poitem;


public class Del extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Poitem> all=new ArrayList<Poitem>();
			String po1=request.getParameter("po1");
			String po2=request.getParameter("po2");
			String po3=request.getParameter("po3");
			String po4=request.getParameter("po4");
			String po5=request.getParameter("po5");
			String po6=request.getParameter("po6");
			String po7=request.getParameter("po7");
			String po8=request.getParameter("po8");
			String po9=request.getParameter("po9");
			Object s=request.getSession().getAttribute("user");
				User u=(User) s;	
				boolean b = false;
				try {
					b = Poiemdao.ap(po1,u.getAccount());
					System.out.println(b);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(!b){
					request.getSession().setAttribute("falp","无法删除其余人的采购单");
					response.sendRedirect(request.getContextPath()+"/servlet/Ser");return;
				}
				else{
					try {
				ArrayList<Poitem> al=Poiemdao.find(po1);
				for(Poitem p:al){
					Poitem p1=new Poitem();
					p.getNum();
				int u1=Productdao.num(p.getProductcode());
				//p.setPonum(u-p.getNum());
				p1.setProductcode(p.getProductcode());
				p1.setPonum(u1-p.getNum());
				all.add(p1);
				}
				//System.out.println(po1);
				//System.out.println(all);
				Poiemdao.dele(po1, all);
				request.getSession().setAttribute("yiu","成功");
				response.sendRedirect(request.getContextPath()+"/servlet/Ser");return;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				request.getSession().setAttribute("yui","失败");
				response.sendRedirect(request.getContextPath()+"/servlet/Ser");
				//System.out.println(request.getContextPath()+"/servlet/Ser");
			}
			}

	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
