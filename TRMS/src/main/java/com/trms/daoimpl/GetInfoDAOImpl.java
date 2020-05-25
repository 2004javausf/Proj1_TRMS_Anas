package com.trms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.trms.beans.User;
import com.trms.util.ConnFactory;

public class GetInfoDAOImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	public static List<User> getInfo() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM TRS_USERS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<User> tmpList = new ArrayList<User>();
		
		while(rs.next()) {
			tmpList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
		}
	
		return tmpList;
	}
	
}
