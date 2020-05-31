package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.daoimpl.UserDAOImpl;

/**
 * Servlet implementation class MyRimServlet
 */
public class MyRimServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of viewMyRimServlet");
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		UserDAOImpl rdi = new UserDAOImpl();
		Integer id = mapper.readValue(request.getParameter("userid"),Integer.class);
		String etJSON;
		
		try {
			etJSON = mapper.writeValueAsString(rdi.getMyFormList(id));
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(etJSON);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		pw.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
