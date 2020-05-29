package com.trms.beans;

public class GradeFormat {
	
	 private int gfID;
	 private String gfName;
	 private String gfPassGrade;
	 
	public GradeFormat() {
		super();

	}

	public GradeFormat(int gfID, String gfName, String gfPassGrade) {
		super();
		this.gfID = gfID;
		this.gfName = gfName;
		this.gfPassGrade = gfPassGrade;
	}

	public int getGfID() {
		return gfID;
	}

	public void setGfID(int gfID) {
		this.gfID = gfID;
	}

	public String getGfName() {
		return gfName;
	}

	public void setGfName(String gfName) {
		this.gfName = gfName;
	}

	public String getGfPassGrade() {
		return gfPassGrade;
	}

	public void setGfPassGrade(String gfPassGrade) {
		this.gfPassGrade = gfPassGrade;
	}
	    
	
}
