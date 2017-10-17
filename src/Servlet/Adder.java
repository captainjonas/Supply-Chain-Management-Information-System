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

import Dao.Pomaindao;
import Dao.Productdao;
import Model.Poitem;
import Model.Pomain;

public class Adder extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Pomain p2=new Pomain();
		ArrayList<Poitem> al=new ArrayList<Poitem>();
			String bianhao=request.getParameter("bianhao");//bianhao
			String gongying=request.getParameter("gongying");//��Ӧ��
			String textfield=request.getParameter("textfield");//�û�
			String type=request.getParameter("type");//��������
			String fujia=request.getParameter("fujia");//���ӷ���
			String allprice=request.getParameter("allprice");//�ɹ���Ʒ�ܼ�
			String all=request.getParameter("all");//�ɹ����ܼ�
			String yu=request.getParameter("yufu");//Ԥ����
			//System.out.println(yu);
			String zhuangtai=request.getParameter("zhuangtai");//״̬
			String[] te=request.getParameterValues("te");//��Ʒ����
			String[] shan=request.getParameterValues("shan");//��Ʒ����
			String[] ta=request.getParameterValues("ta");//��Ʒ��λ
			String[] tb=request.getParameterValues("tb");//��Ʒ����
			String[] ted=request.getParameterValues("ted");//��������
			String[] tc=request.getParameterValues("tc");//�ܼ�
			boolean bo=true;
			boolean as=true;
			if(tc==null){
				request.setAttribute("bo2","不能为空");
				request.getRequestDispatcher("/purchase/ins.jsp").forward(request, response);return;
			}
			for(int i=0;i<tc.length;i++){
				if(tc[i]==""){
					as=false;
				}
			}
			//System.out.println(tc);
			//System.out.println(tc[1]);
			if(tc==null||allprice==""||as==false){
				request.setAttribute("bol","不能为空");
				request.getRequestDispatcher("/purchase/ins.jsp").forward(request, response);return;
			}
			for(int i=0;i<tc.length;i++){
				if(tc[i]==""||tc.length==0){
					bo=false;
				}
			}
			//System.out.println(BigDecimal.valueOf(allprice));
			//System.out.println(all);
			//System.out.println(te.length);
				//System.out.println(gongying);
			try {
				String s=Pomaindao.att(gongying);//��Ӧ�̱��
				//System.out.println(s);
				Date d=new Date();
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				String hehe = dateFormat.format( d ); 
				p2.setPoid(bianhao);
				p2.setVendercode(s);
				p2.setAccount(textfield);
				p2.setCreatetime(hehe);
				p2.setTipfee(new BigDecimal(Float.valueOf(fujia)));
				p2.setProducttotal(new BigDecimal(Float.valueOf(allprice)));
				p2.setPototal(new BigDecimal(Float.valueOf(all)));
				p2.setPaytype(type);
				p2.setPrepayfee(new BigDecimal(Float.valueOf(yu)));
				p2.setStatus(Integer.valueOf(zhuangtai));
				
			for(int i=0;i<te.length;i++){
				Poitem p=new Poitem();
				p.setPoid(bianhao);
				p.setProductcode(te[i]);
				p.setUnitprice(new BigDecimal(Float.valueOf(tb[i])));
				p.setNum(Integer.valueOf(ted[i]));
				p.setUnitname(ta[i]);
				p.setItemprice(new BigDecimal(Float.valueOf(tc[i])));
				p.setPonum((Productdao.num(te[i]))+Integer.valueOf(ted[i]));
						al.add(p); 
						} 
				Pomaindao.qwe(p2, al);
				request.getSession().setAttribute("jiu","aasdasd");
				response.sendRedirect(request.getContextPath()+"/servlet/Ser");
				}
			catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							System.out.println(e.getMessage());
							request.getSession().setAttribute("qwe","aasdasd");
							response.sendRedirect(request.getContextPath()+"/servlet/Ser");
						}
			
				
			
	
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
