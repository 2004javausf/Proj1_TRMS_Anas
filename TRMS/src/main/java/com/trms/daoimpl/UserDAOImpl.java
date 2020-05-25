package com.trms.daoimpl;

import com.trms.beans.User;
import com.trms.dao.UserDAO;
import com.trms.util.ConnFactory;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class UserDAOImpl implements UserDAO {
	
	ConnFactory cc = ConnFactory.getInstance();
	Connection connection = null;
	PreparedStatement stmt = null;
	CallableStatement call = null;
	
	@Override
	public void createUser(User user) throws SQLException{
		try {
			connection = cc.getConnection();
			String sql ="INSERT INTO USERS VALUES(null,?,?)"; //1st value is the password
															  // 2nd value is the username
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, user.getPassword());
			stmt.setString(2, user.getFirstName());
			stmt.execute();	
		}catch(SQLException e) {
			
		}finally {
			closeResources();
		}	
	}
	
	// Get User List
	@Override
	public void createUser2(String username, String password, String firstName, String lastName, String pos) {
		try {
			connection = cc.getConnection();
			String sql ="INSERT INTO USERS VALUES(USERSEQ.NEXTVAL,?,?,?,?,?,?,?,1000)"; 
			stmt = connection.prepareStatement(sql);
			stmt.setString(1, username);
			stmt.setString(2, password);
			stmt.setString(3, firstName);
			stmt.setString(4, lastName);
			stmt.setString(5, pos);
			stmt.execute();	
		}catch(SQLException e) {
			
		}finally {
			closeResources();
		}		
	}
	
	
	// Get All Users
	@Override
	public List<User> getUsers() {
		List<User> users = new ArrayList<User>();
		try {
			connection = cc.getConnection();
			String sql = "SELECT * FROM USERS";
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			User user = null;
			while(rs.next()) {
				user = new User(rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getDouble(7));				
				users.add(user);
			}
		
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			closeResources();
		}
		return users;
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
			System.out.println("Could not close connection!");
			e.printStackTrace();
		}
	}
	

}