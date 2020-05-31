package com.trms.beans;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Form {
          
	private int formID;
	private int userID;
    private String fName;
    private String lName;
    private double cost; 
    private double reimbursement;
  
    private String eType;
    private Date eventDate; 
    private String eventLocation;        
    private String desc;   
    private int formLvl;
    
    private String gFormat;
    private String passingGrade;
    private String finalGrade;
       
	private String justification; 
	private int daysMissed;
    private String status; 
	
    
    public Form() {
		super();
		// TODO Auto-generated constructor stub
	}
	
    
	public Form(int formID, int userID, String fName, String lName, double cost, double reimbursement, String eType,
			Date eventDate, String eventLocation, String desc, int formLvl, String gFormat, String passingGrade,
			String finalGrade, String justification, int daysMissed, String status) {
		super();
		this.formID = formID;
		this.userID = userID;
		this.fName = fName;
		this.lName = lName;
		this.cost = cost;
		this.reimbursement = reimbursement;
		this.eType = eType;
		this.eventDate = eventDate;
		this.eventLocation = eventLocation;
		this.desc = desc;
		this.formLvl = formLvl;
		this.gFormat = gFormat;
		this.passingGrade = passingGrade;
		this.finalGrade = finalGrade;
		this.justification = justification;
		this.daysMissed = daysMissed;
		this.status = status;
	}



	public int getFormID() {
		return formID;
	}


	public void setFormID(int formID) {
		this.formID = formID;
	}


	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}


	public String getlName() {
		return lName;
	}


	public void setlName(String lName) {
		this.lName = lName;
	}


	public double getCost() {
		return cost;
	}


	public void setCost(double cost) {
		this.cost = cost;
	}


	public double getReimbursement() {
		return reimbursement;
	}


	public void setReimbursement(double reimbursement) {
		this.reimbursement = reimbursement;
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


	public String getDesc() {
		return desc;
	}


	public void setDesc(String desc) {
		this.desc = desc;
	}


	public int getFormLvl() {
		return formLvl;
	}


	public void setFormLvl(int eventPercent) {
		this.formLvl = eventPercent;
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


	public String getgFormat() {
		return gFormat;
	}


	public void setgFormat(String gFormat) {
		this.gFormat = gFormat;
	}


	public String getPassingGrade() {
		return passingGrade;
	}


	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}


	public String getFinalGrade() {
		return finalGrade;
	}


	public void setFinalGrade(String finalGrade) {
		this.finalGrade = finalGrade;
	}

	public int getUserID() {
		return userID;
	}


	public void setUserID(int userID) {
		this.userID = userID;
	}


	public String geteType() {
		return eType;
	}


	public void seteType(String eType) {
		this.eType = eType;
	}

	@Override
	public String toString() {
		return "Form [formID=" + formID + ", userID=" + userID + ", eType=" + eType + ", fName=" + fName + ", lName="
				+ lName + ", cost=" + cost + ", reimbursement=" + reimbursement + ", eventDate=" + eventDate
				+ ", eventLocation=" + eventLocation + ", desc=" + desc + ", formLvl=" + formLvl + ", gFormat="
				+ gFormat + ", passingGrade=" + passingGrade + ", finalGrade=" + finalGrade + ", justification="
				+ justification + ", daysMissed=" + daysMissed + ", status=" + status + "]";
	}
    
}
