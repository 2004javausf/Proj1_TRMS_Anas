package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.daoimpl.GetInfoDAOImpl;

/**
 * Servlet implementation class DenyRimServlet
 */
public class DenyRimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		response.setContentType("text/html");

		int formId = mapper.readValue(request.getParameter("rejection"), Integer.class);
		String reason = request.getParameter("reasonReject");

		GetInfoDAOImpl rdi = new GetInfoDAOImpl();
		
		try {
			rdi.rejectRim(formId,reason);
			PrintWriter pw = response.getWriter();
			request.getRequestDispatcher("homepage1.html").include(request, response);
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
