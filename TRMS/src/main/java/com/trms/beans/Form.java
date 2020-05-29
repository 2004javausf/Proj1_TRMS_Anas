package com.trms.beans;

import java.sql.Date;

public class Form {

	private int formID;            
    private int empID;
    private Date subDate;
    private float cost;            
    private String status;    
	private String justification; 
	private int daysMissed;
	
	private boolean urgent;
	
	private int eventID;
    private String eventName;  
    private Date eventDate;  
    private String eventLocation;        
    private String eventDesc;   
    private int eventPercent;
    
    private int gradeFormatID;
    private String gradeFormatName;
    private String passingGrade;
	
    
    public Form() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Form(int formID, int empID, Date subDate, float cost, String status, String justification, int daysMissed,
			boolean urgent, int eventID, String eventName, Date eventDate, String eventLocation, String eventDesc,
			int eventPercent, int gradeFormatID, String gradeFormatName, String passingGrade) {
		super();
		this.formID = formID;
		this.empID = empID;
		this.subDate = subDate;
		this.cost = cost;
		this.status = status;
		this.justification = justification;
		this.daysMissed = daysMissed;
		this.urgent = urgent;
		this.eventID = eventID;
		this.eventName = eventName;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.eventDesc = eventDesc;
		this.eventPercent = eventPercent;
		this.gradeFormatID = gradeFormatID;
		this.gradeFormatName = gradeFormatName;
		this.passingGrade = passingGrade;
	}


	public int getFormID() {
		return formID;
	}


	public void setFormID(int formID) {
		this.formID = formID;
	}


	public int getEmpID() {
		return empID;
	}


	public void setEmpID(int empID) {
		this.empID = empID;
	}


	public Date getSubDate() {
		return subDate;
	}


	public void setSubDate(Date subDate) {
		this.subDate = subDate;
	}


	public float getCost() {
		return cost;
	}


	public void setCost(float cost) {
		this.cost = cost;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getJustification() {
		return justification;
	}


	public void setJustification(String justification) {
		this.justification = justification;
	}


	public int getDaysMissed() {
		return daysMissed;
	}


	public void setDaysMissed(int daysMissed) {
		this.daysMissed = daysMissed;
	}


	public boolean isUrgent() {
		return urgent;
	}


	public void setUrgent(boolean urgent) {
		this.urgent = urgent;
	}


	public int getEventID() {
		return eventID;
	}


	public void setEventID(int eventID) {
		this.eventID = eventID;
	}


	public String getEventName() {
		return eventName;
	}


	public void setEventName(String eventName) {
		this.eventName = eventName;
	}


	public Date getEventDate() {
		return eventDate;
	}


	public void setEventDate(Date eventDate) {
		this.eventDate = eventDate;
	}


	public String getEventLocation() {
		return eventLocation;
	}


	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}


	public String getEventDesc() {
		return eventDesc;
	}


	public void setEventDesc(String eventDesc) {
		this.eventDesc = eventDesc;
	}


	public int getEventPercent() {
		return eventPercent;
	}


	public void setEventPercent(int eventPercent) {
		this.eventPercent = eventPercent;
	}


	public int getGradeFormatID() {
		return gradeFormatID;
	}


	public void setGradeFormatID(int gradeFormatID) {
		this.gradeFormatID = gradeFormatID;
	}


	public String getGradeFormatName() {
		return gradeFormatName;
	}


	public void setGradeFormatName(String gradeFormatName) {
		this.gradeFormatName = gradeFormatName;
	}


	public String getPassingGrade() {
		return passingGrade;
	}


	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}


	@Override
	public String toString() {
		return "Form [formID=" + formID + ", empID=" + empID + ", subDate=" + subDate + ", cost=" + cost + ", status="
				+ status + ", justification=" + justification + ", daysMissed=" + daysMissed + ", urgent=" + urgent
				+ ", eventID=" + eventID + ", eventName=" + eventName + ", eventDate=" + eventDate + ", eventLocation="
				+ eventLocation + ", eventDesc=" + eventDesc + ", eventPercent=" + eventPercent + ", gradeFormatID="
				+ gradeFormatID + ", gradeFormatName=" + gradeFormatName + ", passingGrade=" + passingGrade + "]";
	}
 
    
}
