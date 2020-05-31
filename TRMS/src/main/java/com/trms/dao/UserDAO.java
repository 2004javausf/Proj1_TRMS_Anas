package com.trms.dao;

import java.sql.SQLException;
import java.util.List;

import com.trms.beans.Form;
import com.trms.beans.User;


public interface UserDAO {

	public List<User> getUserList() throws SQLException;

	public List<Form> getMyFormList(int userID) throws SQLException;

	public List<Form> getAllFormList() throws SQLException;

}
