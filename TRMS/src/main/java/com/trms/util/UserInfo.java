package com.trms.util;

import java.util.List;

import com.trms.beans.User;
import com.trms.daoimpl.UserDAOImpl;

public class UserInfo {
	
	// Find Employee by user name
	public static User findUserByUsername(String inputUserName) {
		UserDAOImpl userdi = new UserDAOImpl();
		List<User> employeeList = null;
		User c = new User();
		
		employeeList = userdi.getUserList();
		
		for (int i = 0; i < employeeList.size(); i++) {
			String userName = employeeList.get(i).getUsername();
			if (inputUserName.equals(userName)) {
				c = employeeList.get(i);
			}
		}
			
		return c;
	}	
	
}
