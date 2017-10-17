package com.aowin.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.aowin.dao.InstockRecordDao;
import com.aowin.dao.OutStockRecord;
import com.aowin.dao.StockDao;
import com.aowin.model.PoItem;
import com.aowin.model.SoItem;
import com.aowin.model.Stock;

public class StockSum extends HttpServlet {

	/**
		 * Constructor of the object.
		 */
	public StockSum() {
		super();
	}

	/**
		 * Destruction of the servlet. <br>
		 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
		 * The doGet method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to get.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int year=Integer.valueOf(request.getParameter("year"));
		int month=Integer.valueOf(request.getParameter("month"));
		Calendar cal=Calendar.getInstance();
		int y=cal.get(Calendar.YEAR);
		int m=cal.get(Calendar.MONTH)+1;
		int gap=(y-year)*12+m-month;
		ArrayList<Stock> al=getStockByMonth(gap);
		int sum=0;
		for(Stock st:al){
			sum+=st.getNumber();
		}
		request.setAttribute("size", sum);
		request.setAttribute("monthStock", al);
		request.getRequestDispatcher("gztm/xxcx/StockSum.jsp").forward(request,response);
		
	}

	/**
		 * The doPost method of the servlet. <br>
		 *
		 * This method is called when a form has its tag value method equals to post.
		 * 
		 * @param request the request send by the client to the server
		 * @param response the response send by the server to the client
		 * @throws ServletException if an error occurred
		 * @throws IOException if an error occurred
		 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request,response);
	}

	/**
		 * Initialization of the servlet. <br>
		 *
		 * @throws ServletException if an error occurs
		 */
	public void init() throws ServletException {
		// Put your code here
	}
	
	public ArrayList<Stock> getStockByMonth(int gap){
	   ArrayList<Stock> l=StockDao.getInStock("select * from stock");
	   if(gap==0){
		   return l;
	   }
	    while(gap>0){
	    	Calendar cal=Calendar.getInstance();
			int y=cal.get(Calendar.YEAR);
			int m=cal.get(Calendar.MONTH);
	    	ArrayList<PoItem> in=new ArrayList<PoItem>();
	    	ArrayList<SoItem> out=new ArrayList<SoItem>();
	    	int year=y-gap/12;
	    	int month=m-gap%12+2;
	    	int ye=year,mon=month;
	    	if(month<=0){
	    		ye=year-1;
	    		mon=12+month;
	    	}
	    	String time="";
	    	if(mon<10){
	    		time=ye+"-0"+mon;
	    	}else{
	    		time=ye+"-"+mon;
	    	}
	    	InstockRecordDao ir=new InstockRecordDao();
	    	OutStockRecord or=new OutStockRecord();
	    	in=ir.getInStockRecord(time);
	    	out=or.getOutStockRecord(time);
	    	System.out.println(in.size());
	    	System.out.println("出库记录"+out.size());
	    	for(SoItem item:out){
	    		String proCode=item.getProductCode();
	    		System.out.println(proCode);
	    		if(!hasProduct(proCode,l)){
	    			Stock sto=new Stock();
	    			sto.setProCode(proCode);
		    		sto.setName(item.getProductCode());
		    		sto.setNumber(item.getNum());
		    		l.add(sto);
	    		}else{
	    			for(Stock s:l){
	    				if(s.getProCode().equals(proCode)){
	    					int number=s.getNumber();
	    					s.setNumber(number+item.getNum());
	    				}
	    			}
	    		}
	    	}
	    	for(PoItem item:in){
	    		String proCode=item.getProCode();
	    		for(Stock s:l){
	    			if(s.getProCode().equals(proCode)){
	    				int number=s.getNumber();
    					s.setNumber(number-item.getNum());
	    			}
	    		}
	    
	    	}
	    	
	    	gap--;
	    }
	    return l;
	}
	
	public boolean hasProduct(String productCode, ArrayList<Stock> al){
		boolean flag=false;
		for(Stock s:al){
			if(s.getProCode().equals(productCode)){
				flag=true;
				return flag;
			}
		}
		return flag;
	}

}
