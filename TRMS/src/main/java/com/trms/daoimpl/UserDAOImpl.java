package com.trms.daoimpl;

import com.trms.beans.Form;
import com.trms.beans.User;
import com.trms.dao.UserDAO;
import com.trms.util.ConnFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {
	
	ConnFactory cc = ConnFactory.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;
	
	// Get All Users
	@Override
	public List<User> getUserList() {
		List<User> users = new ArrayList<User>();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM USERS";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			User user = new User();
			while(rs.next()) {
				user = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7));				
				users.add(user);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return users;
	}
	
	// Get logged user's reimbursements
	@Override
	public List<Form> getMyFormList(int userID) {
		List<Form> forms = new ArrayList<Form>();
		System.out.println("in getMyFormList()");
		try {
			connection = cc.getConnection();
			Statement state = connection.createStatement();			
			ResultSet rs = state.executeQuery("SELECT * FROM RFORMS WHERE USER_ID = " + userID);
			//ResultSet rs = state.executeQuery("SELECT * FROM RFORMS");
			Form form = null;
			
			while(rs.next()) {
				System.out.println("in while loop");
				form = new Form(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6),rs.getString(7), rs.getDate(8),
						rs.getString(9),rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getInt(16), rs.getString(17));
				forms.add(form);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		System.out.println(forms);
		return forms;
	}
	
	// Get logged user's reimbursements
	@Override
	public List<Form> getAllFormList() {
		List<Form> forms = new ArrayList<Form>();
		System.out.println("in getAllFormList()");
		try {
			connection = cc.getConnection();
			Statement state = connection.createStatement();			
			ResultSet rs = state.executeQuery("SELECT * FROM RFORMS");
			Form form = null;
			
			while(rs.next()) {
				System.out.println("in while loop");
				form = new Form(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getString(4), rs.getDouble(5), rs.getDouble(6),rs.getString(7), rs.getDate(8),
						rs.getString(9),rs.getString(10), rs.getInt(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15), 
						rs.getInt(16), rs.getString(17));
				forms.add(form);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		
		System.out.println(forms);
		return forms;
	}
	

	// Close Resources
	private void closeResources() {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			System.out.println("Could not close statement!");
			e.printStackTrace();
		}
		
		try {
			if (connection != null)
				connection.close();
		} catch (SQLException e) {
			System.out.println("Unable to close the connection!");
			e.printStackTrace();
		}
	}
	

}