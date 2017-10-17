package Servlet;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Poiemdao;
import Dao.Pomaindao;
import Dao.Productdao;
import Model.Poitem;
import Model.Pomain;

public class Change extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Poitem> all=new ArrayList<Poitem>();
		ArrayList<Poitem> al2=new ArrayList<Poitem>();
	
		Pomain p2=new Pomain();
			String code=request.getParameter("code");//�ɹ������
			String gongying=request.getParameter("gongying");//������
			String account=request.getParameter("account");//�ɹ���
			String paytype=request.getParameter("paytype");
			String fujia=request.getParameter("fujia");
			String allprice=request.getParameter("allprice");
			String alle=request.getParameter("alle");
			String yufu=request.getParameter("yufu");
			String status=request.getParameter("status");
			String[] loi=request.getParameterValues("loi");
			String[] productcode=request.getParameterValues("productcode");
			String[] namepl=request.getParameterValues("namepl");
			String[] unitname=request.getParameterValues("unitname");
			String[] unitprice=request.getParameterValues("unitprice");
			String[] number=request.getParameterValues("number");
			String[] teval=request.getParameterValues("teval");//�ܼ�
			boolean bo=true;
			for(int i=0;i<teval.length;i++){
				if(teval[i].equals("0")||teval.length==0){
					bo=false;
				}
			}
			if(!bo){
				request.setAttribute("shibai","明细单不能为空");
				request.getRequestDispatcher("Ser").forward(request, response);return;
			}else{
				try {
					ArrayList<Poitem> al=Poiemdao.find(code);
					for(Poitem p:al){
						Poitem p1=new Poitem();
						int u=Productdao.num(p.getProductcode());
						p1.setProductcode(p.getProductcode());
						p1.setPonum(u-p.getNum());
						all.add(p1);	
					}
					Poiemdao.dele(code, all);
					String s=Pomaindao.att(gongying);//��Ӧ�̱��
					Date d=new Date();
					SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					String hehe = dateFormat.format( d ); 
					p2.setAccount(account);
					p2.setPoid(code);
					p2.setVendercode(s);
					p2.setCreatetime(hehe);
					p2.setTipfee(new BigDecimal(Float.valueOf(fujia)));
					p2.setProducttotal(new BigDecimal(Float.valueOf(allprice)));
					p2.setPototal(new BigDecimal(Float.valueOf(alle)));
					p2.setPaytype(paytype);
					p2.setPrepayfee(new BigDecimal(Float.valueOf(yufu)));
					p2.setStatus(Integer.valueOf(status));
					for(int p=0;p<teval.length;p++){
						Poitem q=new Poitem();
						q.setPoid(code);
						q.setProductcode(productcode[p]);
						q.setUnitprice(new BigDecimal(Float.valueOf(unitprice[p])));
						q.setNum(Integer.valueOf(number[p]));
						q.setUnitname(unitname[p]);
						q.setItemprice(new BigDecimal(Float.valueOf(teval[p])));
						q.setPonum((Productdao.num(productcode[p]))+Integer.valueOf(number[p]));
						al2.add(q);
					}
					Pomaindao.qwe(p2, al2);
					//request.getSession().setAttribute("yiu","�ɹ�");
					//response.sendRedirect(request.getContextPath()+"/servlet/Ser");return;
					request.getSession().setAttribute("qunimei","aasdasd");
					response.sendRedirect(request.getContextPath()+"/servlet/Ser");return;
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					request.getSession().setAttribute("axi","aasdasd");
					response.sendRedirect(request.getContextPath()+"/servlet/Ser");
				}
			}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
