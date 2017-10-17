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
import Dao.Pomaindao;
import Dao.Verdendao;
import Model.Poitem;
import Model.Pomain;

public class Chuang extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String po1=request.getParameter("po1");//poid pomain������
		String po2=request.getParameter("po2");//createtime �޸�����
		String po3=request.getParameter("po3");//������
		String po4=request.getParameter("po4");//��Ӧ�̱��
		String po5=request.getParameter("po5");//���ӷ���
		String po6=request.getParameter("po6");//�ɹ����ܼ�
		String po7=request.getParameter("po7");//��Ʒ�ܼ�
		String po8=request.getParameter("po8");//���ʽ
		String po9=request.getParameter("po9");//Ԥ����
		User u=(User) request.getSession().getAttribute("user");
		boolean b=false;
			try {
				b=Poiemdao.ap(po1,u.getAccount());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(!b){
				request.getSession().setAttribute("qaz","asdasd");
				request.getRequestDispatcher("Ser").forward(request, response);return;
			}
			else{
				try {
			Pomain p=Pomaindao.chuan(po1);
			Pomain p1=new Pomain();
			p1.setName(Verdendao.findname(p.getVendercode()));
			//System.out.println(p1.getName());
			p1.setAccount(p.getAccount());
			//System.out.println(p1.getAccount()+"sadasd");
			p1.setPoid(p.getPoid());
			p1.setVendercode(p.getVendercode());
			p1.setCreatetime(p.getCreatetime());
			p1.setTipfee(p.getTipfee());
			p1.setProducttotal(p.getProducttotal());
			p1.setPototal(p.getPototal());
			p1.setPaytype(p.getPaytype());
			p1.setPrepayfee(p.getPrepayfee());
			p1.setStatus(p.getStatus());
			request.setAttribute("pomain",p1);
			ArrayList<Poitem> al=Poiemdao.po(po1);
			request.setAttribute("ae",al);
			request.getRequestDispatcher("/purchase/p.jsp").forward(request, response);
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
