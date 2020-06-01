package com.trms.daoimpl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trms.beans.Event;
import com.trms.beans.Form;
import com.trms.beans.GradeFormat;
import com.trms.beans.User;
import com.trms.util.ConnFactory;

public class GetInfoDAOImpl {
	
	public static ConnFactory cf = ConnFactory.getInstance();
	
	// Retrieve all users
	public static List<User> getInfo() throws SQLException {
		Connection conn = cf.getConnection();
		String sql = "SELECT * FROM USERS";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		List<User> tmpList = new ArrayList<User>();
		
		while(rs.next()) {
			tmpList.add(new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getDouble(6)));
		}
		
		return tmpList;
	}
	
	// Retrieve all Events
	public  List<Event> getEventTypes() throws SQLException {
		Event et = null;
		List<Event> etList = new ArrayList<Event>();
		Connection conn = cf.getConnection();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("SELECT * FROM EVENT_TYPE");
		
		while(rs.next()) {
			et = new Event(rs.getInt(1),rs.getString(2),rs.getInt(3));
			etList.add(et);
		}
		
		return etList;
		}
		
	// Retrieve all grade formats
	public  List<GradeFormat> getGF() throws SQLException {
		GradeFormat gf = null;
		List<GradeFormat> gfList = new ArrayList<GradeFormat>();
		Connection conn = cf.getConnection();
		Statement stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery("SELECT * FROM GRADING_FORMAT");
		
		while(rs.next()) {
			gf=new GradeFormat(rs.getInt(1),rs.getString(2),rs.getString(3));
			gfList.add(gf);
		}
		
		return gfList;
		}

	
	// Insert new reimbursement into database
	public void insertReimburse(Form rim) throws SQLException {
		Connection conn = cf.getConnection();
		
		System.out.println("in insertReimburse()");
		String sql = "INSERT INTO RFORMS VALUES (FORMS_ID_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,1,?,?,'TBD',?,?,'Pending')";
		PreparedStatement ps = conn.prepareStatement(sql);

		ps.setInt(1, rim.getUserID());
		ps.setString(2, rim.getfName());
		ps.setString(3, rim.getlName());
		ps.setDouble(4, rim.getCost());
		ps.setDouble(5, rim.getReimbursement());
		ps.setString(6, rim.geteType());
		ps.setDate(7, rim.getEventDate());
		ps.setString(8, rim.getEventLocation());
		ps.setString(9, rim.getDesc());
		//ps.setInt(8, rim.getFormLvl());
		ps.setString(10, rim.getgFormat());
		ps.setString(11, rim.getPassingGrade());
		ps.setString(12, rim.getJustification());
		ps.setInt(13, rim.getDaysMissed());
		
		ps.executeUpdate();	
	}
	
	//insert reimbursement
	public void insertRim(Form rim) throws SQLException {
			Connection conn = cf.getConnection();
			
			String sql = "{ call NEW_REIMBURSE(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			CallableStatement call = conn.prepareCall(sql);
			
			call.setInt(1, rim.getUserID());
			call.setString(2, rim.getfName());
			call.setString(3, rim.getlName());
			call.setDouble(4, rim.getCost());
			call.setDouble(5, rim.getReimbursement());
			call.setString(6, rim.geteType());
			call.setDate(7, rim.getEventDate());
			call.setString(8, rim.getEventLocation());
			call.setString(9, rim.getDesc());
			call.setInt(10, rim.getFormLvl());
			call.setString(11, rim.getgFormat());
			call.setString(12, rim.getPassingGrade());
			call.setString(13, rim.getJustification());
			call.setInt(14, rim.getDaysMissed());
			
			call.execute();
		}
	
	//Approve reimbursement
	public void approveRim(int formID) throws SQLException {
			Connection conn = cf.getConnection();
				
			String sql = "{ call APPROVEREIMBURSE(?)";
				
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, formID);

			call.execute();
	}
	
	
	//Reject reimbursement
	public void rejectRim(int formID, String reason) throws SQLException {
			Connection conn = cf.getConnection();
				
			String sql = "{ call REJECTREIMBURSE(?,?)";
				
			CallableStatement call = conn.prepareCall(sql);
			call.setInt(1, formID);
			call.setString(2, reason);

			call.execute();
	}
	
	//Reject reimbursement
	public void insertGrade(int formID, String grade) throws SQLException {
				Connection conn = cf.getConnection();
					
				String sql = "{ call INSERTGRADE(?,?)";
					
				CallableStatement call = conn.prepareCall(sql);
				call.setInt(1, formID);
				call.setString(2, grade);

				call.execute();
		}
			
}
