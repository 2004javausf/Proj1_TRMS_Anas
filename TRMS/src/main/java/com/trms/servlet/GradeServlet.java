package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.trms.daoimpl.GetInfoDAOImpl;



public class GradeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of GradeServlet");
		ObjectMapper mapper = new ObjectMapper();
		GetInfoDAOImpl rdi = new GetInfoDAOImpl();
		PrintWriter pw = response.getWriter();
		String gfJSON;
		try {
			gfJSON=mapper.writeValueAsString(rdi.getGF());
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			pw.print(gfJSON);
			
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pw.flush();
	}

	//get a json from our ajax and save it to database
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost");
	}

}
