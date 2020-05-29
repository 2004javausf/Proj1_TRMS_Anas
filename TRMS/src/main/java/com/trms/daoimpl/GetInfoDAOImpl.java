package com.trms.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.trms.beans.Event;
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

	
//	// Retrieve all reimbursements to be reviewed by logged user
//	public List<ViewRim> getViewAllRim() throws SQLException{
//		ViewRim vr = null;
//		
//		List<ViewRim> vrList = new ArrayList<ViewRim>();
//		Connection conn = banana.getConnection();
//		Statement stmt=conn.createStatement();
//		ResultSet rs=stmt.executeQuery("SELECT EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
//				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
//				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
//				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY FROM REIMBURSEMENT " + 
//				"JOIN EMPLOYEE " + 
//				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
//				"JOIN EVENT " + 
//				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
//				"JOIN EVENT_TYPE " + 
//				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " + 
//				"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID");
//		while(rs.next()) {
//			System.out.println(rs.getDate(4));			
//			vr=new ViewRim(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
//			vrList.add(vr);
//			System.out.println(vr);
//		}
//		
//		return vrList;
//		
//	}
//	
//	
//	// Retrieve all of the logged user's reimbursements
//	public List<ViewRim> getMyRims(long empID) throws SQLException{
//		ViewRim vr = null;
//	
//		List<ViewRim> vrList = new ArrayList<ViewRim>();
//		Connection conn = banana.getConnection();
//		Statement stmt=conn.createStatement();
//		ResultSet rs=stmt.executeQuery("SELECT EMPLOYEE.EMPLOYEE_FIRSTNAME||' '||EMPLOYEE.EMPLOYEE_LASTNAME,REIMBURSEMENT.REIMBURSEMENT_COST, " + 
//				"UPPER(EVENT_TYPE.EVENT_TYPE_NAME),EVENT.EVENT_DATE,EVENT.EVENT_LOCATION,EVENT.EVENT_DESCRIPTION,EVENT.EVENT_GRADE, " + 
//				"REIMBURSEMENT.REIMBURSEMENT_JUSTIFICATION,REIMBURSEMENT.REIMBURSEMENT_DAYS_MISSED, " + 
//				"REIMBURSEMENT.REIMBURSEMENT_STATUS,REIMBURSEMENT.REIMBURSEMENT_STATUS_BY FROM REIMBURSEMENT " + 
//				"JOIN EMPLOYEE " + 
//				"ON REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID=EMPLOYEE.EMPLOYEE_ID " + 
//				"JOIN EVENT " + 
//				"ON REIMBURSEMENT.REIMBURSEMENT_EVENT=EVENT.EVENT_ID " +
//				"JOIN EVENT_TYPE " + 
//				"ON EVENT.EVENT_TYPE=EVENT_TYPE.EVENT_TYPE_ID " +
//				"WHERE REIMBURSEMENT.REIMBURSEMENT_EMPLOYEE_ID= "+empID +
//				"ORDER BY REIMBURSEMENT.REIMBURSEMENT_ID");
//		while(rs.next()) {
//			System.out.println(rs.getDate(4));			
//			vr=new ViewRim(rs.getString(1),rs.getDouble(2),rs.getString(3),rs.getDate(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));
//			vrList.add(vr);
//			System.out.println(vr);
//		}
//		
//		return vrList;	
//	}
	
	
}
