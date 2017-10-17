package com.aowin.filter;

import java.io.IOException;
import java.util.logging.Filter;

public class Atherfil implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
			HttpServletRequest req=(HttpServletRequest) request;
			HttpServletResponse resp=(HttpServletResponse) response;
		
			User u=(User) req.getSession().getAttribute("user");
		
				if(u!=null){
					try {
					ArrayList<String> al=Userdao.find(u.getAccount());
					String path=req.getServletPath();
					System.out.println(path);
					boolean b=false;
					for(String s:al){
						if("閲囪喘".equals(s)&&path.startsWith("/purchase")||"绠＄悊鍛�.equals(s)&&path.startsWith("/purchase")){
							b=true;
						}
					}
					if(b){chain.doFilter(req, resp);
					}
				else{ 
					resp.sendRedirect(req.getContextPath()+"/promt.jsp");
					
				}
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				}
				
		
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
