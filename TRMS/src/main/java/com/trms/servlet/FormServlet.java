package com.trms.servlet;

import java.io.IOException;

import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.trms.beans.Form;
import com.trms.daoimpl.GetInfoDAOImpl;

/**
 * Servlet implementation class Form
 */
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FormServlet() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("in doPost of FormServlet");
		
		Form rim = null;
		ObjectMapper mapper = new ObjectMapper();
		
		//convert JSON to Java Object
		rim = mapper.readValue(request.getInputStream(),Form.class);
		System.out.println(rim);
		GetInfoDAOImpl rdi = new GetInfoDAOImpl();
		try {
			rdi.insertReimburse(rim);
			PrintWriter pw = response.getWriter();
			pw.write("<h3> Successfully submitted new Reimbursement Form</h3>");
			System.out.println("After insertReimburse()");
			pw.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
