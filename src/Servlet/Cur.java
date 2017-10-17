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

import Dao.Verdendao;
import Model.Inter;
import Model.Page;

public class Cur extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Inter> al=new ArrayList<Inter>();
	Object s = request.getSession().getAttribute("bur");
		Object boo = request.getSession().getAttribute("boo");
		Object bw = request.getSession().getAttribute("bw");
		Object qwer = request.getSession().getAttribute("qwer");
		Object x = request.getAttribute("x");
		Object zx = request.getAttribute("zx");
		if(request.getSession().getAttribute("user")==null){
			response.sendRedirect(request.getContextPath()+"/login.jsp");return;
		}else{
				User u=(User) request.getSession().getAttribute("user");
				ArrayList<String> alp;
				try {
					alp = Userdao.find(u.getAccount());
				for(String sq:alp){
					if(!sq.equals("管理员")&&!sq.equals("采购")){
						response.sendRedirect(request.getContextPath()+"/promt.jsp");return;
					}
				}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			String r=request.getServletPath();
		if(x!=null){
			request.setAttribute("x","删除失败，这个供货商还有其他的订单未处理");
		}
		if(zx!=null){
			request.setAttribute("zx","删除成功");
		}
		if(boo!=null){
			request.getSession().removeAttribute("boo");
			request.setAttribute("boo", "增加成功");
		}
		if(bw!=null){
			request.getSession().removeAttribute("bw");
			request.setAttribute("bw", "修改成功");
		}
		if(qwer!=null){
			request.getSession().removeAttribute("qwer");
			request.setAttribute("bw", "修改失败");
		}
		if(s!=null){
			request.getSession().removeAttribute("bur");
			request.setAttribute("bur", "增加失败");
		}
				String page=request.getParameter("page");
				int nowpage;
				if(page==null||"".equals(page)){
					nowpage=1;
				}
				else{
					nowpage=Integer.valueOf(page);
				}
				Page p=new Page();
				p.setNowpage(nowpage);
				p.setPagefen(5);
				try {
					int cunt=Verdendao.ui();
					p.setAllpage(cunt%p.getPagefen()==0?cunt/p.getPagefen():(cunt/p.getPagefen())+1);
					Verdendao.shu(p);
					System.out.println(p.getPageyu());
					for(int i=1;i<=p.getAllpage();i++){
						Inter in=new Inter();
						in.setInter(i);
						al.add(in);
					}
					request.setAttribute("page", p);
					request.setAttribute("in",cunt);
					request.setAttribute("jihe", al);
					request.getRequestDispatcher("/purchase/provider.jsp").forward(request, response);
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
