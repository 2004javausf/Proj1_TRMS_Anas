package com.trms.beans;

import java.io.Serializable;

public class User implements Serializable{
	private static final long serialVersionUID = -7011494003480798587L;
	
	private int userID;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String position;
	private double accBalance;
	
	
	// Constructors
	public User() {
		super();
	}

	public User(String username, String password, String firstName, String lastName, String position,
			double accBalance) {
		super();
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.accBalance = accBalance;
	}
	
	public User(int userID, String username, String password, String firstName, String lastName, String position,
			double accBalance) {
		super();
		this.userID = userID;
		this.username = username;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.position = position;
		this.accBalance = accBalance;
	}

	// Setter & Getter Methods
	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public double getAccBalance() {
		return accBalance;
	}


	public void setAccBalance(double accBalance) {
		this.accBalance = accBalance;
	}

	public int getUserID() {
		return userID;
	}

	public void setUserID(int userID) {
		this.userID = userID;
	}

	@Override
	public String toString() {
		return "User [userID=" + userID + ", username=" + username + ", password=" + password + ", firstName="
				+ firstName + ", lastName=" + lastName + ", position=" + position + ", accBalance=" + accBalance + "]";
	}
	
}
