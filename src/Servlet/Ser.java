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

import Dao.Pomaindao;
import Dao.Productdao;
import Dao.Verdendao;
import Model.Page1;
import Model.Product;
import Model.Vender;

public class Ser extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page=request.getParameter("page1");
		Object s=request.getSession().getAttribute("jiu");
		Object s1 = request.getSession().getAttribute("yui");
		Object s2 = request.getSession().getAttribute("yiu");
		Object s3 = request.getSession().getAttribute("qwe");
		Object s4 = request.getSession().getAttribute("qunimei");
		Object s33 = request.getSession().getAttribute("shi");
			if(request.getSession().getAttribute("user")==null){
				response.sendRedirect(request.getContextPath()+"/login.jsp");return;
			}else{
				try {
			User u=(User) request.getSession().getAttribute("user");
			ArrayList<String> alp;
			alp = Userdao.find(u.getAccount());
		for(String sq:alp){
			if(!sq.equals("管理员")&&!sq.equals("采购")){
				response.sendRedirect(request.getContextPath()+"/promt.jsp");return;
			}
		}
		if(s!=null){
			request.setAttribute("pol","增加成功");
			request.getSession().removeAttribute("jiu");
		}
		if(s1!=null){
			request.setAttribute("yui","删除失败");
			request.getSession().removeAttribute("yui");
		}
		if(s2!=null){
			request.setAttribute("yiu","删除成功");
			request.getSession().removeAttribute("yiu");
		}
		if(s3!=null){
			request.setAttribute("qwe","增加失败");
			request.getSession().removeAttribute("qwe");
		}
		if(request.getAttribute("shibai")!=null){
			request.setAttribute("shi","明细单不能为空");
			request.getSession().removeAttribute("shibai");
		}
		if(s4!=null){
			request.setAttribute("qunide","修改成功");
			request.getSession().removeAttribute("qunimei");
		}
		if(request.getSession().getAttribute("axi")!=null){
			request.setAttribute("kimi","修改失败");
			request.getSession().removeAttribute("axi");
		}
		if(request.getSession().getAttribute("falp")!=null){
			request.setAttribute("plo","无权限删除其余人员的采购单");
			request.getSession().removeAttribute("falp");
		}
		if(request.getSession().getAttribute("qaz")!=null){
			request.setAttribute("mkl","无权限修改其余人员的采购单");
			request.getSession().removeAttribute("qaz");
		}
		int nowpage;
		if(page==null||"".equals(page)){
			nowpage=1;
		}
		else{
			nowpage=Integer.valueOf(page);
		}
		Page1 p=new Page1();
		p.setNowpage(nowpage);
		p.setPagefen(5);
			ArrayList<Vender> al=Verdendao.find();
			ArrayList<Product> al1=Productdao.adn();
			request.getSession().setAttribute("gonghui",al);
			System.out.println(al);
			int cunt=Pomaindao.ui();
			p.setAllpage(cunt%p.getPagefen()==0?cunt/p.getPagefen():(cunt/p.getPagefen())+1);
			Pomaindao.find(p);
			request.getSession().setAttribute("page1", p);
			request.getSession().setAttribute("al",al1);
			request.getSession().setAttribute("i",cunt);
			request.getRequestDispatcher("/purchase/ins.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
