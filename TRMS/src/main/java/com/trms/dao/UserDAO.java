package com.trms.dao;

import java.sql.SQLException;
import java.util.List;
import com.trms.beans.User;


public interface UserDAO {

	public void createUser(User user) throws SQLException;

	public List<User> getUserList() throws SQLException;

}
