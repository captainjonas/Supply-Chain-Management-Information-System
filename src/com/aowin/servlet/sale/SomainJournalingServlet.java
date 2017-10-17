package com.aowin.servlet.sale;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.sale.SaleDao;
import com.aowin.model.sale.Somain;

public class SomainJournalingServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		resp.setCharacterEncoding("utf-8");
		
		String yearMonth=req.getParameter("yearMonth");
		if(yearMonth!=""){

		try {
			SaleDao sd=new SaleDao();
			List<Somain> cl=sd.getSomain(yearMonth);
			int soIdNum=cl.size();
			int count=0;
			BigDecimal allSoTotal = new BigDecimal(0.00);
			BigDecimal allPaid=new BigDecimal(0.00);
			
			for (int i = 0; i <cl.size(); i++) {
				if(cl.get(i).getStatus()==4||cl.get(i).getStatus()==6){
					count++;
				};
				if((cl.get(i).getPayType().equals("货到付款")&&cl.get(i).getStatus()>=3)||(cl.get(i).getPayType().equals("款到发货")&&cl.get(i).getStatus()!=1)||(cl.get(i).getPayType().equals("预付款到发货")&&(cl.get(i).getStatus()>=3&&cl.get(i).getStatus()<5))){
					allPaid=allPaid.add(cl.get(i).getSoTotal());
					cl.get(i).setNonPayment(new BigDecimal(0.00));
				};
				if(cl.get(i).getPayType().equals("预付款到发货")&&(cl.get(i).getStatus()==5||cl.get(i).getStatus()==2)){
					allPaid=allPaid.add(cl.get(i).getPrePayFee());
					cl.get(i).setNonPayment(cl.get(i).getSoTotal().subtract(cl.get(i).getPrePayFee()));
				};
				if((cl.get(i).getPayType().equals("货到付款")&&cl.get(i).getStatus()<3)||(cl.get(i).getPayType().equals("款到发货")&&cl.get(i).getStatus()==1)||(cl.get(i).getPayType().equals("预付款到发货")&&cl.get(i).getStatus()==1)){
					cl.get(i).setNonPayment(cl.get(i).getSoTotal());
				};
				allSoTotal=allSoTotal.add(cl.get(i).getSoTotal());
			};
			
			req.setAttribute("soIdNum", soIdNum);
			req.setAttribute("count", count);
			req.setAttribute("allSoTotal", allSoTotal);
			req.setAttribute("allPaid", allPaid);
			req.setAttribute("cl", cl);
			req.getRequestDispatcher("/sale/saleJournalingAfterSelect.jsp").forward(req, resp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		}else {
			req.getRequestDispatcher("/sale/saleJournaling.jsp").forward(req, resp);
		}
		
	}
	
}