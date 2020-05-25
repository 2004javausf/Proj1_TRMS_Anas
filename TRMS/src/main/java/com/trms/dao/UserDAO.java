package com.trms.dao;

import java.sql.SQLException;
import java.util.List;
import com.trms.beans.User;


public interface UserDAO {

	public List<User> getUsers() throws SQLException;

	public void createUser2(String username, String password, String firstName, String lastName, String pos) throws SQLException;

	public void createUser(User user) throws SQLException;

}
