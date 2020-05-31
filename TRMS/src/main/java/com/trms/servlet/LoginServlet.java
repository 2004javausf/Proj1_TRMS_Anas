package com.trms.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.beans.User;
import com.trms.daoimpl.UserDAOImpl;


public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doGet of LoginServlet");
		ObjectMapper mapper = new ObjectMapper();
		HttpSession session = request.getSession();
		PrintWriter pw = response.getWriter();
		User user = new User();
		String etJSON;
		
		try {	
			user = (User) session.getAttribute("user");
			
			etJSON = mapper.writeValueAsString(user);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			System.out.println(etJSON);
			pw.print(etJSON);
			
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		
		pw.flush();
	}

	protected void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		String uName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		System.out.println("in doPost LoginServlet");
		System.out.println(uName + " " + password);
		
		UserDAOImpl userdi = new UserDAOImpl();
		List<User> uList=new ArrayList<User>();
		User user = new User();
		boolean validUser = false;
		
		uList = userdi.getUserList();
		for(int i=0; i<uList.size();i++) {
			if((uList.get(i).getUsername().equalsIgnoreCase(uName)) && (uList.get(i).getPassword().equals(password))) {
				user = uList.get(i);
				validUser = true;
			}
		
		}
		
		System.out.println(user);
		if(validUser==true) {
			HttpSession session=request.getSession();
			session.setAttribute("user",user);
			request.getRequestDispatcher("homepage1.html").include(request, response);
		}else {
			pw.print("Sorry, the username or password is incorrect");
			request.getRequestDispatcher("index.html").include(request, response);
		}
		pw.close();
	}
}
