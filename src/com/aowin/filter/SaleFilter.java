package com.aowin.filter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.Userdao;
import com.aowin.model.User;

public class SaleFilter implements Filter{

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) arg0;
		HttpServletResponse resp=(HttpServletResponse) arg1;
	
		User u=(User) req.getSession().getAttribute("user");
		if(u!=null){
			try {
				ArrayList<String> al=Userdao.find(u.getAccount());
				String path=req.getServletPath();
				System.out.println(path);
				boolean b=false;
				for(String s:al){
					if("销售".equals(s)&&path.startsWith("/sale")||"管理员".equals(s)&&path.startsWith("/sale")){
						b=true;
					}
				}
				if(b){
					arg2.doFilter(req,resp);
				}else{ 
				resp.sendRedirect(req.getContextPath()+"/promt.jsp");
				
			}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	

}
