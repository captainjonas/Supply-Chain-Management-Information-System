package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.Poiemdao;
import Dao.Pomaindao;
import Model.Ploi;
import Model.Poiem;

public class Allmo extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String poid=request.getParameter("poid");
		try {
			Ploi p=Pomaindao.xuanyuan(poid);
			ArrayList<Poiem> all=Poiemdao.np(poid);
			request.setAttribute("ploi",p);
			request.setAttribute("po",all);
			request.getRequestDispatcher("/purchase/y.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
