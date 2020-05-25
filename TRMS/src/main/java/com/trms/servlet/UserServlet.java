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
import com.trms.beans.User;
import com.trms.dao.UserDAO;
import com.trms.daoimpl.UserDAOImpl;

/**
 * Servlet implementation class Users
 */
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		PrintWriter pw = response.getWriter();
		String infoJSON;
		UserDAO udi = new UserDAOImpl();
		try {
			infoJSON = mapper.writeValueAsString(udi.getUsers());
			response.setContentType("application/json");
			pw.print(infoJSON);
		}catch(JsonProcessingException | SQLException e ) {
			e.printStackTrace();
		}
		pw.flush();
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		User user = mapper.readValue(request.getInputStream(), User.class);
		UserDAO udi = new UserDAOImpl();
		try {
			udi.createUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}